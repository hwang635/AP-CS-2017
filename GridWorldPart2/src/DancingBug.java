import info.gridworld.actor.Bug;

public class DancingBug extends Bug{
	int steps, count;
	int[] turns;

	public DancingBug(int[] turns) {
		this.turns = turns;
		steps = 0;
		count = 0;
	}

	public void act() {		
		if(canMove()) {
			move();
			steps++;
			if(count < turns.length) {
				for(int x = 0; x<turns[count]; x++) {
					turn();
				}
				count++;
			}
			else {
				count = 0;
			}
		}
		else {
			turn();
			steps++;
		}
	}

}
