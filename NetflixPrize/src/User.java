import java.util.ArrayList;

import javax.swing.text.html.HTML.Tag;

public class User implements Comparable<User> {

	private int userID;
	private ArrayList<Integer> watchedID;
	private ArrayList<Movie> watchedMovies;
	private ArrayList<Rating> ratings;
	private double sumRating;

	//private ArrayList<String> genres;

	public User(int id) {
		userID = id;
		watchedID = new ArrayList<Integer>();
		ratings = new ArrayList<Rating>();

		sumRating = 0.0;

		//genres = new ArrayList<String>();
	}

	public int getID() {
		return userID;
	}

	public void addMovie(int id) {
		watchedID.add(id);
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

	public double getAliceEffect(double baseline) {
		double alice = this.getAvgRating();
		alice = alice-baseline;

		return alice;
	}

	public boolean watched(int m) {
		for(Integer id : watchedID) {
			if(id == m) {
				return true;
			}
		}

		return false;
	}

	public double getSpecialityEffect() {
		return 0;
	}

//	public void addGenre(String str) {
//		if(genres.indexOf(str) == -1) {
//			genres.add(str);
//		}
//	}

	public ArrayList<Integer> getWatchedMovies() {
		return watchedID;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return userID - o.getID();
	}

}