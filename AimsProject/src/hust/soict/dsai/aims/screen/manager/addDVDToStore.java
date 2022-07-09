package hust.soict.dsai.aims.screen.manager;
import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  
// class GridLayout extends JFrame
public class addDVDToStore extends JFrame {
	Store store = new Store();
	addDVDToStore() {
		JFrame frame = new JFrame("Add DVD To Store");
	    
	    JPanel p1 = new JPanel();
	    p1.setLayout(new GridLayout(6, 2));
	  	    
	    FlowLayout layout = new FlowLayout();
	    JPanel p2 = new JPanel();
	    p2.setLayout(layout);
	  
	    JLabel one = new JLabel("  TITLE");
	    JTextField jtitle = new JTextField(200);
	    //String title = jtitle.getText();
	  
	    JLabel two = new JLabel(" CATEGORY");
	    JTextField jcategory = new JTextField(200);
	   // String category = jcategory.getText();
	    
	    JLabel three = new JLabel("  DIRECTOR");
	    JTextField jdirector = new JTextField(200);
	    //String director = jdirector.getText();
	    
	    JLabel four = new JLabel("  LENGTH");
	    JTextField jlength = new JTextField(200);
	    //int length = Integer.parseInt(jlength.getText());
	    
	    JLabel five = new JLabel("  COST");
	    JTextField jcost = new JTextField(1000);
	    //float cost = Float.parseFloat(jcost.getText());
	  
	    JButton buttonConfirm = new JButton("OK");
	    Button buttonExit = new Button("EXIT");
	    frame.getRootPane().setDefaultButton(buttonConfirm);

	    
	    buttonConfirm.setBounds(50, 100, 60, 30);
	    buttonExit.setBounds(60, 100, 60, 30);
	    buttonConfirm.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	DigitalVideoDisc dvd = new DigitalVideoDisc(jtitle.getText(), jcategory.getText(), jdirector.getText(), Integer.parseInt(jlength.getText()), Float.parseFloat(jcost.getText()));
	        	store.addMedia(dvd);
	        	frame.dispose();
	        	new StoreManagerScreen(store);     	
	        	JOptionPane.showMessageDialog(null, "Successfully added DVD named " + jtitle.getText() + " to the store!","Message", JOptionPane.INFORMATION_MESSAGE);
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
	    p1.add(jlength);
	    p1.add(five);
	    p1.add(jcost);
	    
	    p2.add(buttonConfirm);
	    p2.add(buttonExit);
	  
	    frame.add(p1, "North");
	    frame.add(p2, "South");
	
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(560, 200);      
	    frame.setLocationRelativeTo(null);  
	    frame.setVisible(true);
	}
  
}