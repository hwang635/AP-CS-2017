
public class MovieLensCSVTranslator {

	public Movie parseMovie(String line) {
		//extract pieces of data from the line (by looking for commas)
		int comma = line.indexOf(",");
		String id = line.substring(0, comma);
		line = line.substring(comma+1);
		
		comma = line.indexOf(",");
		String title = "";
		int year = 0;
		if(line.charAt(1) == 34) {//34 = double quotes, ascii
			int endQuote = line.indexOf(34, 2);
			title = line.substring(0, endQuote);
			
			int p2 = line.lastIndexOf(")", endQuote);
			int p1 = line.lastIndexOf("(", endQuote);
			year = Integer.parseInt(line.substring(p1 + 1, p2));
		}
		else {
			title = line.substring(0, comma);
		
			int p2 = line.lastIndexOf(")", comma);
			int p1 = line.lastIndexOf("(", comma);
			
			year = Integer.parseInt(line.substring(p1 + 1, p2));
		}
		
		line.substring(comma+1);
		
		
		//construct movie obj
		
		//return obj
		return null;
	}
}
