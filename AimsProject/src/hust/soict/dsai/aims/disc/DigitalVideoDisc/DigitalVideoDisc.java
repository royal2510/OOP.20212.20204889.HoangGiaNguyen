<<<<<<< HEAD
package hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;    

public class DigitalVideoDisc {
	private LocalDate dateAdded;
	private int id;
	private static int nbDigitalVideoDiscs = 0;

	public String toString(){
		return this.title;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
	}
	
	boolean isMatch(String title, String[] words) {
		List<String> titleToken = Arrays.asList(title.split(" "));
	    List<String> wordsList = Arrays.asList(words);
	    return wordsList.stream().allMatch(titleToken::contains);
	}
	
	private String title; 
	private String category; 
	private String director; 
	private int length; 
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
}

=======
package hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;    

public class DigitalVideoDisc {
	private LocalDate dateAdded;
	private int id;
	private static int nbDigitalVideoDiscs = 0;

	public String toString(){
		return this.title;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.dateAdded=LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		this.title = title;
	}
	
	boolean isMatch(String title, String[] words) {
		List<String> titleToken = Arrays.asList(title.split(" "));
	    List<String> wordsList = Arrays.asList(words);
	    return wordsList.stream().allMatch(titleToken::contains);
	}
	
	private String title; 
	private String category; 
	private String director; 
	private int length; 
	private float cost;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}
}

>>>>>>> 72acdd27e81236a6775ba922af00d451ad39b784
