import java.util.ArrayList;

public class User {

	private int userID;
	private ArrayList<Movie> watchedMovies;
	
	public User(int id, ArrayList<Movie> movies) {
		userID = id;
		watchedMovies = movies;
	}

}
