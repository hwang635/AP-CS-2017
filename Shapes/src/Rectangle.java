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
	 * Creates new instance of Rectangle object
	 * 
	 * @param x X coordinate of the upper left corner of the rectangle
	 * @param y Y coordinate of the upper left corner of the rectangle
	 * @param width Pixel width
	 * @param height Pixel height
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
		System.out.println("Perimeter is " + perimeter);

		return perimeter;
	}

	/**
	 * 
	 * @return absolute value of the rectangle's area
	 */
	public double getArea() {
		double area = Math.abs(width*height);
		//printline to check answer
		System.out.println("Area is " + area);

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
			System.out.println("isPointInside is true"); //printline to check answer
			return true;
		}
		else {
			System.out.println("isPointInside is false"); //pln to check answer
			return false;
		}
	}
	
	//draw @default mode, (x,y) at the top left corner
	/**
	 * Draws the rectangle and fills, called on a Rectangle object in DrawingSurface
	 * @param marker PApplet object
	 * @post rectangle should be drawn
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
	 * Prints out the side (width vs. height) that is greater or prints that it is a square
	 */
	public void isSquare() {
		//in case height, width are negative
		double h = Math.abs(height);
		double w = Math.abs(width);

		if(h>w)
			System.out.println("The rectangle has a longer height than width");
		else if(w>h)
			System.out.println("The rectangle has a longer width than height");
		else
			System.out.println("The rectangle is a square");
	}
	
	//additiona method #2
	//moves by entered x, y
	/**
	 * Moves the rectangle
	 * 
	 * @param shiftX X pixels that the rectangle will be translated by
	 * @param shiftY Y pixels that the rectangle will be translated by
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
	 * @post the implicit parameter (shape) will be filled in with a colour
	 */
	public void changeColour(boolean isGrey) {
		this.isGrey = isGrey;
		
		//random three values, only g is used if grayscale
		this.r = (int) (Math.random()*256);
		this.g = (int) (Math.random()*256);
		this.b = (int) (Math.random()*256);
		
		System.out.println("colour, rect has been accessed");
	}
}
