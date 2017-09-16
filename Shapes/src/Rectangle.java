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
		return 2*x + 2*y;
	}
	
	public double getArea() {
		return x*y;
	}
	
	//checks the point is inside rect
	public boolean isPointInside(double x, double y) {
		boolean checkX = false, checkY = false;
		
		if(x>=this.x && x<=(this.x + width))
			checkX = true;
		if(y>= this.y && y<= (this.y + height)) 
			checkY = true;
		
		if(checkX == true && checkY == true)
			return true;
		else
			return false;
	}
	
	//draw @default mode, (x,y) at the top left corner
	public void draw(PApplet marker) {
		marker.rect((float)x, (float)y, (float)width, (float)height);
	}

	//additional method #1
	//checks if height > width or vice versa or square
	public void isSquare() {
		if(height>width)
			System.out.println("The rectangle has a longer height than width");
		else if(width>height)
			System.out.println("The rectangle has a longer width than height");
		else
			System.out.println("The rectangle is a square");
	}
	
	//additional method #2
	//draws a new rectangle at the same (x, y) but at the *1/n of the height/width
	public Rectangle scaledShape(double n) {
		double newWidth = width*(1.0/n);
		double newHeight = height*(1.0/n);
		
		return new Rectangle(this.x, this.y, newWidth, newHeight);
	}
}
