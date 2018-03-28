
public class Genre {
	
	private String genre;
	private double rating;
	
	public Genre(String g) {
		genre = g;
	}
	
	public void addRating(double r) {
		rating += r;
	}
	
	public double getRating() {
		return rating;
	}

}
