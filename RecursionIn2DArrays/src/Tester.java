
public class Tester {
	
	public static void main(String[] args) {
		EraseObject grid = new EraseObject("griddata\\digital.txt");
		grid.erase(2, 5);
		System.out.println(grid);
	}

}
