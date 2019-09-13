
public class Genre implements Comparable<Genre> {

	private String genre;
	private double rating, ratingGE;
	private int movieID;
	private int count, countGE;

	public Genre(String g, int movieID) {
		genre = g;
		this.movieID = movieID;
		rating = 0;
		ratingGE = 0;
		count = 1;
		
		countGE = 1;
	}
	
	public Genre(String g) {
		genre = g;
	}

	public String getGenre() {
		return genre;
	}
	
	public void addRating(double r) {
		rating += r;
		count++;
	}

	public void addRatingGE(double r) {
		ratingGE += r;
	}
	
	public double getRating() {
		return rating;
	}

	public void incrementCountGE() {
		countGE++;
	}

	public int getCount() {
		return count;
	}
	
	public int getCountGE() {
		return countGE;
	}

	public double getAvgRating() {
		if(count != 0) {
			return rating/count;
		}
		else
			return -1.0;
	}
	
	public double getGERating() {
		if(count != 0) {
			return rating/countGE;
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
		double diffAvg = this.getAvgRating() - otherAvg;
		
//		System.out.println("genre=" + this.genre + ", other=" + other.getGenre()
//				+ ", diffCount=" + diffCount + ", diffAvg=" + diffAvg);
		if(diffCount != 0)
			return diffCount;
		else { //same count
			return (int) (this.getAvgRating() - otherAvg);
		} //end of else
	} //end of compareTo
	
}