import java.util.ArrayList;

import javax.swing.text.html.HTML.Tag;

public class User {

	private int userID;
	private ArrayList<Movie> watchedMovies;
	private ArrayList<Rating> ratings;
	//private ArrayList<Tag> tags;
	
	public User(int id) {
		userID = id;
	}

	public int getID() {
		return userID;
	}
	
	public void addMovie(Movie m) {
		watchedMovies.add(m);
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
	}
	
}
