import java.util.ArrayList;

public class Tag {

	//private ArrayList<String> tags;
	//private ArrayList<Integer> timeStamp;
	
	private String tag;
	private int timeStamp, userID, movieID;
	//private int movieID, userID;
	
	public Tag(String tag, int time, int userID, int movieID) {
		this.tag = tag;
		timeStamp = time;
		this.userID = userID;
		this.movieID = movieID;
	}
	
	public String getTag(int index) {
		return tag;
	}
	
	public int getTime(int index) {
		return timeStamp;
	}
	
	public int getMovieID() {
		return movieID;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public String toString() {
		return "user = " + userID + " movie = " + movieID + " tag = " + tag + " timestamp = " + timeStamp;
	}
}
