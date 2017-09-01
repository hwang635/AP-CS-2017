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
		//storing which x/y is lowest/furtherest left/etc
		int xLeft1, xLeft2, xRight1, xRight2;
		int yUp1, yUp2, yDown1, yDown2;
		
		boolean check1 = false;
		boolean check2 = false;
		
		this.x3 = other.x1;
		this.x4 = other.x2;
		this.y3 = other.y1;
		this.y4 =  other.y2;
		
		//if x1 is more right than x2 ==> x2 is left, to use later
		// or if same, doesn't matter
		if(x1>=x2) {
			xLeft1 = (int) x2;
			xRight1 = (int) x1;
		}
		else {
			xLeft1 = (int) x1;
			xRight1 = (int) x2;
		}
		if(x3>=x4) {
			xRight2 = (int) x3;
			xLeft2 = (int) x4;
		}
		else {
			xRight2 = (int) x4;
			xLeft2 = (int) x3;
		}
			
		//same for y
		if(y1>=y2) {
			yUp1 = (int) y1;
			yDown1 = (int) y2;
		}
		else {
			yUp1 = (int) y2;
			yDown1 = (int) y1;
		}
		if(y3>=y4) {
			yUp2 = (int) y3;
			yDown2 = (int) y4;
		}
		else {
			yUp2 = (int) y4;
			yDown2 = (int) y3;
		}
		
		pointX = (int) (((x1*y2-y1*x2)*(x3 - x4) - (x1 - x2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4)));
		pointY = (int) (((x1*y2 - y1*x2)*(y3-y4) - (y1-y2)*(x3*y4 - y3*x4))/((x1-x2)*(y3-y4) - (y1-y2)*(x3-x4)));
		
		if(pointX >= xLeft1 && pointX <= xRight1) {
			if(pointY <= yUp1 && pointY >= yDown1)
				check1 = true;
		}
		
		if(pointX >= xLeft2 && pointX <= xRight2) {
			if(pointY <= yUp2 && pointY >= yDown2)
				check2 = true;
		}
		
		if(check1 == true && check2 == true)
			return true;
		else
			return false;
	}

}
