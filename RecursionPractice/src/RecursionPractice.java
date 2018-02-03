

public class RecursionPractice {
	
	private static int iterations = 0;

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

	public static int Fibonacci(int n) {
		iterations++;
		
		if(n == 0 || n == 1)
			return n;
		else {
			return Fibonacci(n-1) + Fibonacci(n-2);
		}
	}

	public static int FibonacciLoop(int n) {
		int num0 = 0;
		int num1 = 1;
		int numN = 0;

		if(n == 0 || n == 1)
			numN = n;
		else {
			for(int i = 1; i<n; i++) {
				numN = num0 + num1;
				num0 = num1;
				num1 = numN;
			}
		}
			
		return numN;
	}
	
	public static void printHanoiSolution(int numberofDisks) {
		printHanoiSolution(numberofDisks, 1, 3);
	}
	
	//Num Disks: 1	2	3	4	5	6	7	8	9	10
	//Iterations:1	3	7	15	31	63	127	255	511	1023
	//Equations: Iteration = 2^(numDisks) - 1
	private static void printHanoiSolution(int n, int fromPeg, int toPeg) {
		iterations++;
		
		if(n == 1)
			System.out.println("move disk " + n + " from " + fromPeg + " to " + toPeg);
		else {
			int otherPeg = 6 - (fromPeg + toPeg);
			printHanoiSolution(n - 1, fromPeg, otherPeg);
			System.out.println("move disk " + n + " from " + fromPeg + " to " + toPeg);
			printHanoiSolution(n-1, otherPeg, toPeg);
		}
		
	}
	
	public static void main(String[] args) {
		int n = 5;
		int test = triangleNumber(n);
		//System.out.println("The " + n + "th triangular number is " + test);

		/*int n = 4;
		int test = pentagonalNumber(n);
		System.out.println("The " + n + "th pentagonal number is " + test); */

		/*for(int i = 0; i<12; i++) {
			System.out.println(Fibonacci(i) + " " + ", num of iterations: " + iterations);
			iterations = 0;
		} */
		
		for(int i = 1; i<11; i++) {
			printHanoiSolution(i);
			System.out.println("Hanoi iterations " + i + " = " + iterations);
			iterations = 0;
		}
	
	}

}