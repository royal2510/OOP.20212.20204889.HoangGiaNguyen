package hust.soict.dsai.aims.media;
import java.time.LocalDate;
import java.util.List;
public class Media {
		private LocalDate dateAdded;
		protected int id;
		protected String title; 
		protected String category;  
		protected float cost;
		private String director;
		private int length;
		private List<String> authors;
		protected static int nbMedia = 0;

		public Media(String title, String category, float cost) {
			this.id = nbMedia;
			this.title = title;
			this.category = category;
			this.cost = cost;
			nbMedia ++;
		}
		
		public Media(String title) {
			this.id = nbMedia;
			this.title = title;
			nbMedia ++;
		}

		public Media(String title, String category,String director, int length, float cost) {
			this.id = nbMedia;
			this.title = title;
			this.category = category;
			this.director = director;
			this.length = length;
			this.cost = cost;
			nbMedia++;
		}
		
		public Media(String title, String category, float cost, List<String> authors) {
			this.id = nbMedia;
			this.title = title;
			this.category = category;
			this.cost = cost;
			this.authors = authors;
			nbMedia++;
		}
		
		
		public LocalDate getDateAdded() {
			return dateAdded;
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

		public String getDirector() {
			return director;
		}

		public int getLength() {
			return length;
		}

		public List<String> getAuthors() {
			return authors;
		}
	}


