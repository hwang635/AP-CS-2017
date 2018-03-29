
public class Genre {
	
	private String genre;
	private double rating;
	private int movieID;
	private int count;
	
	public Genre(String g, int movieID) {
		genre = g;
		this.movieID = movieID;
		rating = 0;
		count = 1;
	}
	
	public void addRating(double r) {
		rating += r;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void incrementCount() {
		count++;
	}

	public int getCount() {
		return count;
	}
	
	public double getAvgRating() {
		if(count != 0) {
			return rating/count;
		}
		else
			return -1.0;
		
	}
}
