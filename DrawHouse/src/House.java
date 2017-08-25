import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class House{

	int houseX = 100;
	int houseY = 180;

	public void draw(PApplet drawer) {
		drawer.background(255, 255, 255);

		drawer.stroke(0, 0, 0);	
		//building
		drawer.rect(houseX, houseY, 300, 200);
		drawer.stroke(180, 100, 80);
		drawer.fill(150, 80, 80);
		drawer.triangle(houseX, houseY, houseX + 150, houseY - 50, houseX + 300, houseY);
		//door
		drawer.stroke(200, 120, 5);
		drawer.fill(200, 120, 5);
		drawer.rect(houseX + 120, houseY + 110, 60, 90);
		drawer.stroke(5);
		drawer.fill(0);
		drawer.ellipse(houseX + 170, houseY + 150, 6, 6);
		//windows
		drawer.stroke(135, 206, 235);
		drawer.fill(135, 206, 235);
		drawer.rect(houseX + 35, houseY + 40, 50, 50);
		drawer.rect(houseX + 215, houseY + 40, 50, 50);
		drawer.noFill();
	}

	//4 methods that move house according to arrow keys
	public void moveUp() {
		if(houseY>50)
			houseY -= 10;
	}
	
	public void moveDown() {
		if(houseY<300)
			houseY += 10;
	}

	public void moveLeft() {
		if(houseX>0)
			houseX -= 10;
	}
	
	public void moveRight() {
		if(houseX<200)
			houseX += 10;
	}
}