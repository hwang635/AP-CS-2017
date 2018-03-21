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
		
		ArrayList<String> movieRatings = FileIO.readFile("data" + FileIO.fileSeparator + "ratings.csv");
		ArrayList<User> userData = new ArrayList<User>();
		int current = 0, next = 0;
		for(int i = 1; i<movieRatings.size(); i++) { //skip label line
			next  = translator.parseUser(movieRatings.get(i), current); //new userid or -1 if same user
			Rating r = translator.parseRating(movieRatings.get(i));
			if(next != -1) {
				User s = new User(next);
				userData.add(s);
				s.addRating(r);
			}
			else {
				userData.get(i-1).addRating(r);
			}
			
			current = next;
		}

		//print out
		for(Movie m : movieData) {
			System.out.println(m);
		}
	}



}