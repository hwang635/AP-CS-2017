import processing.core.PApplet;

public class Line {
	
	double x1, x2, y1, y2;
	
	//line w coordinates (x1, y1) to (x2, y2)
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	//sets new coordinate for end of line
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(PApplet drawer) {
		drawer.line((int)x1, (int)y1, (int)x2, (float)y2);
	}
	
	public boolean intersects(Line other) {
		int pointX, pointY;
		pointX = (x1*x2)*(
		return false;
	}

}
