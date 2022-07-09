package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;    

public class DigitalVideoDisc extends Disc implements Playable {
	private LocalDate dateAdded;
	private static int nbMedia = 0;

	public String toString(){
		return this.title;
	}
	
	public DigitalVideoDisc(String title, String category,String director, int length, float cost) {
		super(title, category, cost);
		this.id = nbMedia;
		this.director = director;
		this.length = length;
		this.dateAdded=LocalDate.now();
		nbMedia++;
	}
	public DigitalVideoDisc(String title, String category, float cost, String director) {
		super(title, category, cost);
		this.dateAdded=LocalDate.now();
		this.id = nbMedia;
		this.director = director;
		nbMedia++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.dateAdded=LocalDate.now();
		this.id = nbMedia;
		nbMedia++;
	}
	public DigitalVideoDisc(String title) {
		super(title);
		this.dateAdded=LocalDate.now();
		this.id = nbMedia;
		this.title = title;
		nbMedia++;
	}
	
	boolean isMatch(String title, String[] words) {
		List<String> titleToken = Arrays.asList(title.split(" "));
	    List<String> wordsList = Arrays.asList(words);
	    return wordsList.stream().allMatch(titleToken::contains);
	}
	
	public void toString(DigitalVideoDisc dvd) {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Category: " + this.getCategory());
		System.out.println("Director: " + this.getDirector());
		System.out.println("Length: " + this.getLength());
		System.out.println("Cost: $" + this.getCost());
	}
	
	private String director; 
	private int length; 
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public static int getnbMedia() {
		return nbMedia;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
