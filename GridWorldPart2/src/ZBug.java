import info.gridworld.grid.Location;

public class ZBug extends BoxBug{

	public ZBug(int length) {
		super(length);
	}
	
	public void turn() {
		//int y = 0;
		
		super.turn();
		setDirection(getDirection() + Location.HALF_RIGHT);
		//y++;
		
		//(if(turn == 2 && steps == length) {
		//}
	}

}
