
public class StatisticsTester {

	public static void main(String[] args) {

		Statistics tester = new Statistics(10000);
		tester.readData("numbers.txt");
		
		double avg = tester.calcAverage();
		double sd = tester.calcStdDev();

		System.out.println("Average is " + avg);
		System.out.println("Standard deviation is " + sd);
	}
}
