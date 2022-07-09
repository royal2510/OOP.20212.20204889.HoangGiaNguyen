package hust.soict.dsai.aims.screen.manager;
import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
  
// class GridLayout extends JFrame
public class addCDToStore extends JFrame {
	Store store = new Store();
	addCDToStore() {
		JFrame frame = new JFrame("Add CD To Store");
	    
	    JPanel p1 = new JPanel();
	    p1.setLayout(new GridLayout(7, 2));
	  	     
	    FlowLayout layout = new FlowLayout();
	    JPanel p2 = new JPanel();
	    p2.setLayout(layout);
	  
	    JLabel one = new JLabel("  TITLE");
	    JTextField jtitle = new JTextField(200);
	  
	    JLabel two = new JLabel("  CATEGORY");
	    JTextField jcategory = new JTextField(200);
	  
	    JLabel three = new JLabel("  DIRECTOR");
	    JTextField jdirector = new JTextField(200);
	  
	    JLabel four = new JLabel("  COST");
	    JTextField jcost = new JTextField(200);
	  
	    JLabel five = new JLabel("  LENGTH");
	    JTextField jlength = new JTextField(200);
	  
	    JLabel six = new JLabel("  ARTIST");
	    JTextField jartist = new JTextField(200);
	    
	    JLabel seven = new JLabel(" NUMBER OF TRACKS");
	    JTextField jtrack = new JTextField(100);
	  
	    JButton buttonConfirm = new JButton("OK");
	    Button buttonExit = new Button("EXIT");
	    frame.getRootPane().setDefaultButton(buttonConfirm);

	    buttonConfirm.setBounds(50, 100, 60, 30);
	    buttonExit.setBounds(60, 100, 60, 30);
	    
	    buttonConfirm.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	CompactDisc cd = new CompactDisc(jtitle.getText(), jcategory.getText(), jdirector.getText(), Float.parseFloat(jcost.getText()),Integer.parseInt(jlength.getText()) , jartist.getText());
	        	store.addMedia(cd);
	        	frame.dispose();	
	        	new StoreManagerScreen(store);
	        	JOptionPane.showMessageDialog(null, "Successfully added CD named " + jtitle.getText() + " to the store!","Message", JOptionPane.INFORMATION_MESSAGE);
	        }
	    });
	    
	    buttonExit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	frame.dispose();
	        	new StoreManagerScreen(store);

	        }
	    });
	    
	    p1.add(one); 
	    p1.add(jtitle);
	    p1.add(two);
	    p1.add(jcategory);
	    p1.add(three);
	    p1.add(jdirector);
	    p1.add(four);
	    p1.add(jcost);
	    p1.add(five);
	    p1.add(jlength);
	    p1.add(six);
	    p1.add(jartist);
	    p1.add(seven);
	    p1.add(jtrack);
	    
	    p2.add(buttonConfirm);
	    p2.add(buttonExit);
	  
	    frame.add(p1, "North");
	    frame.add(p2, "South");
	
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(560, 215);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	}
  
}