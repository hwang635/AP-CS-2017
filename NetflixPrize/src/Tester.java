import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		ArrayList<String> movieStrings =  FileIO.readFile("data" + FileIO.fileSeparator + "movies.csv");
		for(String s : movieStrings) {
			System.out.println(s);
		}
	}
}
