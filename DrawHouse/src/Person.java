import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Person {
	
		int headX = 50;
		int headY = 350;
		int headColour = 15;
		int eyeR = 180;
		int eyeG = 80;
		int eyeB = 100;
	
	public void draw(PApplet drawer) {
		drawer.stroke(0);
		
		//head
		drawer.fill(headColour);
		drawer.ellipse(headX, headY, 50, 50);
		drawer.fill(eyeR, eyeG, eyeB);
		drawer.ellipse(headX - 10, headY - 5, 8, 8);
		drawer.ellipse(headX + 10, headY-5, 8, 8);
		drawer.noFill();
		//body
		drawer.line(headX, headY + 25, headX, headY + 70);
		//arms
		drawer.line(headX, headY + 40, headX + 15, headY + 35);
		drawer.line(headX, headY + 40, headX - 15, headY + 35);
		//legs
		drawer.line(headX, headY + 70, headX + 20, headY + 95);
		drawer.line(headX, headY + 70, headX - 20, headY + 95);
	}

	//moves up, down, right, left within boundaries of screen
	public void goUp() {
		if(headY>5)
			headY-= 20;
	}
	
	public void goDown() {
		if(headY<400)
			headY+= 20;
	}
	
	public void goRight() {
		if(headX<480)
			headX += 20;
	}
	
	public void goLeft() {
		if(headX>20)
			headX -= 20;
	}
	
	//changes colour of head to random greyscale
	public void changeHeadColour() {
		headColour = (int) (Math.random()*256.0);
	}
	
	//changes colour of eyes to random RBG colours
	public void changeEyeColour() {
		eyeR = (int) (Math.random()*256.0);
		eyeG = (int) (Math.random()*256.0);
		eyeB = (int) (Math.random()*256.0);
	}
}
