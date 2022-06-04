package hust.soict.dsai.aims.media;
import java.util.ArrayList;
public class books {
	private int id;
	private String title;
	private String category;
	private float cost;
	private ArrayList<String> authors = new ArrayList<String>();
	

	public books(int id,String title,String category,float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
}


