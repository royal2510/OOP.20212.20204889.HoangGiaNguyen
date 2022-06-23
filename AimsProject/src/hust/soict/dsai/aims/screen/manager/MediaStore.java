package hust.soict.dsai.aims.screen.manager;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media; 
	public MediaStore (Media media) {
		this.media = media; 
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle()); 
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15)); 
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $"); 
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel(); 
		container.setLayout(new FlowLayout(FlowLayout .CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play"); 
			playButton.setForeground(Color.RED);
			container.add(playButton);
			playButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	JFrame frame = new JFrame("Playing media");
		        	JPanel p1 = new JPanel();
		    	    p1.setLayout(new GridLayout(2, 1));
		    	  	    
		    	    FlowLayout layout = new FlowLayout();
		    	    JPanel p2 = new JPanel();
		    	    p2.setLayout(layout);
		    	    
		    	    JLabel one = new JLabel("Playing " + media.getClass().getSimpleName() + ": " + media.getTitle());
		    	    JLabel two = new JLabel("Length: " + media.getLength());
		    	    one.setFont(new Font("Arial", Font.PLAIN, 20));
		    	    two.setFont(new Font("Arial", Font.PLAIN, 20));
		    	    
		    	
		    	    Button buttonExit = new Button("STOP");
		    	    
		    	    buttonExit.addActionListener(new ActionListener() {
		    	        public void actionPerformed(ActionEvent e) {
		    	        	frame.dispose();
		    	        }
		    	    });
		    	    
		    	    p1.add(one);
		    	    p1.add(two);
		    	   
		    	    p2.add(buttonExit);
		    	  
		    	    frame.add(p1, "North");
		    	    frame.add(p2, "South");
		    	
		    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	    frame.setSize(560, 200);      
		    	    frame.setLocationRelativeTo(null);  
		    	    frame.setVisible(true);

		        }
		    });
		}
		this.add(Box.createVerticalGlue()); 
		this.add(title); this.add(cost); 
		this.add(Box.createVerticalGlue()); 
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}