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
		
		ArrayList<String> ratings = FileIO.readFile("data" + FileIO.fileSeparator + "ratings.csv");
		ArrayList<User> userData = new ArrayList<User>();
		
		int current = 0, next = 0;
		for(int i = 0; i<ratings.size(); i++) {
			next  = translator.parseUser(ratings.get(i), current);
			if(next != -1) {
				User s = new User(next);
				userData.add(s);
			}
			current = next;
		}

		//print out
		for(Movie m : movieData) {
			System.out.println(m);
		}
	}



}