import processing.core.PApplet;

public class Line {
	
	private double x1, x2, y1, y2;
	private double x3, y3, x4, y4;
	private int pointX, pointY;
	
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
		this.x3 = other.x1;
		this.x4 = other.x2;
		this.y3 = other.y1;
		this.y4 =  other.y2;
		
		pointX = (int) (((x1*y2)*(x3 - x4) - (x1 - x2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4)));
		pointY = (int) (((x1*y2 - y1*x2)*(y3-y4) - (y1-y2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4)));
		
		//if(pointX > this.x1 && pointX < this.x2 && pointX 
		return false;
	}

}
