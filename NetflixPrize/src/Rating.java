
public class Rating {
	
	double rating;
	int timeStamp;
	
	public Rating(double r, int t) {
		rating = r;
		timeStamp = t;
	}

	public double getRating() {
		return rating;
	}
	
	public int getTime() {
		return timeStamp;
	}
}
