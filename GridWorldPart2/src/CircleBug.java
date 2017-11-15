import org.omg.PortableInterceptor.LOCATION_FORWARD;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * CircleBug is identical to BoxBug, except that it turns once instead of twice
 * @author Helen Wang
 *
 */
public class CircleBug extends BoxBug{

	public CircleBug(int length) {
		super(length);
	}

	public void turn() {
		super.turn();
		setDirection(getDirection() - Location.HALF_RIGHT);
	}

	/*int steps, sideLength;

	public CircleBug(int length) {
		steps = 0;
		sideLength = length;
	}

	public void turn() {
		super.turn();
		steps = 0;
	}

	public boolean canMove()
	{
		if(super.canMove() && steps<sideLength) {
			return true;
		} else {
			return false;
		}
	}

	public void move() {
		super.move();
		steps++;
	} */
}
