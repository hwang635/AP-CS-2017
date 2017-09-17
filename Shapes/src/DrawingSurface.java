import processing.core.PApplet;

public class DrawingSurface extends PApplet{

	public Rectangle rect1, rect2, rect3, rectTest;
	public Circle circle1, circle2;

	public DrawingSurface() {
		rect1 = new Rectangle();
		rect2 = new Rectangle(0, 80, 400, 160);
		rect3 = new Rectangle(100, -100, 20, -300);
		
		rectTest = new Rectangle(200, 100, 100, 100);

		circle1 = new Circle();
		circle2 = new Circle(50, 50, 50);
	}

	public void draw() {
		rect1.draw(this);
		//rect2.draw(this);
		rect3.draw(this);
		rectTest.draw(this);

		circle1.draw(this);
		circle2.draw(this);

		if(keyPressed == true) {
			rect3.getPerimeter();
			rect3.getArea();
			rect3.isPointInside(0, 100);
			rect3.isPointInside(10, 5);
			rect3.isSquare();
			rect3.translate(50, 50);
			rect3.changeColour(false);
			
			rectTest.getPerimeter();
			rectTest.getArea();
			rectTest.isPointInside(100, 200);
			rectTest.isPointInside(10, 5);
			rectTest.isSquare();
			rectTest.translate(50, 50);
			rectTest.changeColour(true);
			

			circle2.getPerimeter();
			circle2.getArea();
			circle2.isPointInside(0, 100);
			circle2.isPointInside(80, 75);
			circle2.isLessThan(50, 50);
			circle2.translate(20, -2);
			circle2.changeColour(true);

			keyPressed = false;
		}
	}
}
