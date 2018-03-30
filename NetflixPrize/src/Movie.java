import java.util.ArrayList;

public class Movie implements Comparable<Movie>{

	private int movieID;
	private String title;
	private int year;
	private String[] genres;
	private ArrayList<Tag> tags;
	private ArrayList<Rating> ratings;
	private double sumRating;

	private double inceptionEffect;

	private String imdbID,tmdbID; //Strings to keep leading zeroes

	public Movie(int movieID, String title, int year, String[] genres) {
		this.movieID = movieID;
		this.title = title;
		this.year = year;
		this.genres = genres;
		tags = new ArrayList<Tag>();
		ratings = new ArrayList<Rating>();

		sumRating = 0.0;
		inceptionEffect = 0.0;
	}

	public Movie (int movieID) {
		this.movieID = movieID;
	}
	public void addLinks(String[] ids) {
		imdbID = ids[0];
		tmdbID = ids[1];

		if(tmdbID.length() == 0)
			tmdbID = "no info";
		if(imdbID.length() == 0)
			imdbID = "no info";
	}

	//to String method
	public String toString() {
		String output = movieID + ", " + title + " (" + year + "), ";

		for(int i = 0; i<genres.length-1; i++) {
			output += (genres [i] + "|");
		}
		output += genres[genres.length-1];

		//output += (" imdbID = " + imdbID + " tmdbID = " + tmdbID);

		return output;
	}

	public int getID() {
		return movieID;
	}

	public void addTag(Tag t) {
		tags.add(t);
	}

	public void addRating(Rating r) {
		ratings.add(r);
		sumRating += r.getRating();
	}


	public double getAvgRating() {
		int size = ratings.size();
		if(size>0)
			return sumRating/size;
		else
			return -1.0;
	}

	public double getInceptionEffect(double baseline) {
		double i = this.getAvgRating();
		i = i - baseline;

		return i;
	}

	public double getRatingSum() {
		return sumRating;
	}

	public double getNumRatings() {
		return ratings.size();
	}

	public String[] getGenres() {
		return genres;
	}

	public void setGenre(ArrayList<String> genre) {
		if(genres.length == 0) //no genres
			genre.add("No genres");
		else {
			for(String s: genres)
				genre.add(s);
		}
	}

	public boolean hasGenre(Genre other) {
		String s = other.getGenre();
		for(String g : genres) {
			if(g.equals(s))
				return true;
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Movie arg0) {
		// TODO Auto-generated method stub
		return movieID - arg0.getID();
	}

	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getIMDB() {
		return imdbID;
	}
	
	public String getTMDB() {
		return tmdbID;
	}
}
