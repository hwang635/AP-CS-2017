import processing.core.PApplet;

public class Rectangle{
	
	private double x, y, width, height;

	//default rect, set all to zero
	public Rectangle() {
	}
	
	//sets rect to arguments
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
		marker.rect((float)x, (float)y, (float)width, (float)height);
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
	
	//additional method #2
	//draws a new rectangle at the same (x, y) but at the *1/n of the height/width
	public Rectangle scaledShape(double n) {
		double newWidth = width*(1.0/n);
		double newHeight = height*(1.0/n);
		Rectangle scaledRect = new Rectangle(this.x, this.y, newWidth, newHeight);
		 
		System.out.println("check, inside scaled shape for rect");
		
		return scaledRect;
	}
}
