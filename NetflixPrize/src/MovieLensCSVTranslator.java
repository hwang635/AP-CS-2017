
public class MovieLensCSVTranslator {

	public Movie parseMovie(String line) {
		//extract pieces of data from the line (by looking for commas)
		int comma = line.indexOf(",");
		System.out.println(line);

		int id = Integer.parseInt(line.substring(0, comma));
		System.out.println(id);

		line = line.substring(comma+1);
		System.out.println(line);

		comma = line.indexOf(",");
		String title = "";
		int year = 0;
		if(line.charAt(1) == 34) {//34 = double quotes, ascii
			int endQuote = line.indexOf(34, 2);

			int p2 = line.lastIndexOf(")", endQuote);
			int p1 = line.lastIndexOf("(", endQuote);
			
			title = line.substring(0, p1-1);
			System.out.println(title);
			
			year = Integer.parseInt(line.substring(p1 + 1, p2));
			System.out.println(year);
		} 
		else { 
			title = line.substring(0, comma);
			System.out.println(title);

			int p2 = line.lastIndexOf(")", comma);
			int p1 = line.lastIndexOf("(", comma);

			year = Integer.parseInt(line.substring(p1 + 1, p2));
			System.out.println(year);
		}

		line.substring(comma+1);
		String[] genres = numGenres(line);

		//construct movie obj
		Movie m = new Movie(id, title, year, genres);
		System.out.print(m);

		return m;
	}

	private String[] numGenres(String line) {
		int i = line.indexOf("|");
		int count = 1;
		while(i != -1) {
			i = line.indexOf("|", i);
			count++;
		}

		String[] genres = new String[count];
		int start = 0;
		for(int x = 0; x<count; x++) {
			int end = line.indexOf("|", start);

			if(end != -1)
				genres[x] = line.substring(start, end);
			else //last one, not ended w/ |
				genres[x] = line.substring(start, line.length());
				
			start = end;
		}

		return genres;

	}
}
