
public class MovieLensCSVTranslator {

	public Movie parseMovie(String line) {
		//extract pieces of data from the line (by looking for commas)
		int comma = line.indexOf(",");
		//System.out.println(line);

		int id = Integer.parseInt(line.substring(0, comma));
		//System.out.println("id = " + id);

		line = line.substring(comma+1);
		//System.out.println(line);

		comma = line.indexOf(",");
		String title = "";
		int year = -1;
		if(line.charAt(0) == 34) {//34 = double quotes, ascii
			int endQuote = line.indexOf(34, 2);
			comma = endQuote+1;

			int p2 = line.lastIndexOf(")", endQuote);
			int p1 = line.lastIndexOf("(", endQuote);

			if(p1 != -1) {
				title = line.substring(0, p1-1) + "\"";
				//System.out.println("title = " + title);

				if(line.indexOf("-", p1) < p2) //if range, start year
					year = Integer.parseInt(line.substring(p1 + 1, p1+5));
				else
					year = Integer.parseInt(line.substring(p1 + 1, p2));
				//System.out.println("year = " + year);
			}
			else //no year
				title = line.substring(0, endQuote+1);
		} 
		else {
			int p2 = line.lastIndexOf(")", comma);
			int p1 = line.lastIndexOf("(", comma);

			if(p1 != -1) {//year + () exist
				title = line.substring(0, p1-1);
				//System.out.println("title = " + title);

				if(line.indexOf("-", p1) < p2) //if range of years, start year
					year = Integer.parseInt(line.substring(p1 + 1, p1+5));
				else
					year = Integer.parseInt(line.substring(p1 + 1, p2));
				//System.out.println("year = " + year);
			}
			else 
				title = line.substring(0, line.indexOf(",", comma));

		}

		line = line.substring(comma+1);
		//System.out.println("genres " + line);

		String[] genres = numGenres(line);
		//for(int i = 0; i<genres.length; i++)
		//System.out.print(genres[i] + " ");

		//construct movie obj
		Movie m = new Movie(id, title, year, genres);

		return m;
	}

	//912, missing piece
	public String[] parseLinks(String line) {
		String[] links = new String[2]; //String to keep leading zeroes

		int c = line.indexOf(",");
		line = line.substring(c+1); //remove movie id

		c = line.indexOf(",");
		String imdbID = line.substring(0, c); //make imdbid
		line = line.substring(c+1); //remove imdb id
		//System.out.println("imdb " + imdbID);

		String tmdbID = line;
		//System.out.println("tmdb " + tmdbID);

		links[0] = imdbID;
		links[1] = tmdbID;

		return links;
	}

	//returns -1 if same user, id is diff(construct new user)
	public int parseUser(String line, int prevID) {
		int comma = line.indexOf(",");
		int userID = Integer.parseInt(line.substring(0, comma)); //get user id
		
		if(userID == prevID)
			return -1;
		else
			return userID;
	}

	public Rating parseRating(String line) {
		int comma = line.indexOf(",");
		int userID = Integer.parseInt(line.substring(0, comma)); //get user id
		line = line.substring(comma+1);

		comma = line.indexOf(",");
		int movieID = Integer.parseInt(line.substring(0, comma)); //get movie id
		line = line.substring(comma+1);

		comma = line.indexOf(",");
		double rating = Double.parseDouble(line.substring(0, comma)); //get rating
		line = line.substring(comma+1);

		int time = Integer.parseInt(line);

		Rating r = new Rating(movieID, rating, time);

		return r;
	}

	//line 337, quotes in data
	public Tag parseTag(String line, Movie m) {
		int comma = line.indexOf(",");
		int userID = Integer.parseInt(line.substring(0, comma)); //get user id
		line = line.substring(comma+1);

		comma = line.indexOf(",");
		int movieID = Integer.parseInt(line.substring(0, comma)); //get movie id
		line = line.substring(comma+1);

		comma = line.indexOf(",");
		String tag = line.substring(0, comma); //get tag
		line = line.substring(comma);
		
		comma = line.indexOf(",");
		int timeStamp = Integer.parseInt(line); //get time

		Tag t = new Tag(tag, timeStamp);
		return t;
	}

	private String[] numGenres(String line) {
		int i = line.indexOf("|");
		int count = 1;

		while(i != -1 && i<line.length()-2) {
			i = line.indexOf("|", i+1);
			count++;
		}

		String[] genres = new String[count];

		int start = -1;
		for(int x = 0; x<count; x++) {
			int end = line.indexOf("|", start + 1);

			if(end != -1)
				genres[x] = line.substring(start+1, end);
			else //last one, not ended w/ |
				genres[x] = line.substring(start+1, line.length());

			start = end;
		}

		return genres;

	} 
}
