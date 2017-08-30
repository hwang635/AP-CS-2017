import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	
	private House house;
	private Person bob;
	
	public DrawingSurface() {
		house = new House();
		bob = new Person();
		
	}
	
	public void draw() {
		//for scaling
		double xRatio = (double)width/500.0;
		double yRatio = (double)height/500.0;
		scale((float)xRatio, (float)yRatio);
		
		house.draw(this);
		bob.draw(this);
	
	}
	
	public void keyPressed() {
		//for house movement
		if (keyCode == UP)
			house.moveUp();
		else if(keyCode == DOWN)
			house.moveDown();
		else if(keyCode == LEFT)
			house.moveLeft();
		else if(keyCode == RIGHT)
			house.moveRight();
		
		//for person movement
		else if(key == 'u' || key == 'U')
			bob.goUp();
		else if(key == 'd' || key == 'D')
			bob.goDown();
		else if(key == 'r' || key == 'R')
			bob.goRight();
		else if(key == 'l' || key == 'L')
			bob.goLeft();
		
		
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
		if(mouseButton == LEFT)
			bob.changeHeadColour();
		else if(mouseButton == RIGHT)
			bob.changeEyeColour();
	}
	
	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();
		
		//scales house larger and smaller
		if(e>0)
			house.scaleUp();
		else if(e<0)
			house.scaleDown();
			
	}
}
