<<<<<<< HEAD
package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20; 
	public static ArrayList<Media> itemsOrdered= new ArrayList<Media>();

	public void addMedia(Media media) {
		itemsOrdered.add(media);
	}
	
	public static void removeMedia(Media media) {
		itemsOrdered.remove(media);
	}
	
	public static float totalCost(){
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	public static DigitalVideoDisc[] sortByNameCostLength(DigitalVideoDisc [] dvdList){
		Comparator<DigitalVideoDisc> nameSort = Comparator.comparing(DigitalVideoDisc::getTitle);
		Comparator<DigitalVideoDisc> costSort = Comparator.comparing(DigitalVideoDisc::getCost, Comparator.reverseOrder());
		Comparator<DigitalVideoDisc> lengthSort = Comparator.comparing (DigitalVideoDisc::getLength, Comparator.reverseOrder());
		Comparator<DigitalVideoDisc> multipleFieldComparator = nameSort.thenComparing(costSort).thenComparing(lengthSort);
		Arrays.sort(dvdList, multipleFieldComparator); 
		return dvdList;	
	}
	public void print(){
		System.out.println("***********************CART*********************** \nOrdered Items:\n");
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i+1) + ". DVD - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getDirector() + " - " + itemsOrdered.get(i).getLength() + " - " + itemsOrdered.get(i).getCost() + "$");
			sum += itemsOrdered.get(i).getCost();
		}
		System.out.println("Total sum: " +  sum + "$");
		System.out.println("***************************************************");
	}
	public static void mediaSearchById(int id) {
		boolean found = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				found = true;
				System.out.println("The DVD with ID: " + id + " is " + itemsOrdered.get(i).getTitle());
				break;  
			}
		}
		if (found == false) {
			System.out.println("Cannot found the DVD with ID: " + id);
		}
	}
	
	public static boolean isMatch(String title) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input keyword: ");
		String keyword = keyboard.nextLine();
		if(title.contains(keyword)) {
			return true;
		}
		return false;
	}
	
	public static void showCart() {
		System.out.println("***********************Cart*********************** \nCart Items: \n");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i+1) + ". DVD - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCategory() + " - " + itemsOrdered.get(i).getDirector() + " - " + itemsOrdered.get(i).getLength() + " - " + itemsOrdered.get(i).getCost() + "$");
		}
		System.out.println("***************************************************");
	}
	public static void remove() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Choose the title that you want to remove: ");
		String title = keyboard.nextLine();
		for (int i = 0; i < itemsOrdered.size(); i++ ) {
			if(itemsOrdered.get(i).getTitle().equals(title)) {
				removeMedia(itemsOrdered.get(i));
			}
		}
		System.out.println("Removed successfully");
	}
	public static void cartSortByTitle(ArrayList<Media> itemsOrdered) {
		Comparator<Media> nameSort = Comparator.comparing(Media::getTitle);
		Comparator<Media> costSort = Comparator.comparing(Media::getCost);
		Comparator<Media> multipleFieldComparator = nameSort.thenComparing(costSort);
		Collections.sort(itemsOrdered, multipleFieldComparator); 
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).getTitle());
		}
	}
	public static void cartSortByCost(ArrayList<Media> itemsOrdered) {
		Comparator<Media> costSort = Comparator.comparing(Media::getCost);
		Collections.sort(itemsOrdered, costSort);
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).getTitle());
		}
	}
	public static void cartFilter() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input keyword: ");
		String keyword = keyboard.nextLine();
		boolean avail = false;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getTitle().contains(keyword)) {
				avail = true;
				System.out.println(itemsOrdered.get(i).getTitle());
			}
		}
		if (avail == false) {
			System.out.println("No match found.");
		}
	}
	
	public Media getALuckyItem(){
		int rand = (int) Math.random();
		
		return itemsOrdered.get(rand);
		
	}

}

=======
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

>>>>>>> 72acdd27e81236a6775ba922af00d451ad39b784
