import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {
		
		ArrayList<String> fileData = FileIO.readFile("src" + FileIO.fileSeparator + "FileIO.java");
			
		System.out.println(fileData);
	}
	
	
	

}
