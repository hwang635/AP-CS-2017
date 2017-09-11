import java.awt.Dimension;

import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private House house;
	private Person bob, shelby;
	private Line tester;
	private Sun sun;

	private double sunX, sunY, sunW, sunH;
	private boolean bobDead, shelbyDead;
	private int bIntersect, sIntersect;

	public DrawingSurface() {
		house = new House();
		bob = new Person("Bob!", 50, 350, 15, 180, 80, 100);
		shelby = new Person("Shelby!", 180, 350, 60, 30, 255, 30);
		tester = new Line();
		sun = new Sun();

		bIntersect = 0;
		sIntersect = 0;
		bobDead = false;
		shelbyDead = false;
	}

	public void draw() {
		//for scaling
		background(153, 203, 255);

		double xRatio = (double)width/500.0;
		double yRatio = (double)height/500.0;
		scale((float)xRatio, (float)yRatio);

		house.draw(this);
		sun.draw(this);
		
		//effects after the death of one of the persons
		if(bobDead == false)
			bob.draw(this);
		else {
			fill(50);
			textSize(20);
			text("Bob has died :(", 190, 60);
			noFill();		
		}

		if(shelbyDead == false)
			shelby.draw(this);
		else {
			fill(50);
			textSize(20);
			text("Shelby has died :(", 190, 60);
			noFill();
		}
	}

	public void keyPressed() {
		//for house movement
		if (keyCode == UP)
			house.move(1);
		else if(keyCode == DOWN)
			house.move(2);
		else if(keyCode == LEFT)
			house.move(3);
		else if(keyCode == RIGHT)
			house.move(4);

		//for person movement
		else if(key == 'u')
			bob.go(1);
		else if(key == 'd')
			bob.go(2);
		else if(key == 'r')
			bob.go(3);
		else if(key == 'l')
			bob.go(4);

		//for line final goal
		else if(key == 'U')
			shelby.go(1);
		else if(key == 'D')
			shelby.go(2);
		else if(key == 'R')
			shelby.go(3);
		else if(key == 'L')
			shelby.go(4);


		if(tester.intersects(bob.rightArm, shelby.leftArm) == true) {
			//sun.change(3);
			bob.go(4);
			shelby.go(3);
			System.out.println("right, left" + bIntersect);

			bIntersect++;
			if(bIntersect == 10) {
				bobDead = true;
				System.out.println("bob has died" + bIntersect);

				shelby.smile();
			}
		}
		else if(tester.intersects(bob.leftArm, shelby.rightArm) == true) {
			//sun.change(4);
			bob.go(3);
			shelby.go(4);
			System.out.println("left, right");

			sIntersect++;
			if(sIntersect == 10) {
				shelbyDead = true;
				System.out.println("shelby has died");

				bob.smile();
			}
		}

		//testing purposes for scaling since laptop doesn't have mouse wheel
		else if(key == 'a')
			house.scale(1);
		else if(key == 's')
			house.scale(2);


		redraw();
	}

	public void mousePressed() {
		//changes colour of face/eye when left/right is pressed
		if(mouseButton == LEFT) {
			bob.changeHeadColour();
			shelby.changeHeadColour();
		}
		else if(mouseButton == RIGHT) {
			bob.changeEyeColour();
			shelby.changeEyeColour();
		}
	}

	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();

		//scales house larger and smaller
		if(e>0)
			house.scale(1);
		else if(e<0)
			house.scale(2);

	}
}
