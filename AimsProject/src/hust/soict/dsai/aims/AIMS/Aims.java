package hust.soict.dsai.aims.AIMS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class Aims {
	static ArrayList<Media> itemsInStore = new ArrayList<Media>();;
	static Cart anOrder = new Cart();
	static Store store = new Store();
	
	public static void main(String[] args) {
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		itemsInStore.add(dvd1);
		Book b1 = new Book("The Liar", "Comic", 10, Arrays.asList("John", "Max", "Vu")) ; 
		itemsInStore.add(b1);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f); 
		itemsInStore.add(dvd3);
		
		CompactDisc cd1 = new CompactDisc("Rise Sun");
		itemsInStore.add(cd1);
		
		System.out.println("Total cost is: " + anOrder.totalCost()); 
		//MemoryDaemon daemon = new MemoryDaemon ();
				//daemon.run(); 
		Thread daemon = new Thread(); 
		daemon.setDaemon(true); 
		daemon.start();
		showMenu();
	}
	public static void print(){ 
		
		System.out.println("***********************Store*********************** \nAvailable Items:\n");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i+1) + " - (" + itemsInStore.get(i).getClass().getSimpleName() + ") - " + itemsInStore.get(i).getTitle());

		}
		System.out.println("***************************************************");
	}
	public static void mediaDetail() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the title: ");
		String title = keyboard.nextLine();
		boolean found = false;
		for(int i = 0; i< itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				System.out.println("ID: "+ itemsInStore.get(i).getId());
				System.out.println("Type of Media: "+ itemsInStore.get(i).getClass().getSimpleName());
				System.out.println("Title: " + itemsInStore.get(i).getTitle());
				System.out.println("Category: " + itemsInStore.get(i).getCategory());
				System.out.println("Director: " + itemsInStore.get(i).getDirector());
				System.out.println("Length: " + itemsInStore.get(i).getLength());
				System.out.println("Cost: " + itemsInStore.get(i).getCost() + "$");
				System.out.println("Authors: " + itemsInStore.get(i).getAuthors());
				found = true;
			}
		}	
		if(found == false) {
			System.out.println("Not found");
		}
		showMenu();
	}
	
	public static void updateStore() {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			System.out.println("Add or Remove ?(Choose 0/1)");
			int chosen = keyboard.nextInt();
			if (chosen == 0) {
				System.out.println("Input the media's title: ");
				keyboard.nextLine();
				String title = keyboard.nextLine();
				System.out.println("Input the media's category: ");
				String category = keyboard.nextLine(); 
				System.out.println("Input the media's director: ");
				String director = keyboard.nextLine(); 
				System.out.println("Input the media's length: ");
				int length = keyboard.nextInt();
				System.out.println("Input the media's cost: ");
				float cost = keyboard.nextFloat();

				itemsInStore.add(new Media(title, category, director,length, cost));
				print();
				showMenu();
				break;
			}
			if (chosen == 1) {
				System.out.println("Choose the title that you want to remove: ");
				keyboard.nextLine();
				boolean found = false;
				String title = keyboard.nextLine();
				for (int i = 0; i < itemsInStore.size(); i++ ) {
					if(itemsInStore.get(i).getTitle().equals(title)) {
						itemsInStore.remove(itemsInStore.get(i));
						found = true;
					}
				}
				if(found == true) {
					System.out.println("Removed successfully");
				}
				else {
					System.out.println("The media named " + title +" does not existed in the store.");
				}
				print();
				showMenu();
				break;
			}
			else {
				System.out.println("Invalid input. Please input 0(Add) or 1(Remove)");
			}
		}
	}
	
	public static void addToCart() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the media's title you wanna add to cart: ");
		String title = keyboard.nextLine();
		boolean found = false;
		for (int i = 0; i < itemsInStore.size(); i++ ) {
			if(itemsInStore.get(i).getTitle().equals(title)) {
				found = true;
				anOrder.addMedia(itemsInStore.get(i));
				System.out.println("Successfully Added");
			}
		}
		if (found == false) {
			System.out.println("We don't have media named " + title + " available in our store");
		}
		storeMenu();
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
		while (true) {
			if (choice == 1) {
				print();
				storeMenu();
				break;
			}
			if (choice == 2){
				updateStore();
				break;
			}
			if (choice == 0) {
				System.exit(1);
				break;
			}
			if (choice == 3) {
				anOrder.showCart();
				cartMenu();
				break;
			}
			else {
				System.out.println("Invalid input");
			}
		}
		
	}
	public static void storeMenu() {
		System.out.println("Options: "); 
		System.out.println("---------------------------------"); 
		System.out.println("1. See a Media's details"); 
		System.out.println("2. Add a Media to cart"); 
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
			mediaDetail();
		}
		if (choice == 2) {
			addToCart();
		}
		if (choice == 3) {
			Cart.showCart();
			cartMenu();
		}
	}
	public static void cartMenu() {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Options: "); 
		System.out.println("-----------------------------------"); 
		System.out.println("1. Filter Media in cart"); 
		System.out.println("2. Sort Media in cart"); 
		System.out.println("3. Remove Media from cart"); 
		System.out.println("4. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("-----------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int choice = keyboard.nextInt();
		while (true) {
			if(choice == 2) {
				System.out.println("choose sort method \n1.sort by title\n2.sort by cost\n choose(1 or 2)");
				int chosen = keyboard.nextInt();
				if (chosen == 1) {
					Cart.cartSortByTitle(Cart.itemsOrdered);
					break;
				}
				if (chosen == 2) {
					Cart.cartSortByCost(Cart.itemsOrdered);
					break;
				}
				else {
					System.out.println("choose 1 or 2 only");
				}
				cartMenu();
				break;
			}
			if(choice == 0) {
				showMenu();
				break;
			}
			if(choice == 1) {
				anOrder.cartFilter();
				cartMenu();
				break;
			}
			if(choice == 3) {
				Cart.remove();
				cartMenu();
				break;
			}
			if(choice == 4) {
				if (Cart.itemsOrdered.size() >= 5) {
					System.out.println("the lucky media is:" + anOrder.getALuckyItem().getTitle());
					System.out.println("Total cost:" + (anOrder.totalCost()-anOrder.getALuckyItem().getCost()));
					System.exit(1);
				}
				else {
					System.out.println("Total cost:"+anOrder.totalCost());
					System.exit(1);
				}
				break;
			}
		}	
	}
}


