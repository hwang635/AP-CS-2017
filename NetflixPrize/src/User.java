import java.util.ArrayList;

import javax.swing.text.html.HTML.Tag;

public class User {

	private int userID;
	private ArrayList<Integer> watchedMovies;
	private ArrayList<Rating> ratings;
	private double sumRating;
	
	public User(int id) {
		userID = id;
		watchedMovies = new ArrayList<Integer>();
		ratings = new ArrayList<Rating>();
		
		sumRating = 0;
	}

	public int getID() {
		return userID;
	}
	
	public void addMovie(int id) {
		watchedMovies.add(id);
	}
	
	public void addRating(Rating r) {
		ratings.add(r);
		sumRating += r.getRating();
	}
	
	public double getRating(int movieID) {
		for(Rating r: ratings) {
			if(r.getMovieID() == movieID) {
				return r.getRating();
			}
		}
		
		return -1.0;
	}
	
	public double getAvgRating() {
		int size = ratings.size();
		
		if(size>0)
			return sumRating/size;
		else
			return -1.0;
	}
	
	public int getNumRating() {
		return ratings.size();
	}

	public boolean watched(int m) {
		for(Integer id : watchedMovies) {
			if(id == m) {
				return true;
			}
		}
		
		return false;
	}
	
		
}
