import java.util.ArrayList;


public class NetFlixPredictor {


	// Add fields to represent your database.
	private ArrayList<Movie> movieData;
	private ArrayList<User> userData;
	private ArrayList<Rating> ratingData;
	private ArrayList<Tag> tagData;
	
	private double averageRating;

	/**
	 * 
	 * Use the file names to read all data into some local structures. 
	 * 
	 * @param movieFilePath The full path to the movies database.
	 * @param ratingFilePath The full path to the ratings database.
	 * @param tagFilePath The full path to the tags database.
	 * @param linkFilePath The full path to the links database.
	 */
	public NetFlixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {
		//copy paste code from tester
		//change arraylists to fields so can access
		//fill fields w/ info using translator
		
		//parse initial movie obj, movies.csv
		ArrayList<String> movieStrings =  FileIO.readFile(movieFilePath);
		movieData = new ArrayList<Movie>();
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		for(int i = 1; i<movieStrings.size(); i++) {
			Movie m = translator.parseMovie(movieStrings.get(i));
			movieData.add(m);
		} //parse movie obj

		//add links to movie
		ArrayList<String> movieLinks =  FileIO.readFile(linkFilePath);
		for(int i = 0; i<movieData.size(); i++) {
			Movie m = movieData.get(i);
			String[] links = translator.parseLinks(movieLinks.get(i+1));
			m.addLinks(links);

		}

		//create user + rating from ratings.csv
		ArrayList<String> movieRatings = FileIO.readFile(ratingFilePath);
		userData = new ArrayList<User>();
		ratingData = new ArrayList<Rating>();
		for(int i = 1; i<movieRatings.size(); i++) { //skip label line
			Rating r = translator.parseRating(movieRatings.get(i));
			ratingData.add(r);

			int movieIndex = findMovie(r.getMovieID());
			movieData.get(movieIndex).addRating(r);
		}

		//for r in rating data, if rating w/ 

		for(Rating r: ratingData) {
			int userID = r.getUserID();
			int index = findUser(userID);
			User s;
			if(index == -1) {
				s = new User(userID);
				userData.add(s);
			}
			else {
				s = userData.get(index);
			}
			s.addMovie(r.getMovieID());
			s.addRating(r);
		}

		//put in all the tags
		ArrayList<String> movieTags = FileIO.readFile(tagFilePath);
		tagData = new ArrayList<Tag>();
		for(int i = 1; i<movieTags.size(); i++) {
			Tag t = translator.parseTag(movieTags.get(i));
			tagData.add(t);
		}

		//assign tags to movies by matching movieID
		for(Movie m : movieData) {
			for(Tag t : tagData) {
				if(m.getID() == t.getMovieID())
					m.addTag(t);
			}
		}
		
		averageRating = calcAvgRating();
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {
		int user = findUser(userID);
		if(user != -1) {
			if(userData.get(user).watched(movieID))
				return userData.get(user).getRating(movieID);
		}

		return -1;
	}

	//returns index of user w/ userID in userData, if not found -1
	private int findUser(int userID) {
		int index = -1;
		for(User s : userData) {
			index++;
			if(s.getID() == userID) {
				return index;
			}
		}
		return -1; 
	}

	//returns index of movie w/ movieID in movieData, if not found = -1
	private int findMovie(int movieID) {
		int index = -1;
		for(Movie m : movieData) {
			index++;
			if(m.getID() == movieID) {
				return index;
			}
		}
		return index; 
	}
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {
		int user = findUser(userID);

		if(userData.get(user).watched(movieID))
			return userData.get(user).getRating(movieID);
		else {
			return averageRating;
		}
	}

	/**
	 * Recommend a movie that you think this user would enjoy (but they have not currently rated it). 
	 * 
	 * @param userNumber The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {

		return 0;
	}

	public double calcAvgRating() {
		double r = 0;
		int count = 0;

		for(Movie m: movieData) {
			if(m.getAvgRating() != -1) {
				r += m.getAvgRating();
				count++;
			}

		}
		return r/count;
	}

}
