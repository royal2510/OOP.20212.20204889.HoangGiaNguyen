package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
	
	private static List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	public static void addDVD(DigitalVideoDisc disc) {
		itemsInStore.add(disc);
		System.out.println("The disc has been added to store");
	}

	public static void removeDVD(DigitalVideoDisc disc) {
		itemsInStore.remove(disc);
	}
	public static void print(){
		System.out.println("***********************Store*********************** \nAvailable Items:\n");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i+1) + ". DVD - " + itemsInStore.get(i).getTitle() + " - " + itemsInStore.get(i).getCategory() + " - " + itemsInStore.get(i).getDirector() + " - " + itemsInStore.get(i).getLength() + " - " + itemsInStore.get(i).getCost() + "$");
		}
		System.out.println("***************************************************");
	}
	public static void dvdDetail() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the title: ");
		String title = keyboard.nextLine();
		boolean found = false;
		for(int i = 0; i< itemsInStore.size(); i++) {
			System.out.println(i);
			if (itemsInStore.get(i).getTitle().equals(title)) {
				System.out.println("Title: " + itemsInStore.get(i).getTitle());
				System.out.println("Category: " + itemsInStore.get(i).getCategory());
				System.out.println("Director: " + itemsInStore.get(i).getDirector());
				System.out.println("Length: " + itemsInStore.get(i).getLength());
				System.out.println("Cost: " + itemsInStore.get(i).getCost() + "$");
				found = true;
			}
		}	
		if(found == false) {
			System.out.println("Not found");
		}
	}
	
	public static void updateStore() {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.println("Add or Remove ?(Choose 0/1)");
			int chosen = keyboard.nextInt();
			if (chosen == 0) {
				System.out.println("Input the dvd's title: ");
				keyboard.nextLine();
				String title1 = keyboard.nextLine();
				System.out.println("Input the dvd's category: ");
				String category = keyboard.nextLine(); 
				System.out.println("Input the dvd's director: ");
				String director = keyboard.nextLine(); 
				System.out.println("Input the dvd's length: ");
				int length = keyboard.nextInt();
				System.out.println("Input the dvd's cost: ");
				float cost = keyboard.nextFloat();

				itemsInStore.add(new DigitalVideoDisc(title1, category, director,length, cost));
				print();
				showMenu();
				break;
			}
			if (chosen == 1) {
				System.out.println("Choose the title that you want to remove: ");
				keyboard.nextLine();
				String title = keyboard.nextLine();
				for (int i = 0; i < itemsInStore.size(); i++ ) {
					if(itemsInStore.get(i).getTitle().equals(title)) {
						itemsInStore.remove(itemsInStore.get(i));
					}
				}
				System.out.println("Removed successfully");
				print();
				showMenu();
				break;
			}
			else {
				System.out.println("Invalid input. Please input 0(Add) or 1(Remove)");
			}
		}
	}
	
	public static void showMenu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("AIMS: "); 
		System.out.println("---------------------------------");
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("---------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		int choice = keyboard.nextInt();
		if (choice == 1) {
			print();
			storeMenu();
		}
		if (choice == 2){
			updateStore();
		}
		if (choice == 0) {
			System.exit(1);
		}
		if (choice == 3) {
			
		}
	}
	public static void storeMenu() {
		System.out.println("Options: "); 
		System.out.println("---------------------------------"); 
		System.out.println("1. See a DVD's details"); 
		System.out.println("2. Add a DVD to cart"); 
		System.out.println("3. See current cart");
		System.out.println("0. Back"); 
		System.out.println("---------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		if (choice == 0) {
			print();
			showMenu();
		}
		if (choice == 1) {
			dvdDetail();
		}
		if (choice == 2) {
			
		}
	}
	public static void cartMenu() {
		Cart cart = new Cart();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Options: "); 
		System.out.println("-----------------------------------"); 
		System.out.println("1. Filter DVDs in cart"); 
		System.out.println("2. Sort DVDs in cart"); 
		System.out.println("3. Remove DVD from cart"); 
		System.out.println("4. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("-----------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int choice = keyboard.nextInt();
		while (true) {
			if(choice == 1) {
				
			}
		}
		
	}
}
