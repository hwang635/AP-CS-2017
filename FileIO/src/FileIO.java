import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	public static final String fileSeparator = System.getProperty("file.separator");
	
	public static ArrayList<String> readFile(String filename) {

		try {
			ArrayList<String> output = new ArrayList<String>();
			FileReader reader = new FileReader(filename);
			Scanner scan = new Scanner(reader);

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				output.add(line);
			}
			
			scan.close();
			
			return output;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	

	
}