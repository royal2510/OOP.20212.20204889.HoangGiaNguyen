package hust.soict.dsai.aims.store.Store;
import java.util.ArrayList;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;

public class Store {
	static Cart cart = new Cart();
	private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		itemsInStore.add(media);
	}
	
	public void removeMedia(Media media) {
		itemsInStore.remove(media);
	}

	public static ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
	
}
