
public class Tester {
	
	public static void main(String[] args) {
		Life grid = new Life("griddata\\life100.txt");
		
		grid.step();
		grid.step();
		grid.step();
		grid.step();
		grid.step();
		System.out.println(grid);
	}

}
