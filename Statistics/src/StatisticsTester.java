
public class StatisticsTester {

	public static void main(String[] args) {

		Statistics tester = new Statistics(10000);
		tester.readData("numbers2.txt");
		
		double avg = tester.calcAverage();
		double sd = tester.calcStdDev();
		int[] mode = tester.findMode();

		System.out.println("Average is " + avg);
		System.out.println("Standard deviation is " + sd);
		
		System.out.println("Mode is ");
		for(int i = 0; i<mode.length; i++) {
			System.out.println(mode[i] + " ");
		}
		
	}
}
