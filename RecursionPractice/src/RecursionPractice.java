

public class RecursionPractice {

	public static int triangleNumber(int n)
	{
		if (n == 1)
			return 1;
		else
			return n + triangleNumber(n-1);
	}

	public static int squareNumber(int n) {
		if(n == 1) 
			return 1;
		else {
			return squareNumber(n-1) + 2*n -1;
		}
	}


	public static int logBase2(int n) {
		if(n == 1) 
			return 0;
		else {
			return 1 + logBase2(n/2);
		}
	}


	public static int pow(int n) {
		if(n == 0) 
			return 1;
		else {
			return 2*pow(n-1);
		}
	}

	public static int pentagonalNumber(int n) {
		if(n == 1)
			return 1;
		else {
			return n*2 + n-2 + pentagonalNumber(n-1);
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int test = triangleNumber(n);
		System.out.println("The " + n + "th triangular number is " + test);
		
		/*int n = 4;
		int test = pentagonalNumber(n);
		System.out.println("The " + n + "th pentagonal number is " + test); */
	}

}