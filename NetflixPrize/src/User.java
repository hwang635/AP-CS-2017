import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.html.HTML.Tag;

public class User implements Comparable<User> {

	private int userID;
	private ArrayList<Integer> watchedMovies;
	private ArrayList<Rating> ratings;
	private double sumRating;

	private ArrayList<Genre> genres;
	private boolean genreSorted;

	public User(int id) {
		userID = id;
		watchedMovies = new ArrayList<Integer>();
		ratings = new ArrayList<Rating>();

		sumRating = 0.0;

		genres = new ArrayList<Genre>();
		genreSorted = true;
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
	
	public int getRatingTimestamp(int movieID) {
		for(Rating r: ratings) {
			if(r.getMovieID() == movieID) {
				return r.getTime();
			}
		}
		
		return -1;
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

	public boolean hasWatched(int m) {
		for(Integer id : watchedMovies) {
			if(id == m) {
				return true;
			}
		}

		return false;
	}

	public ArrayList<Integer> getWatchedMovies() {
		return watchedMovies;
	}

	public double getGenreEffect(ArrayList<String> genre, double baseline) {
		double genreAvg = 0;
		for(Genre g : genres) {
			double a = g.getGERating();
			if(a == -1) 
				return 0;
			else {
				genreAvg += a-baseline;
			}
		}

		return genreAvg/genres.size();
	}

	public void addGenre(String str, int movieID) {
		Genre g = new Genre(str, movieID);
		double newR = 0;

		for(Rating r: ratings) {
			if(r.getMovieID() == movieID) {
				newR = r.getRating();
				break;
			}
		} //find rating for this movie

		if(genres.size() == 0 ) {
			genres.add(g);
			g.addRating(newR);
		}
		else {
			int index = findGenre(g.getGenre());

			if(index == -1) {
				genres.add(g);
				g.addRating(newR);
			}
			else { //already watched this rating
				genres.get(index).addRating(newR);
				genres.get(index).incrementCountGE();
			}
		}

		genreSorted = false;
	}

	//should be sorted in order of favourite-ness
	public Genre getGenre(int index) {
		if(genreSorted == false) {
			System.out.println("user = " + userID);
			System.out.println("genre size = " + genres.size());
			Collections.sort(genres);
			genreSorted = true;
		}

		if(!genres.isEmpty())
			return genres.get(0);
		else
			return new Genre("no info");
	}
	
	private int findGenre(String g) {
		for(int i = 0; i<genres.size(); i++) {
			Genre gn = genres.get(i);
			if(gn.getGenre().equals(g))
				return i;
		}
		return -1;
	}
	
	public int getNumGenre() {
		return genres.size();
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return userID - o.getID();
	}

}