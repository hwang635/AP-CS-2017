import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;


//this ZBug doesn't work, Zbug.java works
public class ZBug2 extends Bug{

	int steps, turns, sideLength;

	public ZBug2(int length) {
		steps = 0;
		turns = 1;
		sideLength = length;
	}

	public boolean canMove()
	{	
		if(super.canMove()) {
			return true;
		} else {
			return false;
		}
	}

	public void move() {		
		super.move();

		/*if(steps == -1) {
			Zturn();
			steps = 0;
		}
		else */ if(steps == sideLength && turns <= 2) {
			Zturn();
			steps--;
		}

		steps++;
	}

	public void Zturn() {
		 if(turns == 1) {
			super.turn();
			super.turn();
			super.turn();
		}
		else if(turns == 2) {
			super.turn();
			setDirection(getDirection() - 4*Location.HALF_RIGHT);
		}

		turns++;
		steps = 0;
	}

	public void turn() {
		super.turn();
		steps = 0;
	}
}