
public class Genre implements Comparable<Genre> {

	private String genre;
	private double rating;
	private int movieID;
	private int count;

	public Genre(String g, int movieID) {
		genre = g;
		this.movieID = movieID;
		rating = 0;
		count = 1;
	}
	
	public Genre(String g) {
		genre = g;
	}

	public String getGenre() {
		return genre;
	}
	
	public void addRating(double r) {
		rating += r;
	}

	public double getRating() {
		return rating;
	}

	public void incrementCount() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public double getAvgRating() {
		if(count != 0) {
			return rating/count;
		}
		else
			return -1.0;

	}

	@Override
	public int compareTo(Genre other) {
		// TODO Auto-generated method stub
		int otherCount = other.getCount();
		double otherAvg = other.getAvgRating();

		int diffCount = count - otherCount;

		if(diffCount != 0)
			return diffCount;
		else { //same count
			double diffAvg = this.getAvgRating() - otherAvg;
			if(diffAvg < 0) 
				return -1;
			else
				return 1;

		} //end of else
	} //end of compareTo
	
}
