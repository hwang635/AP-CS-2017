package helen.shapes;
import processing.core.PApplet;
/*
 * Good things: 
 * - Your algorithm is well typed, easy to read.
 * - You found a nice way to check if the intersect point are within the line segments.
 * 
 *  
 * Places to Improve things:
 * - You set the variable as double, and then cast it back to int. Maybe set the variables as int at the beginning.
 * - Make sure that all of you fields are specifically to the ONE line. (intersect point and otherLine coordinate aren't good fields).
 * - After you set the right and left variables, you don't need the else statement.
 * - Try to make a dot at the intersect
 */

/**
 * This is a Processing drawable Line.
 * @author Helen Wang
 * @version 9.20.17
 *
 */
public class Line extends Shape{
	
	private double x2, y2;
	private int lineColour;
	
	//for drawing illusion
	private int strokeCap;
		
	//line w coordinates (x1, y1) to (x2, y2)
	/**
	 * Creates line with the two entered (x, y) points
	 * @param x1 X coordinate of the first point
	 * @param y1 Y coordinate of the first point
	 * @param x2 X coordinate of the second point
	 * @param y2 Y coordinate of the second point
	 */
	public Line(double x1, double y1, double x2, double y2) {
		super(x1, y1);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	//sets new coordinate for end of line
	/**
	 * Sets the second point of the line to the entered coordinates
	 * @param x2 New x-coordinate for the second point
	 * @param y2 New y-coordinate for the second point
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Uses PApplet to draw the line, called on a Line object in DrawingSurface
	 * @param drawer PApplet object
	 * @post a Line should be drawn 
	 */
	public void draw(PApplet drawer) {
		//drawer.stroke(strokeColour);
		//drawer.strokeWeight(strokeWeight);
		
		drawer.stroke(super.getColour(2)); //check if this is redundant
		
		if(strokeCap == 1)
			drawer.strokeCap(drawer.ROUND);
		else if(strokeCap == 2)
			drawer.strokeCap(drawer.SQUARE);
		else if(strokeCap == 3)
			drawer.strokeCap(drawer.PROJECT);
			
		drawer.line((float)x, (float)y, (float)x2, (float)y2);
	}
	
	/**
	 * Checks whether a Line and another Line intersect 
	 * @param other another Line object
	 * @return returns a boolean true or false of whether the lines intersect
	 */
	public boolean intersects(Line other) {
		//storing which x/y is lowest/furtherest left/etc
		int xLeft1, xLeft2, xRight1, xRight2;
		int yUp1, yUp2, yDown1, yDown2;
		
		boolean check1 = false;
		boolean check2 = false;
				
		double x3 = other.x;
		double x4 = other.x2;
		double y3 = other.y;
		double y4 =  other.y2;
		
		//if x1 is more right than x2 ==> x2 is left, to use later
		// or if same, doesn't matter
		if(x>=x2) {
			xLeft1 =  (int) x2;
			xRight1 = (int) x;
		}
		else {
			xLeft1 = (int) x;
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
		if(y>=y2) {
			yUp1 = (int) y;
			yDown1 = (int) y2;
		}
		else {
			yUp1 = (int) y2;
			yDown1 = (int) y;
		}
		if(y3>=y4) {
			yUp2 = (int) y3;
			yDown2 = (int) y4;
		}
		else {
			yUp2 = (int) y4;
			yDown2 = (int) y3;
		}
		
		double pointX = ((x*y2-y*x2)*(x3 - x4) - (x-x2)*(x3*y4 - y3*x4))/((x-x2)*(y3-y4) - (y-y2)*(x3-x4));
		double pointY = ((x*y2 - y*x2)*(y3-y4) - (y-y2)*(x3*y4 - y3*x4))/((x-x2)*(y3-y4) - (y-y2)*(x3-x4));
		
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

	//set methods to make illusion w, set colour + line thickness
	/**
	 * sets the colour of the line, called in draw
	 * @param colour greyscale value
	 * @post field lineColour changed
	 */
	public void setColour (int colour) {
		super.setColour(0, colour, 0);
	}
	
	/**
	 * sets thickness of the line, called in draw
	 * @param size strokeWeight of the line
	 * @post field lineSize changed
	 */
	public void setStrokeWeight (int weight) {
		super.setStrokeWeight(weight);
	}
	
	//for drawing illusion
	/**
	 * changes the strokecap shape of the line, called in draw method
	 * 
	 * @param n int 1, 2, 3 that determines which strokecap it is
	 * @post will change field strokecap
	 */
	public void changeStrokeShape(int n) {
		 strokeCap = n;
	}

	@Override
	public double calcArea() {
		return 0;
	}

	@Override
	public double calcPerimeter() {
		return 0;
	}

	@Override
	/**
	 * checks if the point is on the line
	 * @param x X coordinate of point
	 * @param y Y coordinate of the point
	 * @return returns true or false whether the point is on the line
	 */
	public boolean isPointInside(double x, double y) {
		boolean checkX = false, checkY= false;
		
		if((x >= this.x && x <= this.x2) || (x<= this.x && x>= this.x2))
			checkX = true;
		if((y >= this.y && y <= this.y2) || (y<= this.y && y>= this.y2))
			checkY = true;
		
		if(checkX == true && checkY == true)
			return true;
		else
			return false;
	}

	@Override
	public void changeColour(boolean isGrey) {
		// TODO Auto-generated method stub
		
	}

}