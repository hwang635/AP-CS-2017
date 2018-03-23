import java.util.ArrayList;

import javax.swing.text.html.HTML.Tag;

public class User {

	private int userID;
	private ArrayList<Integer> watchedMovies;
	private ArrayList<Rating> ratings;
	
	public User(int id) {
		userID = id;
		watchedMovies = new ArrayList<Integer>();
		ratings = new ArrayList<Rating>();
	}

	public int getID() {
		return userID;
	}
	
	public void addMovie(int id) {
		watchedMovies.add(id);
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
}
