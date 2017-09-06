import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Person {

	private int headX;
	private int headY;
	private int headColour;
	private int eyeR;
	private int eyeG;
	private int eyeB;
	
	Line rightArm, leftArm;

	public Person(int headX, int headY, int headColour, int eyeR, int eyeG, int eyeB) {
		this.headX = headX;
		this.headY = headY;
		this.headColour = headColour;
		this.eyeR = eyeR;
		this.eyeG = eyeG;
		this.eyeB = eyeB;
	}


	public void draw(PApplet drawer) {
		//called here so would be cont recalced for intersect use
		rightArm = new Line(headX, headY + 40, headX + 15, headY + 35);
		leftArm = new Line(headX, headY + 40, headX - 15, headY + 35);
		
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
	public void go(int i) {
		if(i == 1) {
			if(headY>5)
				headY -= 20;
		}
		else if(i == 2) {
			if(headY<400)
				headY+= 20;
		}
		else if(i == 3) {
			if(headX<480)
				headX += 20;
		}
		else if(i == 4) {
			if(headX>20)
				headX -= 20;
		}

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
