
public class Rating {
	
	private double rating;
	private int timeStamp;
	private int movieID, userID;
	
	public Rating(double r, int t, int userID, int movieID) {
		rating = r;
		timeStamp = t;
		this.userID = userID;
		this.movieID = movieID;
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
	
	public int getUserID() {
		return userID;
	}
	
	public String toString() {
		return "userID = " + userID + "movieID = " + movieID + " rating = " + rating + "timestamp = " + timeStamp;
	}
}
