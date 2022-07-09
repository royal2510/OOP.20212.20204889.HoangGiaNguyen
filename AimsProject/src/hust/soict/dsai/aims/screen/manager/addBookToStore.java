package hust.soict.dsai.aims.screen.manager;
import javax.swing.*;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
  
// class GridLayout extends JFrame
public class addBookToStore extends JFrame {
	Store store = new Store();
	addBookToStore() {
		JFrame frame = new JFrame("Add Book To Store");
	    
	    JPanel p1 = new JPanel();
	    p1.setLayout(new GridLayout(6, 2));
	  	    
	    FlowLayout layout = new FlowLayout();
	    JPanel p2 = new JPanel();
	    p2.setLayout(layout);
	  
	    JLabel one = new JLabel(" \t TITLE");
	    JTextField jtitle = new JTextField(200);
	  
	    JLabel two = new JLabel(" \t CATEGORY");
	    JTextField jcategory = new JTextField(200);
	  
	    JLabel three = new JLabel(" \t COST");
	    JTextField jcost = new JTextField(200);
	  
	    JLabel four = new JLabel("  \tAUTHORS");
	    JTextField jauthor = new JTextField(200);
	    
	    JLabel five = new JLabel("  \tCONTENT");
	    JTextField jcontent = new JTextField(1000);
	  
	    JButton buttonConfirm = new JButton("OK");
	    Button buttonExit = new Button("EXIT");
	    frame.getRootPane().setDefaultButton(buttonConfirm);
	    
	    buttonConfirm.setBounds(50, 100, 60, 30);
	    buttonExit.setBounds(60, 100, 60, 30);
	    buttonConfirm.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Book book = new Book(jtitle.getText(), jcategory.getText(), Float.parseFloat(jcost.getText()), Arrays.asList(jauthor.getText().split("\\s*,\\s*"))  ,jcontent.getText());
	        	store.addMedia(book);
	        	frame.dispose();
	        	new StoreManagerScreen(store);
	        	JOptionPane.showMessageDialog(null, "Successfully added book named " + jtitle.getText() +" to the store!","Message", JOptionPane.INFORMATION_MESSAGE);
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
	    p1.add(jcost);
	    p1.add(four);
	    p1.add(jauthor);
	    p1.add(five);
	    p1.add(jcontent);
	    
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