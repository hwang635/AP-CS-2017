import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		// takes in user input
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter 1 if single, 2 if married: ");
		int marriageStatus = keyboard.nextInt();
		System.out.println("Enter your income: ");
		double income = keyboard.nextDouble();

		IRS tester = new IRS(marriageStatus, income);
		double tax = tester.calcTax();

		//prints answer in console
		System.out.println("Your tax is: $" + tax + ".");
	}
}
