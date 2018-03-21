import java.util.ArrayList;

public class Tag {

	//private ArrayList<String> tags;
	//private ArrayList<Integer> timeStamp;
	
	private String tag;
	private int timeStamp;
	
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
}
