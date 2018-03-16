
public class Movie {
	
	public int movieID;
	private String title;
	private int year;
	private String[] genre;
	
	public Movie(int movieID, String title, int year, String[] genre) {
		this.movieID = movieID;
		this.title = title;
		this.year = year;
		this.genre = genre;
	}
	
	//to String method
	public String toString() {
		String output = movieID + ", " + title + "(" + year + "), ";
		
		for(int i = 0; i<genre.length-1; i++) {
			output += (genre [i] + "|");
		}
		output += genre[genre.length-1];
		
		return output;
	}
	
}
