package helen.shapes;
import processing.core.PApplet;

/**
 * This class models a processing-drawable circle
 * @author Helen Wang
 * @version 9.20.17
 *
 */
public class Circle {

	private double x, y, radius;
	private double area, perimeter;
	public boolean isGrey;
	private int r, g, b;

	//sets to zero
	/**
	 * Creates default instance of Circle, set to zero
	 */
	public Circle() {
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
		this.x = x;
		this.y = y;
		this.radius = radius;
		isGrey = true;

		this.area = this.getArea();
		this.perimeter = this.getPerimeter();
	}

	/**
	 * @return prints absolute value of the circumference of the circle
	 */
	public double getPerimeter() {
		double p = Math.abs(2*Math.PI*radius); //abs in case negative arg
		//pln to check

		return p;
	}

	/**
	 * 
	 * @return prints the positive area of the circle
	 */
	public double getArea() {
		double a = Math.abs(2*Math.PI*radius*radius); //abs in case neg arg
		//pln to check

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
		if(isGrey == true)
			marker.fill(g);
		else
			marker.fill(r, b, g);

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
	public void translate(double shiftX, double shiftY) {
		this.x = this.x + shiftX;
		this.y = this.y + shiftY;
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

		//random three values, only g is used if grayscale
		this.r = (int) (Math.random()*256);
		this.g = (int) (Math.random()*256);
		this.b = (int) (Math.random()*256);
	}

	//set method to draw illusion w,
	/**
	 * sets the colour of the circle, called in draw
	 * @pre draw will only draw w/ this grey colour if isGrey == true
	 * @param colour int greyscale value
	 */
	public void setColour(int colour) {
		g = colour;
	}
}