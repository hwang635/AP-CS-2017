package helen.shapes;
import processing.core.PApplet;

/**
 * 
 * This class models a Processing-drawable Rectangle.
 * @author Helen Wang
 * @version 9.20.17
 *
 */
public class Rectangle{

	private double x, y, width, height;
	private boolean isGrey;
	private int r, g, b;
	
	//default rect, set all to zero
	/**
	 * sets default Rectangle, all to zero
	 */
	public Rectangle() {
	}

	//sets rect to arguments
	/**
	 * 
	 * Creates new instance of Rectangle object that
	 * 
	 * @param x X coordinate of the upper left corner of the rectangle
	 * @param y Y coordinate of the upper left corner of the rectangle
	 * @param width Pixel width
	 * @param height Pixel height
	 * @post boolean isGrey is true
	 */
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		isGrey = true;
	}

	/**
	 * 
	 * @return absolute value of the rectangle's perimeter
	 */
	public double getPerimeter() {
		double perimeter = Math.abs(2*width + 2*height);
		//printline to check answer

		return perimeter;
	}

	/**
	 * 
	 * @return absolute value of the rectangle's area
	 */
	public double getArea() {
		double area = Math.abs(width*height);
		//printline to check answer

		return area;
	}

	//checks the point is inside rect
	/**
	 * Checks if a point is inside the rectangle
	 * 
	 * @param x X coordinate of the point
	 * @param y Y coordinate of the point
	 * @return boolean of whether the point is inside the rectangle
	 */
	public boolean isPointInside(double x, double y) {
		boolean checkX = false, checkY = false;
		
		if(x>=this.x && x<=(this.x + width))
			checkX = true;
		if(y>= this.y && y<= (this.y + height)) 
			checkY = true;

		if(checkX == true && checkY == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//draw @default mode, (x,y) at the top left corner
	/**
	 * Draws the rectangle and fills, called on a Rectangle object in DrawingSurface
	 * @param marker PApplet object
	 * @post rectangle should be drawn, fill is set to noFill
	 */
	public void draw(PApplet marker) {		
		if(isGrey == true)
			marker.fill(g);
		else
			marker.fill(r, b, g);

		marker.rect((float)x, (float)y, (float)width, (float)height);
		marker.noFill();
	}

	//additional method #1
	//checks if height > width or vice versa or square
	/**
	 * @return String w/ the result of the side (width vs. height) that is greater or that it is a square
	 */
	public String isSquare() {
		//in case height, width are negative
		double h = Math.abs(height);
		double w = Math.abs(width);
		
		String result;

		if(h>w)
			result = "The rectangle has a longer height than width.";
		else if(w>h)
			result = "The rectangle has a longer width than height.";
		else
			result = "The rectangle is a square.";
		
		if(h != w && Math.abs(h-w) <0.00001)
			result = result + "The rectangle may be a square, the previous statement may be wrong because of rounding error.";
		
		return result;
	}
	
	//additiona method #2
	//moves by entered x, y
	/**
	 * Moves the rectangle
	 * 
	 * @param shiftX X pixels that the rectangle will be translated by
	 * @param shiftY Y pixels that the rectangle will be translated by
	 * @post fields x, y will be changed
	 */
	public void translate(double shiftX, double shiftY) {
		x = x + shiftX;
		y = y + shiftY;
	}
	
	//additional method #3
	//sets fill, if isGreyScale == true random greyscale colour, else = an actual rbg colour
	/**
	 * Will fill the rectangle in either w random gray shade or with a colour
	 * @param isGrey boolean of whether or not the shape should be filled in greyscale or with rbg colour
	 * @post the shape will be filled in w/ a colour, boolean isGrey will be set to the argument, and fields r, g, b, will be changed
	 */
	public void changeColour(boolean isGrey) {
		this.isGrey = isGrey;
		
		//random three values, only g is used if grayscale
		this.r = (int) (Math.random()*256);
		this.g = (int) (Math.random()*256);
		this.b = (int) (Math.random()*256);
	}
}
