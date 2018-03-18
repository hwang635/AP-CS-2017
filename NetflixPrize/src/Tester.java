import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		ArrayList<String> movieStrings =  FileIO.readFile("data" + FileIO.fileSeparator + "movies.csv");
		for(String s : movieStrings) {
			//System.out.println(s);
		}		

		ArrayList<Movie> movieData = new ArrayList<Movie>();
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		//Movie m = translator.parseMovie(movieStrings.get(1));

		for(int i = 1; i<movieStrings.size(); i++) {
			Movie m = translator.parseMovie(movieStrings.get(i));
			movieData.add(m);
		}
		//System.out.println(m);

		for(Movie m : movieData) {
			System.out.println(m);
		}
	}

	
	
}
