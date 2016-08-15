//
//	Name: Santos, Patrick
//	Project: 4
//	Due: 12/4/2015
//	Course: CS-245-01-f15
//
//	Description: Implement a copy of windows notepad with features that are bolded
//	




import java.awt.EventQueue;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class JNotepad implements ActionListener {
	public static JTextArea textArea;
	private JFrame frame;
	JMenuBar jmb;
	JMenu jmFile;
	JMenuItem jmiNew;
	JMenuItem jmiOpen;
	JMenuItem jmiSave;
	JMenuItem jmiSaveAs;
	JMenuItem jmiPageSetup;
	JMenuItem jmiPrint;
	JMenuItem jmiExit;
	JMenu jmEdit;
	JMenu jmFormat;
	JMenu jmView;
	JMenu jmHelp;
	JMenuItem jmiViewHelp;
	JMenuItem jmiAboutJnotepad;
	JMenuItem jmiStatusBar;
	JMenuItem jmiFont;
	JMenuItem jmiUndo;
	JMenuItem jmiCut;
	JMenuItem jmiCopy;
	JMenuItem jmiPaste;
	JMenuItem jmiDelete;
	JMenuItem jmiFind;
	JMenuItem jmiFindNext;
	JMenuItem jmiReplace;
	JMenuItem jmiGoTo;
	JMenuItem jmiSelectAll;
	JMenuItem jmiTimedate;
	JSeparator separator;
	JSeparator separator_1;
	JSeparator separator_2;
	JSeparator separator_3;
	JSeparator separator_4;
	JSeparator separator_5;
	JPopupMenu popupMenu;
	JFileChooser fc;
	JTextArea log;
	Boolean newFile = true;
	File openFile;
	JPanel about;
	int index = 0;
	String text, next;
	JCheckBoxMenuItem jcbmiWordWrap;
	JDialog dialog;
	JTextField tf;
	FontSelection fs;
	JMenuItem jmiSelectAll2;
	JMenuItem jmiDelete2;
	JMenuItem jmiCut2;
	JMenuItem jmiCopy2;
	JMenuItem jmiPaste2;
	JMenu jmColor;
	JMenuItem jmiRed;
	JMenuItem jmiBlue;
	JMenuItem jmiWhite;


	JNotepad(){
		ImageIcon img = new ImageIcon("JNotepad.png");
		frame = new JFrame("JNotepad");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(img.getImage());

		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		fc.setFileFilter(new FileNameExtensionFilter("Text files", "java", "txt"));
		fc.setFileFilter(new FileNameExtensionFilter("Java files", "java"));
		
		jmb = new JMenuBar();
		frame.setJMenuBar(jmb);
		
		jmFile = new JMenu("File");
		jmFile.setMnemonic('F');
		jmb.add(jmFile);
		
		jmiNew = new JMenuItem("New");
		jmiNew.addActionListener(this);
		jmiNew.setMnemonic('N');
		jmiNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		jmFile.add(jmiNew);
		
		jmiOpen = new JMenuItem("Open..");
		jmiOpen.addActionListener(this);
		jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
		jmFile.add(jmiOpen);
		
		jmiSave = new JMenuItem("Save");
		jmiSave.addActionListener(this);
		jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));		
		jmFile.add(jmiSave);
		
		jmiSaveAs = new JMenuItem("Save As...");
		jmiSaveAs.addActionListener(this);
		jmFile.add(jmiSaveAs);
		jmFile.addSeparator();
		
		jmiPageSetup = new JMenuItem("Page Setup...");
		jmFile.add(jmiPageSetup);
		
		jmiPrint = new JMenuItem("Print...");
		jmiPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));	
		jmFile.add(jmiPrint);
		jmFile.addSeparator();
		
		jmiExit = new JMenuItem("Exit");
		jmiExit.addActionListener(this);
		jmiExit.setMnemonic('X');
		jmFile.add(jmiExit);
		
		// Work on the edit menu
		jmEdit = new JMenu("Edit");
		jmEdit.setMnemonic('E');
		jmb.add(jmEdit);
		
		jmiUndo = new JMenuItem("Undo");
		jmEdit.add(jmiUndo);
		jmiUndo.addActionListener(this);
		jmEdit.addSeparator();
		
		jmiCut = new JMenuItem("Cut");
		jmiCut.addActionListener(this);
		jmiCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));	
		jmEdit.add(jmiCut);
		
		jmiCopy = new JMenuItem("Copy");
		jmiCopy.addActionListener(this);
		jmiCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));	
		jmEdit.add(jmiCopy);
		
		jmiPaste = new JMenuItem("Paste");
		jmiPaste.addActionListener(this);
		jmEdit.add(jmiPaste);
		jmiPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));	
		jmEdit.add(jmiPaste);
		
		jmiDelete = new JMenuItem("Delete");
		jmiDelete.addActionListener(this);
		jmiDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		jmEdit.add(jmiDelete);
		jmEdit.addSeparator();
		
		jmiFind = new JMenuItem("Find...");
		jmiFind.addActionListener(this);
		jmiFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
				InputEvent.CTRL_MASK));	
		jmEdit.add(jmiFind);
		
		jmiFindNext = new JMenuItem("Find Next");
		jmEdit.add(jmiFindNext);
		
		jmiReplace = new JMenuItem("Replace...");
		jmiReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
				InputEvent.CTRL_MASK));
		jmEdit.add(jmiReplace);
		
		jmiGoTo = new JMenuItem("Go To...");
		jmiGoTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				InputEvent.CTRL_MASK));
		jmEdit.add(jmiGoTo);
		jmEdit.addSeparator();
		
		jmiSelectAll = new JMenuItem("Select All");
		jmiSelectAll.addActionListener(this);
		jmiSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		jmEdit.add(jmiSelectAll);

		jmiTimedate = new JMenuItem("Time/Date");
		jmiTimedate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		jmiTimedate.addActionListener(this);
		jmEdit.add(jmiTimedate);

		jmFormat = new JMenu("Format");
		jmFormat.setMnemonic('O');
		jmb.add(jmFormat);

		jcbmiWordWrap= new JCheckBoxMenuItem("Word Wrap");
		jcbmiWordWrap.addActionListener(this);
		jcbmiWordWrap.setMnemonic('W');
		jmFormat.add(jcbmiWordWrap);

		jmiFont = new JMenuItem("Font...");
		jmiFont.setMnemonic('F');
		jmiFont.addActionListener(this);
		jmFormat.add(jmiFont);
		
		jmColor = new JMenu("Background Color");
		jmFormat.add(jmColor);
		jmiBlue = new JMenuItem("Blue");
		jmiBlue.addActionListener(this);
		jmiRed = new JMenuItem("Red");
		jmiRed.addActionListener(this);
		jmiWhite = new JMenuItem("White");
		jmiWhite.addActionListener(this);
		jmColor.add(jmiBlue);
		jmColor.add(jmiRed);
		jmColor.add(jmiWhite);

		jmView = new JMenu("View");
		jmView.setMnemonic('V');
		jmb.add(jmView);

		jmiStatusBar = new JMenuItem("Status Bar",'S');
		
		jmView.add(jmiStatusBar);

		jmHelp = new JMenu("Help");
		jmHelp.setMnemonic('H');
		jmb.add(jmHelp);

		jmiViewHelp = new JMenuItem("View Help");
		jmiViewHelp.setMnemonic('H');
		jmHelp.add(jmiViewHelp);
		jmHelp.addSeparator();

		jmiAboutJnotepad = new JMenuItem("About JNotepad");
		jmiAboutJnotepad.addActionListener(this);
		jmHelp.add(jmiAboutJnotepad);
		//////////////////////END OF MENUS//////////////////////////////
		
		about = new JPanel();
		about.add(new JLabel("(c) Patrick Santos"));
		
		textArea = new JTextArea();
		textArea.setInheritsPopupMenu(true);
		JScrollPane jsp = new JScrollPane(textArea);
		frame.add(jsp, BorderLayout.CENTER);

		JPopupMenu popupMenu = new JPopupMenu();
	
		addPopup(textArea, popupMenu);

		jmiCut2 = new JMenuItem("Cut");
		jmiCut2.addActionListener(this);
		jmiCut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));	
		popupMenu.add(jmiCut);
		
		jmiCopy2 = new JMenuItem("Copy");
		jmiCopy2.addActionListener(this);
		jmiCopy2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));	
		popupMenu.add(jmiCopy2);
		
		jmiPaste2 = new JMenuItem("Paste");
		jmiPaste2.addActionListener(this);
		jmiPaste2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_MASK));	
		popupMenu.add(jmiPaste2);
		
		jmiDelete2 = new JMenuItem("Delete");
		jmiDelete2.addActionListener(this);
		jmiDelete2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0));
		popupMenu.add(jmiDelete2);
	
	
		jmiSelectAll2 = new JMenuItem("Select All");
		jmiSelectAll2.addActionListener(this);
		jmiSelectAll2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		popupMenu.add(jmiSelectAll2);
		
		textArea.setFont(new Font("Courier",Font.PLAIN,12));
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}	


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jmiNew) { // new document
			textArea.setText("");
			newFile = true;
		}
		if (e.getSource() == jmiOpen) { // open document
			int returnVal = fc.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				openFile = fc.getSelectedFile();
				try {
					textArea.setText(fileReader(openFile.getPath()));
					frame.setTitle(openFile.getName() + " - JNotepad");
					newFile = false;
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}
		if (e.getSource() == jmiSave) { // save document, if document is new,
											// then SaveAs is used
			if (newFile == true) {
				saveAs();
			} else
				save(openFile);
		}
		if (e.getSource() == jmiSaveAs) { // save as menu item (method below)
			saveAs();
		}
		if (e.getSource() == jmiExit) { // exit menu item asks if user wants to
											// save
			int result = JOptionPane.showConfirmDialog(frame,
					"Do you wish to save changes to this document?");
			if (JOptionPane.YES_OPTION == result) {
				if (newFile == true) {
					saveAs();
				} else
					save(openFile);
				System.exit(1);
			} else if (JOptionPane.NO_OPTION == result)
				System.exit(1);
		}
		if (e.getSource() == jmiCut || e.getSource() == jmiCut2) { // cut selected text
			textArea.cut();
		}
		if (e.getSource() == jmiCopy || e.getSource() == jmiCopy2 ) { // copy selected text
			textArea.copy();
		}
		if (e.getSource() == jmiPaste || e.getSource() == jmiPaste2) { // paste selected text
			textArea.paste();
		}
		if (e.getSource() == jmiDelete || e.getSource() == jmiDelete2) { // delete selected text
			textArea.replaceSelection("");
			
		}
	
		if (e.getSource() == jmiFind) { // find selected text, searches for
											// text first, then sets caret and
											// selection positions
				final JFrame frame2 = new JFrame("Find");
				frame2.setLayout(new GridLayout(3,3));
				frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame2.setSize(300,150);
				frame2.setLocationRelativeTo(null);
				JPanel blank1 = new JPanel ();
				JPanel blank2 = new JPanel ();
				final JRadioButton up = new JRadioButton ("Up");
				JRadioButton down = new JRadioButton ("Down");
				JLabel findWhat = new JLabel("Find What:");
				JLabel direction = new JLabel("Direction");
				JButton findNext = new JButton ("Find");
				JButton cancel = new JButton ("Cancel");
				final JTextField jtf = new JTextField();
				frame2.add(findWhat);
				frame2.add(jtf);
				frame2.add(findNext);
				frame2.add(blank1);
				frame2.add(direction);
				frame2.add(cancel);
				frame2.add(blank2);
				frame2.add(up);
				frame2.add(down);
				ButtonGroup bg = new ButtonGroup();
				bg.add(up);
				bg.add(down);
				frame2.setVisible(true);
				text = textArea.getText();
		    	up.setSelected(true);			
					findNext.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent evt) {
					    	try{  	
					    		String searched= jtf.getText();
					    		if(up.isSelected())
					    		{
					    			index = text.indexOf(searched, 0);
					    			textArea.setCaretPosition(index);
					    			textArea.setSelectionStart(index);
					    			textArea.setSelectionEnd(index + searched.length());
					    		}	
					    		else
					    		{
					    			index = text.lastIndexOf(searched);
					    			textArea.setCaretPosition(index);
					    			textArea.setSelectionStart(index);
					    			textArea.setSelectionEnd(index + searched.length());
					    		}		
					    	}
					    	catch(IllegalArgumentException ae)
					    	{
					    		JOptionPane.showMessageDialog(frame2,
								    "Text not found.", "Notepad",
								    JOptionPane.INFORMATION_MESSAGE);
					    	}
					    	}});
						cancel.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								frame2.setVisible(false);
							}
						});	
			}

		if (e.getSource() == jmiSelectAll) { //select all text in textArea
			textArea.selectAll();
		}
		if (e.getSource() == jmiTimedate) { //prints time and date to Text Area
			DateFormat formatter = new SimpleDateFormat("HH:mm MM-dd-yyyy");
			Date date = new Date();
			textArea.append(formatter.format(date));
		}
		if (e.getSource() == jcbmiWordWrap) {//sets word wrap
			textArea.setLineWrap(jcbmiWordWrap.getState());
		}
		if (e.getSource() == jmiFont) { //sets font, see font class
			fs = new FontSelection();
		}

		if (e.getSource() == jmiAboutJnotepad) { //displays about message
			JOptionPane.showMessageDialog(frame, "(C) 2015 Patrick Santos",
					"About", 1);
		}
		if (e.getSource() == jmiBlue) { 
			textArea.setBackground(Color.blue);
		}
		if (e.getSource() == jmiRed) { 
			textArea.setBackground(Color.red);
		}	
		if (e.getSource() == jmiWhite) { 
			textArea.setBackground(Color.white);
		}	
	}

	public void saveAs() {
		int returnVal = fc.showSaveDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			openFile = fc.getSelectedFile();
			save(openFile);
			log.append("Saving: " + openFile.getName() + ".\n");
		}
	}


	public void save(File file) {
		try {
			FileWriter fw = new FileWriter(file);
			String temp = textArea.getText();
			fw.write(temp);
			newFile = false;
			frame.setTitle(file.getName() + " - JNotepad");
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	public String fileReader(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String all = null;
		try {
			StringBuilder builder = new StringBuilder();
			String line = reader.readLine();

			while (line != null) {
				builder.append(line);
				builder.append(System.lineSeparator());
				line = reader.readLine();
			}
			all = builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} 
			
		reader.close();
		return all;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					JNotepad window = new JNotepad();
					window.frame.setVisible(true);
			}
		});
	}	
		
}
