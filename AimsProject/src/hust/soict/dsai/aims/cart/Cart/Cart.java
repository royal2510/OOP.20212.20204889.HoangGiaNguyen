package hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc){		
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	

	
	public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
		int len = dvdList.length;
		if (qtyOrdered + len < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < len; i++) {
			itemsOrdered[qtyOrdered] = dvdList[i];
			qtyOrdered ++;
			System.out.println("The disc has been added");
			}
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			System.out.println("The dvd1 has been added");
			itemsOrdered[qtyOrdered] = dvd2;
			System.out.println("The dvd2 has been added");
			qtyOrdered += 2;
		}

		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle() == disc.getTitle() ){
				qtyOrdered -= 1;
				for  (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
			}
		}
		itemsOrdered[qtyOrdered] = null;
		System.out.println("The disc has been successfully removed");
	}
	public float totalCost(){
		float sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
		
	}
}

