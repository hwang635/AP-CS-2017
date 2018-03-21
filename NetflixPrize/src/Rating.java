
public class Rating {
	
	private double rating;
	private int timeStamp;
	private int movieID;
	
	public Rating(int movieID, double r, int t) {
		this.movieID = movieID;
		rating = r;
		timeStamp = t;
	}

	public double getRating() {
		return rating;
	}
	
	public int getTime() {
		return timeStamp;
	}
	
	public int getMovieID() {
		return movieID;
	}
}
