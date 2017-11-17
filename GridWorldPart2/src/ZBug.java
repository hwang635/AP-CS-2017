import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug{

	int steps, length, turns;

	public ZBug(int zLength) {
		steps = 0;
		turns = 0;
		length = zLength;

		setDirection(Location.EAST);
	}

	public void act() {

		if(canMove()) {
			if(steps<length && turns < 3) {
				move();
				steps++;
			}
			else {
				if(turns == 0) {
					turn();
					turn();
					turn();

					steps = 0;
					turns++;
				}
				else if(turns == 1) {
					super.turn();
					super.turn();
					super.turn();
					super.turn();
					super.turn();

					steps = 0;
					turns++;
				}
				else if(turns == 2) {
					steps = 0;
					turns++;
				}
			}
		}
	}
}
