package shapeDemo;

import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import java.awt.Color;

import helen.shapes.*;

public class DrawingSurface extends PApplet {
	
	private PhysicsShape s;
	private PhysicsShape s2;

	
	public DrawingSurface () {

		s = new PhysicsShape (new Circle(100, 100, 100));
		s2 = new PhysicsShape(new Rectangle(200, 100, 100, 100));
		}
		


	public void draw() {
		background(255);
		
		s.draw(this);
		s.act(this);
		s2.draw(this);
		s2.act(this);

	}
	
	public void mousePressed() {
	//	s.setVelocity(1, 1);
		s.jump();

	}
	
	
	
	
	

}
