import java.util.ArrayList;

public class Movie {
	
	public int movieID;
	private String title;
	private int year;
	private String[] genre;
	private ArrayList<Tag> tags;
	private ArrayList<Rating> ratings;
	private double avgRating;
	
	private String imdbID,tmdbID; //Strings to keep leading zeroes
	
	public Movie(int movieID, String title, int year, String[] genre) {
		this.movieID = movieID;
		this.title = title;
		this.year = year;
		this.genre = genre;
		tags = new ArrayList<Tag>();
		ratings = new ArrayList<Rating>();
		
		avgRating = calcAvgRating();
	}
	
	public void addLinks(String[] ids) {
		imdbID = ids[0];
		tmdbID = ids[1];
		
		if(tmdbID.length() == 0)
			tmdbID = "no info";
		if(imdbID.length() == 0)
			imdbID = "no info";
	}
	
	//to String method
	public String toString() {
		String output = movieID + ", " + title + " (" + year + "), ";
		
		for(int i = 0; i<genre.length-1; i++) {
			output += (genre [i] + "|");
		}
		output += genre[genre.length-1];
		
		//output += (" imdbID = " + imdbID + " tmdbID = " + tmdbID);
		
		return output;
	}
		
	public int getID() {
		return movieID;
	}
	
	public void addTag(Tag t) {
		tags.add(t);
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
	private double calcAvgRating() {
		double average = 0;
		for(Rating r : ratings) {
			average += r.getRating();
		}
				
		if(ratings.size() > 0)
			return average/ratings.size();
		
		return -1;
	}
	
	public double getAvgRating() {
		return avgRating;
	}
	
	
}
