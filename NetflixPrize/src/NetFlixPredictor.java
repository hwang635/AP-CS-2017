import java.util.ArrayList;
import java.util.Collections;


public class NetFlixPredictor {


	// Add fields to represent your database.
	private ArrayList<Movie> movieData;
	private ArrayList<User> userData;
	private ArrayList<Rating> ratingData;
	private ArrayList<Tag> tagData;

	private double baselineRating;

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
		
		Collections.sort(movieData);

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
			if(index <0) {
				s = new User(userID);
				userData.add(s);
			}
			else {
				s = userData.get(index);
			}
			s.addMovie(r.getMovieID());
			s.addRating(r);
		}
		
		Collections.sort(userData);

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
		
		for(User s: userData) {
			ArrayList<Integer> watchedMovies = s.getWatchedMovies();
			for(int id : watchedMovies) {
				int index = findMovie(id);
				Movie m = movieData.get(index);
				setUserGenres(s, m);
			}
		} //sets genres for user

		baselineRating = calcBaselineRating();
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
		if(user >= 0) {
			User s = userData.get(user);
			if(s.watched(movieID))
				return s.getRating(movieID);
		}

		return -1;
	}

	//returns index of user w/ userID in userData, if not found -1
	private int findUser(int userID) {
		/*for(User s : userData) {
			index++;
			if(s.getID() == userID) {
				return index;
			}
		} */
		
		int index = Collections.binarySearch(userData, new User(userID));
		return index; 
	}

	//returns index of movie w/ movieID in movieData, if not found returns -number
	private int findMovie(int movieID) {
		/*for(Movie m : movieData) {
			index++;
			if(m.getID() == movieID) {
				return index;
			}
		} */
		
		int index = Collections.binarySearch(movieData, new Movie(movieID));
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
		User s = userData.get(findUser(userID));

		if(s.watched(movieID))
			return s.getRating(movieID);
		else if(s.getAvgRating() != -1) { //user avg more accurate than movie avg
			Movie m = movieData.get(findMovie(movieID));
			if(m.getAvgRating() != -1) { //user and movie have been rated
				//double rating = baselineRating + s.getAliceEffect(baselineRating) + m.getInceptionEffect(baselineRating);
				ArrayList<String> genre = new ArrayList<String>();
				m.setGenre(genre);
				
				double rating = baselineRating + 0.45*s.getAliceEffect(baselineRating) + 
						0.634*m.getInceptionEffect(baselineRating) + 0.419*s.getGenreEffect(genre, baselineRating);

				//9093570891881914, 0.45, 9,634, 9,419
				if(rating > 5)
					return 5.0;
				else if(rating < 0)
					return 0;
				else 
					return rating;
				//add effect by genre?
			}
			else //only user has ratings
				return s.getAvgRating();
		}
		else
			return baselineRating;
	}
	
	private void setUserGenres(User s, Movie m) {
		ArrayList<String> genre = new ArrayList<String>();
		m.setGenre(genre);
		for(String g : genre) {
			s.addGenre(g, m.getID());
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

	public double calcBaselineRating() {
		double r = 0;
		int count = 0;

		for(Movie m : movieData) {
			r += m.getRatingSum();
			count += m.getNumRatings();
		}

		return r/count;
	}

}
