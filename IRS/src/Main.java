import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		// takes in user input
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter 1 if single, 2 if married: ");
		int marriageStatus = keyboard.nextInt();
		System.out.println("Enter your income: ");
		int income = keyboard.nextInt();

		IRS tester = new IRS();
		double tax = tester.calcTax(marriageStatus, income);

		//prints answer in console
		System.out.println("Your tax is: $" + tax + ".");
	}
}
