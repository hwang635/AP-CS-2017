import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {

		//parse initial movie obj, movies.csv
		ArrayList<String> movieStrings =  FileIO.readFile("data" + FileIO.fileSeparator + "movies.csv");
		ArrayList<Movie> movieData = new ArrayList<Movie>();
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		for(int i = 1; i<movieStrings.size(); i++) {
			Movie m = translator.parseMovie(movieStrings.get(i));
			movieData.add(m);
		} //parse movie obh

		//add links to movie
		ArrayList<String> movieLinks =  FileIO.readFile("data" + FileIO.fileSeparator + "links.csv");
		for(int i = 0; i<movieData.size(); i++) {
			Movie m = movieData.get(i);
			String[] links = translator.parseLinks(movieLinks.get(i+1));
			m.addLinks(links);

		}
		
		/*
		for(int i = 1; i<movieRatings.size(); i++) {
			Rating r = translator.parseRating(movieRatings.get(i));
			User s = translator.parseUser(movieRatings.get(i));
			ratingData.add(r);
			userData.add(s);
		}
		
		for(User s : userData) {
			for(Rating r : ratingData) {
				if(s.getID() == r.getUserID())
					s.addRating(r);
					s.addMovie(r.getMovieID());
			}
		} */
		
		ArrayList<String> movieRatings = FileIO.readFile("data" + FileIO.fileSeparator + "ratings.csv");
		ArrayList<User> userData = new ArrayList<User>();
		ArrayList<Rating> ratingData = new ArrayList<Rating>();
		int current = 0, next = -10;
		int userCount = 0;
		for(int i = 1; i<movieRatings.size(); i++) { //skip label line
			next  = translator.parseUser(movieRatings.get(i), current); //new userid or -1 if same user
			Rating r = translator.parseRating(movieRatings.get(i));
			ratingData.add(r);
			if(next != -1) {
				User s = new User(next);
				userData.add(s);
				s.addRating(r);
				s.addMovie(r.getMovieID());
				userCount++;
			}
			else {
				userData.get(userCount-1).addRating(r);
				userData.get(userCount-1).addMovie(r.getMovieID());
			}
			
			current = next;
		}
		
		ArrayList<String> movieTags = FileIO.readFile("data" + FileIO.fileSeparator + "tags.csv");
		ArrayList<Tag> tagData = new ArrayList<Tag>();
		for(int i = 1; i<movieTags.size(); i++) {
			Tag t = translator.parseTag(movieTags.get(i));
			tagData.add(t);
		} //put in all the tags
		
		/*for(Movie m : movieData) {
			for(Tag t : tagData) {
				if(m.getID() == t.getMovieID())
					m.addTag(t);
			}
		}
		
		for (Tag t : tagData) {
			System.out.println(t);
		} */
		//System.out.println(tagData.size());
		for (Rating r : ratingData) {
			System.out.println(r);
		}
		System.out.println(ratingData.size());
		
		//print out
		/*for(Movie m : movieData) {
			System.out.println(m);
		} */
	}



}