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
	
	public abstract double calcArea();
	
	public abstract double calcPerimeter();
	
	/*public boolean isIntersecting(Shape s) {
		return true;
	} */
	
	public boolean isPointInside(double x, double y) {
		return true;
	}

	public void draw(PApplet drawer) {
		drawer.stroke(strokeColour.getRGB());
		drawer.fill(fillColour.getRGB());
		drawer.strokeWeight(strokeWeight);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void moveBy(double x, double y) {
		this.x += x;
		this.y += y;
	}
	
	public void changeColour(boolean isGrey) {

	}

	public void setColour(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void setStrokeWeight(int weight) {
		strokeWeight = weight;
	}
	
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

