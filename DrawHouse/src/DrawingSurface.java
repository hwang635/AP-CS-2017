import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {
	
	private House house;
	private Person bob;
	double ratio;
	
	public DrawingSurface() {
		house = new House();
		bob = new Person();
		
		ratio = 500.0;
	}
	
	public void draw() {
		//for scaling
		double xRatio = (double)width/ratio;
		double yRatio = (double)height/ratio;
		scale((float)xRatio, (float)yRatio);
		
		house.draw(this);
		bob.draw(this);
	
	}
	
	public void keyPressed() {
		if (keyCode == UP)
			house.moveUp();
		else if(keyCode == DOWN)
			house.moveDown();
		else if(keyCode == LEFT)
			house.moveLeft();
		else if(keyCode == RIGHT)
			house.moveRight();
		
		else if(key == 'u' || key == 'U')
			bob.goUp();
		else if(key == 'd' || key == 'D')
			bob.goDown();
		else if(key == 'r' || key == 'R')
			bob.goRight();
		else if(key == 'l' || key == 'L')
			bob.goLeft();
		
		redraw();
	}
	
	public void mousePressed() {
		if(mouseButton == LEFT)
			bob.changeHeadColour();
		else if(mouseButton == RIGHT)
			bob.changeEyeColour();
	}
	
	public void mouseWheel(MouseEvent event) {
		float e = event.getCount();
		
		if(e>0)
			ratio += 25;
		else if(e<0)
			ratio -= 25;
			
	}
}
