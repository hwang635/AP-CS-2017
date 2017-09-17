import processing.core.PApplet;

public class Rectangle{

	private double x, y, width, height;
	private boolean isGrey;
	private int r, g, b;
	
	//default rect, set all to zero
	public Rectangle() {
	}

	//sets rect to arguments
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		isGrey = true;
	}

	public double getPerimeter() {
		double perimeter = Math.abs(2*width + 2*height);
		//printline to check answer
		System.out.println("Perimeter is " + perimeter);

		return perimeter;
	}

	public double getArea() {
		double area = Math.abs(width*height);
		//printline to check answer
		System.out.println("Area is " + area);

		return area;
	}

	//checks the point is inside rect
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
	public void translate(double shiftX, double shiftY) {
		x = x + shiftX;
		y = y + shiftY;
	}
	//additional method #3
	//sets fill, if isGreyScale == true random greyscale colour, else = an actual rbg colour
	public void changeColour(boolean isGrey) {
		this.isGrey = isGrey;
		
		//random three values, only g is used if grayscale
		this.r = (int) (Math.random()*256);
		this.g = (int) (Math.random()*256);
		this.b = (int) (Math.random()*256);
		
		System.out.println("colour, rect has been accessed");
	}
}
