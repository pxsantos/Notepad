
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/*
 * Class to create a new frame in order to select the font for the document
 * uses a JComboBox in order to select font sizes and fonts.
 */
public class FontSelection implements ActionListener {
	JFrame frame;
	JPanel panel1, panel2, panel3;
	JLabel fontName, fontSize, fontStyle,sample,example ;
	JComboBox jcbFonts, jcbSizes;
	JTextArea jtxtWelcome;
	JButton ok;
	Font f;
	JComboBox jcbStyles;
	int style=0;
	
	FontSelection() {
		frame = new JFrame(); //set up frame constraints
		frame.setTitle("Set Font");
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(3,3));
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		fontName = new JLabel("Font Name");
		fontSize = new JLabel("Font Size");
		fontStyle = new JLabel("Font Style");
		ok = new JButton("Ok");
		

		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment() //get list of avaible fonts on the system
				.getAvailableFontFamilyNames();
		String[] styles = {"Regular","Italic","Bold","Bold Italic"};
		jcbFonts = new JComboBox(fonts);
		jcbSizes = new JComboBox();
		jcbStyles = new JComboBox(styles);
		for (int i = 10; i < 40; i++) { //sets different sizes of fonts 10 to 40 in intervals of 2
			jcbSizes.addItem(i);
			i++;
		}
		jcbFonts.addActionListener(this);
		jcbSizes.addActionListener(this);
		jcbStyles.addActionListener(this);
		panel1.add(fontName);
		panel1.add(jcbFonts);
		panel2.add(fontStyle);
		panel2.add(jcbStyles);

		panel3.add(fontSize);
		panel3.add(jcbSizes);
		JPanel panel4 = new JPanel();
		
		JPanel panel5 = new JPanel();
		
		JPanel panel6 = new JPanel();
		sample = new JLabel("Sample:",SwingConstants.RIGHT);
		panel6.add(sample);
		example = new JLabel("The quick brown fox jumps over the lazy dog");
		panel6.add(example);
		
		JPanel panel7 = new JPanel();
		
		JPanel panel8 = new JPanel();

		JPanel panel9 = new JPanel();
		panel9.add(ok);

		frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(panel5);
		frame.add(panel6);
		frame.add(panel7);
		frame.add(panel8);
		frame.add(panel9);

		ok.addActionListener(this);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	 // Listener for the Combo Boxes and the button
	 
		public void actionPerformed(ActionEvent e) throws NullPointerException {
			// action listener for ok button
			if (e.getSource() == ok  && jcbStyles.getSelectedIndex()==0) {
				JNotepad.textArea.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.PLAIN, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
				frame.setVisible(false);
			}
			else if (e.getSource() == ok  && jcbStyles.getSelectedIndex()==1) {
				JNotepad.textArea.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.ITALIC, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
				frame.setVisible(false);
			}	
			else if (e.getSource() == ok  && jcbStyles.getSelectedIndex()==2) {
				JNotepad.textArea.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.BOLD, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
				frame.setVisible(false);
			}	
			else if (e.getSource() == ok  && jcbStyles.getSelectedIndex()==3) {
				JNotepad.textArea.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.PLAIN|Font.BOLD, Integer 
				.parseInt(jcbSizes.getSelectedItem().toString())));
				frame.setVisible(false);
			}				
			
			// action listeners for jcbStyles
			else if (e.getSource() == jcbStyles && jcbStyles.getSelectedIndex()==0) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.PLAIN, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}
			else if (e.getSource() == jcbStyles && jcbStyles.getSelectedIndex()==1) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.ITALIC, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}	
			else if (e.getSource() == jcbStyles &&jcbStyles.getSelectedIndex()==2) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.BOLD, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}	
			else if (e.getSource() == jcbStyles && jcbStyles.getSelectedIndex()==3) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(),Font.PLAIN|Font.BOLD, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}	
			
			// action listeners for jcbFonts
			else if (e.getSource() == jcbFonts && jcbStyles.getSelectedIndex()==0) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.PLAIN, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}
			else if (e.getSource() == jcbFonts && jcbStyles.getSelectedIndex()==1) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.ITALIC, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}	
			else if (e.getSource() == jcbFonts &&jcbStyles.getSelectedIndex()==2) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.BOLD, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}	
			else if (e.getSource() == jcbFonts && jcbStyles.getSelectedIndex()==3) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(),Font.PLAIN|Font.BOLD, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
				
			}	
			
			// action listeners for jcbSizes
			else if (e.getSource() == jcbSizes ) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.PLAIN, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}
			else if (e.getSource() == jcbSizes && jcbStyles.getSelectedIndex()==1) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.ITALIC, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}	
			else if (e.getSource() == jcbSizes &&jcbStyles.getSelectedIndex()==2) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(), Font.BOLD, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
			}	
			else if (e.getSource() == jcbSizes && jcbStyles.getSelectedIndex()==3) {
				example.setFont(new Font(jcbFonts.getSelectedItem().toString(),Font.PLAIN|Font.BOLD, Integer 
						.parseInt(jcbSizes.getSelectedItem().toString())));
				
			}	
		
	}

	
		

}