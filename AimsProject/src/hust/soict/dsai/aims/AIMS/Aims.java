package hust.soict.dsai.aims.Aims;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

public class Aims {
	static ArrayList<Media> itemsInStore = new ArrayList<Media>();
	static Cart anOrder = new Cart();
	static Store store = new Store();
	
	public static void main(String[] args) {
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		itemsInStore.add(dvd1);
		Book b1 = new Book("The Liar", "Comic", 10, Arrays.asList("John", "Max", "Vu")) ; 
		itemsInStore.add(b1);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f); 
		itemsInStore.add(dvd3);
		
		Track track1 = new Track("One", 10);
		Track track2 = new Track("Two", 20);
		
		CompactDisc cd1 = new CompactDisc("Rise Sun");
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		System.out.println(cd1);
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
				while(true) {
					System.out.println("What type of media you want to add?\n1. DVD\n2. CD\n3. Book\nPlease choose (1-3)!");
					int choice = keyboard.nextInt();
					if(choice == 1) {
						System.out.println("Input the dvd's title: ");
						keyboard.nextLine();
						String title = keyboard.nextLine();
						System.out.println("Input the dvd's category: ");
						String category = keyboard.nextLine(); 
						System.out.println("Input the dvd's director: ");
						String director = keyboard.nextLine(); 
						System.out.println("Input the dvd's length: ");
						int length = keyboard.nextInt();
						System.out.println("Input the dvd's cost: ");
						float cost = keyboard.nextFloat();
						itemsInStore.add(new DigitalVideoDisc(title, category, director,length, cost));
						System.out.println("The dvd named " + title +" is successfully added to the store");
						break;
					}
					if(choice == 2) {
						System.out.println("Input the cd's title: ");
						keyboard.nextLine();
						String title = keyboard.nextLine();
						System.out.println("Input the cd's category: ");
						String category = keyboard.nextLine(); 
						System.out.println("Input the cd's director: ");
						String director = keyboard.nextLine(); 
						System.out.println("Input the cd's length: ");
						int length = keyboard.nextInt();
						System.out.println("Input the cd's cost: ");
						float cost = keyboard.nextFloat();
						System.out.println("Input the cd's artist: ");
						String artist = keyboard.nextLine(); 
						itemsInStore.add(new CompactDisc(title, category, director,cost, length, artist));
						System.out.println("The cd named " + title +" is successfully added to the store");
						break;
					}
					if(choice == 3) {
						
						System.out.println("Input the book's title: ");
						keyboard.nextLine();
						String title = keyboard.nextLine();
						System.out.println("Input the book's category: ");
						String category = keyboard.nextLine(); 
						System.out.println("Input the book's cost: ");
						float cost = keyboard.nextFloat();
						List<String> authors = new ArrayList<String>();
						System.out.println("The number of authors: ");
						int nbAuthors = keyboard.nextInt();
						String next = keyboard.nextLine();
						for(int i = 0; i < nbAuthors; i++) {
							System.out.println("Author " + (i+1) + " name is: ");
							String author =keyboard.nextLine();
							authors.add(author);
						}
						
						itemsInStore.add(new Book(title, category,cost, authors));
						System.out.println("The cd named " + title +" is successfully added to the store");
						break;
					}
					else {
						System.out.print("Invalid input. Please try again !");
					}
				}
				print();
				showMenu();
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
	
	public static void playMedia() {
		System.out.println("Playable items: ");
		for(int i = 0; i < anOrder.itemsOrdered.size(); i++) {
			if(!anOrder.itemsOrdered.get(i).getClass().getSimpleName().equals("Book")) {				
				System.out.println((i+1) + " - (" + anOrder.itemsOrdered.get(i).getClass().getSimpleName() + ") - " + anOrder.itemsOrdered.get(i).getTitle());
			}
		}
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the media's title you wanna play: ");
		String title = keyboard.nextLine();
		boolean found = false;
		for(int j = 0; j < anOrder.itemsOrdered.size(); j++) {
			if(title.equals(anOrder.itemsOrdered.get(j).getTitle()) && !anOrder.itemsOrdered.get(j).getClass().getSimpleName().equals("Book") ) {
				anOrder.itemsOrdered.get(j).play();
				found = true;
			}
		}
		if(found == false){
				System.out.println("No media found !");
		}
		cartMenu();
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
		System.out.println("3. Play Media"); 
		System.out.println("4. Remove Media from cart"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("-----------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int choice = keyboard.nextInt();
		while (true) {
			
			if(choice == 0) {
				showMenu();
				break;
			}
			if(choice == 1) {
				anOrder.cartFilter();
				cartMenu();
				break;
			}
			if(choice == 2) {
				while(true) {
					System.out.println("Choose sort method:\n1.By title\n2.By cost\nChoose (1-2)");
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
						System.out.println("Please choose 1 or 2 only");
					}
				}
				cartMenu();
			}
			
			if(choice == 3) {
				playMedia();
				break;
			}
			
			if(choice == 4) {
				Cart.remove();
				cartMenu();
				break;
			}
			if(choice == 5) {
				if(Cart.itemsOrdered.size() > 4) {
					System.out.println("Your lucky media is: " + anOrder.getALuckyItem().getTitle());
					System.out.print("Total cost: $" + (anOrder.totalCost() - anOrder.getALuckyItem().getCost()));
					System.exit(1);
				}
				else {
					System.out.print("Total cost: $" + anOrder.totalCost());
					System.out.println("\nIf you buy " + (5-Cart.itemsOrdered.size()) + " more media, you will get a lucky box.\nDo you want to continue shopping ?\nPress 0 to continue shopping\nPress 1 to exit");
					int choice1 = keyboard.nextInt();
					if(choice1 == 0) {
						storeMenu();
					}
					if (choice == 1) {
						System.exit(1);	
				}	
				break;
				}
			}	
		}
	}
}

