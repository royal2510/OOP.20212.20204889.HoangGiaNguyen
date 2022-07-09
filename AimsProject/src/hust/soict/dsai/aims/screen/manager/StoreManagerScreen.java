package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreManagerScreen extends JFrame{
	private Store store;
	
	
	public static void main(String[] args) {
		Store store = new Store();
		Book b1 = new Book("A Brief History of The World", "hehe1", 10, Arrays.asList("aa","bb"), "cc");
		store.addMedia(b1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Liar", "Comedy", "Max",10, (float) 19.99);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Comedy", "Max",10, (float) 29.99);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Doctor Strange", "Comedy", "Max",10, 21);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Destructor", "Comedy", "Max",10, 22);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("24H", "Comedy", "Max",10, 14);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Home Alone", "Comedy", "Max",10, 57);
		
		
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(dvd5);
		store.addMedia(dvd6);
		store.addMedia(dvd7);
		
		new StoreManagerScreen(store);
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu( "Options");
		menu.add(new JMenuItem("View store"));
		JMenu smUpdateStore = new JMenu("Update Store"); 
		smUpdateStore.add(new JMenuItem(new AbstractAction("Add Book") {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new addBookToStore();
			}
		}));
		smUpdateStore.add(new JMenuItem(new AbstractAction("Add DVD") {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new addDVDToStore();
			}
		}));smUpdateStore.add(new JMenuItem(new AbstractAction("Add CD") {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new addCDToStore();
			}
		}));
		menu.add(smUpdateStore);
		JMenuBar menuBar = new JMenuBar(); 
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT)); 
		menuBar.add(menu);
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel(); 
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		JLabel title = new JLabel("STORE MENU"); 
		title. setFont(new Font(title.getFont().getName(), Font.PLAIN, 50)); 
		title. setForeground(Color.RED);
		header.add(Box.createRigidArea(new Dimension(10, 10))); 
		header.add(title); 
		header.add(Box.createHorizontalGlue()); 
		header.add(Box.createRigidArea(new Dimension (10, 10)));
		return header;
	}

	JPanel createCenter() {
		JPanel center = new JPanel(); center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<Media> mediaInStore = store.getItemsInStore(); 
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i)); 
			center.add(cell);
		}
		return center;
	}
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		

		//setLocationRelativeTo(null);
		setLocation(475,150);
		setTitle("Store");
		setSize(1024,768);
		setVisible(true);
	}
	
}