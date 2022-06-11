package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
		this.id = nbMedia;
		nbMedia ++;
	}
	
	public void addAuthor(String authorname) {
		int length = authors.size();
		for(int i = 0; i < length; i++) {
			if(authors.get(i).equals(authorname)) {;
				System.out.println("The author name is already existed");
			}
			else {
				authors.add(authorname);
				System.out.print("Author " + authorname + " is successfully added to author list");
			}
		}
	}
	
	public void removeAuthor(String authorname) {
		int length = authors.size();
		for(int i = 0; i < length; i++) {
			if(authors.get(i).equals(authorname)) {
				authors.remove(authorname);
				System.out.print("Author " + authorname + " is successfully removed from the author list");	
			}
			else {
				System.out.println("The author name is not in the list !");;
			}
		}
		
	}
	

	public List<String> getAuthors() {
		return authors;
	}
	
}
