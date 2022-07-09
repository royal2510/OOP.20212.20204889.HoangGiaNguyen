package hust.soict.dsai.aims.media;
public class Disc extends Media {
	
	protected int length;
	protected String director; 
	
	public Disc(String title, String category, float cost, int length, String director){
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	public Disc(String title, String category, float cost){
		super(title, category, cost);
	}
	
	public Disc(String title) {
		super(title);
	}
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	} 
}
