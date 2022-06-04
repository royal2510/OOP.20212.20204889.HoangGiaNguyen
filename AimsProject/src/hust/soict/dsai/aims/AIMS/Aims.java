package hust.soict.dsai.aims.AIMS;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import javax.swing.JOptionPane;
import java.util.Scanner;
import hust.soict.dsai.aims.store.Store.*;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f); 
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("Total cost is: " + anOrder.totalCost());
		
		store.showMenu();
	}
}
