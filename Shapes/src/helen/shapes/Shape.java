package helen.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * Abstract class used for Rectangle, Circle, and Line. 
 * @author Helen Wang
 *
 */
public abstract class Shape {

	protected double x, y;
	
	private Color strokeColour, fillColour;
	private int strokeWeight;
	
	//for choice methods
	private int r,g,b;
	private boolean isGrey;
	
	//has x, y, default stroke to black and fill to white
	/**
	 * Sets the x and y as the upper left coordinates of the shape
	 * @param x X coordinate of upper left corner
	 * @param y Y coordinate of upper left corner
	 * @post strokeColour and fill Colour are set to black and white respectively, and strokeWeight is set to 1
	 */
	public Shape(double x, double y) {
		this(x, y, Color.BLACK, Color.WHITE, 1);
	}
	
	/**
	 * Sets x, y as the upper left corner; sets the stroke/fillColours/strokeWeight to the arguments
	 * @param x X coordinate of the upper left corner of the shape
	 * @param y Y coordinate of the upper left corner of the shape
	 * @param strokeColour Colour of the border
	 * @param fillColour Colour of the inside of the shape
	 * @param strokeWeight The width of the stroke/border
	 */
	public Shape(double x, double y, Color strokeColour, Color fillColour, int strokeWeight) {
		this.x = x;
		this.y = y;
		this.strokeColour = strokeColour;
		this.fillColour = fillColour;
		this.strokeWeight = strokeWeight;
	}
	/**
	 * calculates the area of the shape
	 * @return the positive value of the area as a decimal
	 */
	public abstract double calcArea();
	
	/**
	 * calculates the perimeter of the shape
	 * @return returns the positive value of the perimeter as a decimal
	 */
	public abstract double calcPerimeter();
	
	/*public boolean isIntersecting(Shape s) {
		return true;
	} */
	
	/**
	 * checks if the point is inside the shape
	 * @param x X coordinate of the point
	 * @param y Y coordinate of the point
	 * @return returns whether or not the point is in/on the shape
	 */
	public abstract boolean isPointInside(double x, double y);

	/**
	 * draws the shape with stroke colour, fill colour, and strokeWeight according to the constructor
	 * @param drawer PApplet object
	 * @pre object must have been initialised in the constructor
	 * @post object will be drawn according to its colours/strokeWeight
	 * 
	 */
	public void draw(PApplet drawer) {
		drawer.stroke(strokeColour.getRGB());
		drawer.fill(fillColour.getRGB());
		drawer.strokeWeight(strokeWeight);
	}
	
	/**
	 * 
	 * @return returns the X coordinate of the upper left corner
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @return returns the Y coordinate of the upper left corner
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * moves the object to the new point by moving it's upper left corner
	 * @param x New x-coordinate of the upper left corner
	 * @param y New y-coordinate of the upper left corner
	 * @post fields x, y, will be changed
	 */
	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/** 
	 * moves the object by the specified x,y units
	 * @param x How much the object is moved horizontally
	 * @param y How much the object is moved vertically
	 * @post fields x, y, will be changed
	 */
	public void moveBy(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	//choice method, used by Rectangle and Circle
	public abstract void changeColour(boolean isGrey);

	/**
	 * sets the colour of the object
	 * @param r int value for red
	 * @param g int value for green
	 * @param b int value for blue
	 * @post changes fields r, g, b
	 */
	public void setColour(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/**
	 * sets the strokeWeight to a new value
	 * @param weight new value for strokeWeight
	 */
	public void setStrokeWeight(int weight) {
		strokeWeight = weight;
	}
	
	/**
	 * returns the current r g b values
	 * @pre must enter int between 1-3 to get a correct value
	 * @param choice which value they want (1 is r, 2 is g, 3 is b)
	 * @return returns the corresponding value
	 */
	public int getColour(int choice) {
		
		if(choice == 1)
			return r;
		else if (choice == 2)
			return g;
		else if (choice == 3)
			return b;
		else
			return 0;
	}
	
}

