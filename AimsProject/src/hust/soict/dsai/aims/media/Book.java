package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Book extends Media {
	
	private String content;
	private List<String> authors = new ArrayList<String>();
	private List<String> contentTokens = new ArrayList<String>();
	Map<String,Integer> wordFrequency = new TreeMap<>();
	
	public void processContent() {
        this.contentTokens = Arrays.asList(this.content.split("([.,!?:;'\"-]|\\s)+"));
        Integer ONE = new Integer(1);
        for (int i = 0, n = this.contentTokens.size(); i < n; i++) {
            String key = this.contentTokens.get(i).toLowerCase();
            Integer frequency = this.wordFrequency.get(key);
            if (frequency == null) {
                frequency = ONE;
            } else {
                int value = frequency.intValue();
                frequency = new Integer(value + 1);
            }
            this.wordFrequency.put(key, frequency);
        }
	}

	public Book(String title, String category, float cost, List<String> authors, String content){
		super(title, category, cost);
		this.authors = authors;
		this.id = nbMedia;
		this.content = content;
		nbMedia ++;
	}
	
	public Book(String title, String category, float cost, String content){
		super(title, category, cost);
		this.id = nbMedia;
		this.content = content;
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
				System.out.println("The author name is not in the list !");
			}
		}	
	}

	public void toString(Book book) {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Category: " + this.getCategory());
		System.out.println("Authors: " + this.getAuthors());
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getContent() {
		return content;
	}

	public List<String> getContentTokens() {
		return contentTokens;
	}

	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}
	
}
