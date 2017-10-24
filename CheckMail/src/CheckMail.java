import java.util.Scanner;

public class CheckMail {

	public static void main (String[] args) {
		
		//takes in 4 numbers
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the first dimension: ");
		double dim1 = keyboard.nextDouble();
		System.out.println("Enter the second dimension: ");
		double dim2 = keyboard.nextDouble();
		System.out.println("Enter the third dimension: ");
		double dim3 = keyboard.nextDouble();
		System.out.println("Enter the weight: ");
		double weight = keyboard.nextDouble();
		
		//make package obj
		Package test = new Package(dim1, dim2, dim3, weight);
		test.checkStatus();
	}

}
