
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private IrregularPolygon poly;

	private int ANIMATION_TIME = 100;
	private float x,y,time;

	public DrawingSurface() {
		poly = new IrregularPolygon();
		/*Point2D.Double point1 = new Point2D.Double(20,10);
		Point2D.Double point2 = new Point2D.Double(70,20);
		Point2D.Double point3 = new Point2D.Double(50,50);
		Point2D.Double point4 = new Point2D.Double(0,40); */

		Point2D.Double point1 = new Point2D.Double(120,10);
		Point2D.Double point2 = new Point2D.Double(170,20);
		Point2D.Double point3 = new Point2D.Double(150,50);
		Point2D.Double point4 = new Point2D.Double(60,40);
				
		poly.add(point1);
		poly.add(point2);
		poly.add(point3);
		poly.add(point4);	

		//poly.scale(3.5);
		poly.setStrokeWeight(10);
		
		runSketch();
	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		fill(255);
		textAlign(CENTER);
		textSize(12);

		if (poly != null) {
			poly.draw(this);

			fill(0);
			text("Perimeter: " + poly.calcPerimeter() + "\nArea: " + poly.calcArea(),(float)width/2,(float)20);
		}
		if (time > 0) {
			time-=2;
			float size = (float)Math.sin((ANIMATION_TIME-time)/ANIMATION_TIME*Math.PI)*10;
			ellipse(x, y, size, size);
		}

	}


	public void mousePressed() {
		if (mouseButton == LEFT) {
			poly.add(new Point2D.Double(mouseX,mouseY));
			x = mouseX;
			y = mouseY;
			time = ANIMATION_TIME;
		} 
		else { //if right click, end point of polygon
			time = ANIMATION_TIME;
			poly.setEnd(true); //tells it that this is the end point
		}
	}



	public void keyPressed() {
		if (keyCode == KeyEvent.VK_SPACE) {
			poly = new IrregularPolygon();
		} 
		
		if(keyCode == KeyEvent.VK_UP) { //testing bc no mouse on laptop
			time = ANIMATION_TIME;
			
			poly.setEnd(true);
		}
		if(keyCode == KeyEvent.VK_DOWN) { //testing bc no mouse on laptop
			time = ANIMATION_TIME;
			poly.setEnd(false);
		}
	}


}










