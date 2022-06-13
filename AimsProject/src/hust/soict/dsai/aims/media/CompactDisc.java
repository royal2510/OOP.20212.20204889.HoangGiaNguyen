package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	
	public CompactDisc(String title, String category, String director, float cost,int length ,String artist, ArrayList<Track> tracks) {
		super(title, category, cost);
		this.id = nbMedia;
		this.director = director;
		this.length = length;
		this.artist = artist;
		this.tracks = tracks;
		nbMedia++;
	}

	public CompactDisc(String title, String category, String director, float cost,int length ,String artist) {
		super(title, category, cost);
		this.id = nbMedia;
		this.director = director;
		this.length = length;
		this.artist = artist;
		nbMedia++;
	}
	
	public CompactDisc(String title) {
		super(title);
		this.id = nbMedia;
		nbMedia++;
	}
	
	public CompactDisc(String title, ArrayList<Track> tracks) {
		super(title);
		this.id = nbMedia;
		this.tracks = tracks;
		nbMedia++;
	}
	
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("The track " + track.getTitle() + " is already existed !");
		}
		else {
			tracks.add(track);
			System.out.println("The track " + track.getTitle() + " is successfully added!");
		}
		/*for(int i = 0; i < tracks.size(); i++) {
			if(tracks.get(i).getTitle().equals(track.getTitle())) {
				System.out.println("The track " + track.getTitle() + " is already existed !");
			}
			else {
				tracks.add(track);
			}
		}*/
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("The track " + track.getTitle() + " is successfully removed !");
		}
		else {
			System.out.println("The track " + track.getTitle() + " is not existed !");
		}
		/*for(int i = 0; i < tracks.size(); i++) {
			if(tracks.get(i).getTitle().equals(track.getTitle())) {
				tracks.remove(track);
				System.out.println("The track " + track.getTitle() + " is successfully removed !");
			}
			else {
				System.out.println("Cannot find the track named " + track.getTitle());
			}
		}*/
	}
	public int getLength() {
		int cdLength = 0;
		for(int i = 0; i < tracks.size(); i++) {
			cdLength += tracks.get(i).getLength();
		}
		return cdLength;
	}
	
	public void play() {
		for(int i = 0; i < tracks.size(); i++) {
			System.out.println("Playing track: " + tracks.get(i).getTitle());
			System.out.println("track length: " + tracks.get(i).getLength());
		}
	}

	public String toString() {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Category: " + this.getCategory());
		System.out.println("Artist: " + this.getArtist());
		System.out.println("Director: " + this.getDirector());
		System.out.println("Length: " + this.getLength());
		System.out.println("Cost: $" + this.getCost());
		StringBuffer trackList = new StringBuffer();
		for(Track track:tracks) {
			trackList.append(track.toString());
		}
		return "CD" + this.title + "\nTracks: " + trackList;
			
		}
	
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}
}