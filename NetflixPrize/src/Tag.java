import java.util.ArrayList;

public class Tag {

	//private ArrayList<String> tags;
	//private ArrayList<Integer> timeStamp;
	
	private String tag;
	private int timeStamp;
	//private int movieID, userID;
	
	public Tag(String tag, int time) {
		this.tag = tag;
		timeStamp = time;
	}
	
	public String getTag(int index) {
		return tag;
	}
	
	public int getTime(int index) {
		return timeStamp;
	}
	
	/*public int getMovieID() {
		return movieID;
	}
	
	public int getUserID() {
		return userID;
	} */
}
