
public class SpiralBug extends BoxBug {
	
	public SpiralBug(int length) {
		super(length);
	}
	
	public void turn() {
		super.turn();
		super.addSideLength(1);
	}

}
