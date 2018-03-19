import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {

		ArrayList<String> movieStrings =  FileIO.readFile("data" + FileIO.fileSeparator + "movies.csv");
		ArrayList<Movie> movieData = new ArrayList<Movie>();
		MovieLensCSVTranslator translator = new MovieLensCSVTranslator();
		for(int i = 1; i<movieStrings.size(); i++) {
			Movie m = translator.parseMovie(movieStrings.get(i));
			movieData.add(m);
		} //parse movie obh

		ArrayList<String> movieLinks =  FileIO.readFile("data" + FileIO.fileSeparator + "links.csv");

		/*Movie m = movieData.get(i);
		String[] links = translator.parseLinks(movieLinks.get(i+1));
		m.addLinks(links);
		System.out.println(m); */

		for(int i = 0; i<movieData.size(); i++) {
			Movie m = movieData.get(i);
			String[] links = translator.parseLinks(movieLinks.get(i+1));
			m.addLinks(links);

		} //add links

		for(Movie m : movieData) {
			System.out.println(m);
		}
	}



}