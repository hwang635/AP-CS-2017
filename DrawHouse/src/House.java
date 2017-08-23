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
		drawer.stroke(200, 100, 80);
		drawer.triangle(houseX, houseY, houseX + 150, houseY - 50, houseX + 300, houseY);
		//door
		drawer.stroke(200, 120, 5);
		drawer.rect(houseX + 120, houseY + 110, 60, 90);
		//windows
		drawer.stroke(135, 206, 235);
		drawer.rect(houseX + 35, houseY + 40, 50, 50);
		drawer.rect(houseX + 215, houseY + 40, 50, 50);
	}

	//4 methods that move house according to arrow keys
	public void moveUp() {
		if(houseY>0)
			houseY -= 10;
	}
	
	public void moveDown() {
		if(houseY<500)
			houseY += 10;
	}

	public void moveLeft() {
		if(houseX>0)
			houseX -= 10;
	}
	
	public void moveRight() {
		if(houseX<400)
			houseX += 10;
	}
}