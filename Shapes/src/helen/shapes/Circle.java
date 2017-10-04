package helen.shapes;
import processing.core.PApplet;

/**
 * This class models a processing-drawable circle
 * @author Helen Wang
 * @version 9.20.17
 *
 */
public class Circle extends Shape{

	private double radius;
	public boolean isGrey;
	
	//fields bc used in choice method
	private double area, perimeter;

	//sets to zero
	/**
	 * Creates default instance of Circle, set to zero
	 */
	public Circle() {
		super(0,0);
	}

	//sets to entered arguments
	/**
	 * Creates new instance of Circle, with x,y at the upper left corner
	 * @param x X coordinate of the upper left corner of the rectangle the circle is inscribed in
	 * @param y Y coordinate of the upper left corner of the rectangle the circle is inscribed in
	 * @param radius Radius of the circle
	 * @post boolean isGrey is set to true, area and perimeter are set by the area/perimeter methods
	 */
	public Circle(double x, double y, double radius) {
		super(x,y);

		this.radius = radius;
		isGrey = false;

		this.area = this.calcArea();
		this.perimeter = this.calcPerimeter();
	}

	/**
	 * @return prints absolute value of the circumference of the circle
	 */
	public double calcPerimeter() {
		double p = Math.abs(2*Math.PI*radius); //abs in case negative arg
		//pln to check

		return p;
	}

	/**
	 * 
	 * @return prints the positive area of the circle
	 */
	public double calcArea() {
		double a = Math.abs(2*Math.PI*radius*radius); //abs in case neg arg

		return a;
	}

	//checks if entered point is inside the circle
	/**
	 * Checks if a point is inside the circle it is called on
	 * 
	 * @param x X coordinate of the point
	 * @param y Y coordinate of the point
	 * @return boolean of whether the point is inside the circle
	 */
	public boolean isPointInside(double x, double y) {

		//circle for equation x^2 + y^2 = r^2, split into 2 local var for readability
		double xPart = (x-this.x)*(x-this.x); //x^2
		double yPart = (y-this.y)*(y-this.y); //y^2

		if((xPart + yPart) <= (radius*radius)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Draws the circle and fills it in, called on a Circle object in DrawingSurface
	 * @param marker PApplet object
	 * @post circle should be drawn, fill is set to none
	 */
	public void draw(PApplet marker) {	
		super.draw(marker);
		
		if(isGrey == true)
			marker.fill(super.getColour(2));
		else
			marker.fill(getColour(1), getColour(2), getColour(3));

		marker.ellipseMode(PApplet.CORNER);
		marker.ellipse((float)x, (float)y, (float)radius, (float)radius);
		marker.noFill();
	}

	//additional method #1
	//checks whether the area/perimeter are smaller/larger than entered area/perimeter
	/**
	 * checks the implicit parameter circle has less, equal, or greater area/perimeter and prints out the answer
	 * @param area the area that is being compared to the circle's area
	 * @param perimeter the perimeter/circumference being compared to the circle's
	 * @return String w/ the result
	 */
	public String isLessThan(double area, double perimeter) {
		
		String resultA, resultP;
		
		if (area>this.area)
			resultA = "The circle has smaller area.";
		else if (area<this.area)
			resultA = "The circle has greater area.";
		else
			resultA = "The circle has the same area.";

		if(perimeter>this.perimeter)
			resultA = resultA + "The circle has less perimeter.";
		else if(perimeter<this.perimeter)
			resultA = resultA + "The circle has greater perimeter.";
		else
			resultA = resultA + "The circle has the same perimeter.";
		
		if(area != this.area && Math.abs(area-this.area) <0.00001)
			resultA = resultA + "The areas may be the same, the previous answer may be wrong due to rounding error.";
		if(perimeter != this.perimeter && Math.abs(perimeter-this.perimeter) <0.00001)
			resultA = resultA + "The perimeters may be the same, the previous answer may be wrong due to rounding eror.";
		
		return resultA;
	}

	//additional method #2
	//moves the shape by the entered ints
	/**
	 * Moves the circle
	 * 
	 * @param shiftX X pixels that the circle will be translated by
	 * @param shiftY Y pixels that the circle will be translated by
	 * @post fields x, y will be changed
	 */
	public void moveTo(double shiftX, double shiftY) {
		super.moveTo(shiftX, shiftY);
	}

	//additional method #3
	//sets fill, if isGreyScale == true random greyscale colour, else = an actual rbg colour
	/**
	 * Will fill the circle in either w random gray shade or with a colour
	 * @param isGrey boolean of whether or not the shape should be filled in greyscale or with rbg colour
	 * @post r, g, b will be set to new numbers and boolean isGrey may be changed
	 */
	public void changeColour(boolean isGrey) {
		this.isGrey = isGrey;

		//random three values for fbg, only g is used if grayscale
		super.setColour((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256));
	}

	//set method to draw illusion w,
	/**
	 * sets the colour of the circle, called in draw
	 * @pre draw will only draw w/ this grey colour if isGrey == true
	 * @param colour int greyscale value
	 */
	public void setColour(int colour) {
		super.setColour(0, colour, 0);
	}
}