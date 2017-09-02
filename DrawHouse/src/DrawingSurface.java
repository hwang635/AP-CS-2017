import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private House house;
	private Person bob, shelby;
	private Line tester;


	public DrawingSurface() {
		house = new House();
		bob = new Person(50, 350, 15, 180, 80, 100);
		shelby = new Person( 80, 350, 60, 30, 255, 30);
		tester = new Line();
	}

	public void draw() {
		//for scaling
		double xRatio = (double)width/500.0;
		double yRatio = (double)height/500.0;
		scale((float)xRatio, (float)yRatio);

		house.draw(this);
		bob.draw(this);
		shelby.draw(this);

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

		if(tester.intersects(bob.rightArm, shelby.rightArm) == true)
			background(229, 255, 204);
		else if(tester.intersects(bob.leftArm, shelby.leftArm) == true)
			background(229, 255, 204);
		else if(tester.intersects(bob.rightArm, shelby.leftArm) == true)
			background(229, 255, 204);
		else if(tester.intersects(bob.leftArm, shelby.rightArm) == true)
			background(229, 255, 204);
		else
			background(153, 203, 255);


		/*testing purposes for scaling since laptop doesn't have mouse wheel
		 * else if(key == 'a')
			house.scaleDown();
		else if(key == 's')
			house.scaleUp();
		 */

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
