import java.util.Scanner;


public class RecursiveStringTools {

	// Example
	public static int length(String in) {
		if(in.equals("")) 
			return 0;
		else {
			return 1 + length(in.substring(1));
		}
	}

	// Example
	public static boolean equals(String in1, String in2) {
		if(in1.length() != in2.length())
			return false;
		else if (in1.length() == 0 && in2.length() == 0) { //if they are the same length + length = 0
			return true;
		}
		else {
			boolean equals = (in1.charAt(0) == in2.charAt(0));
			String in1New = in1.substring(1);
			String in2New = in2.substring(1);
			return equals && equals(in1New, in2New);
		}
	}

	// Exercise #1
	public static boolean matches(String in1, String in2) {
		if(in1.length() != in2.length())
			return false;
		else if(in1.length() == 0 && in2.length() == 0)
			return true;
		else {
			boolean matches = (in1.charAt(0) == in2.charAt(0)) || (in1.charAt(0) == '?') || (in2.charAt(0) == '?');
			String in1New = in1.substring(1);
			String in2New = in2.substring(1);

			return matches && matches(in1New, in2New);
		}
	}

	// Exercise #2
	public static boolean isPalindrome(String in) {
		in = in.replace(" ",  "");
		in = in.replaceAll("[^a-zA-Z]", "");
		in = in.toLowerCase();

		if(in.length() <= 1)
			return true;
		else {
			boolean isPalindrome = (in.charAt(0) == in.charAt(in.length() - 1));
			String inNew = in.substring(1, in.length()-1);

			return isPalindrome && isPalindrome(inNew);
		}
	}

	// Exercise #3
	// java / j ava / a jva / v jaa
	public static void printPermutations(String in) {
		printPermutations("", in);
		//if 1 char
		//print the 1 char (w/ all removed chars at beginning)
		//else, for each character inside in
		//remove this char
		//print all permutations of remaining char w/ removed chars @begin
		System.out.println();
	}
	
	
	private static void printPermutations(String removedChar, String in)
	{
		int n = in.length();
		if(n==0) {
			System.out.print(removedChar + " ");
		} else {
			loop(removedChar, in, 0);
		}
	}
	private static void loop(String removedChar, String in, int i)
	{
		int n = in.length();
		if(n==0) {
			return;
		} else {
			String removedChar1 = removedChar + in.charAt(i);
			String in1 = in.substring(0, i) + in.substring(i+1);
			printPermutations(removedChar1, in1);
			if(++i<n)
				loop(removedChar, in, i);
		}
	}

	//w/ loop
	/* private static void printPermutations(String in, String removedChar) {
		int n = in.length();
		if(n==0)
			System.out.println(removedChar);
		else {			
			for(int i = 0; i<n; i++) {
				printPermutations(in.substring(0, i) + in.substring(i+1), removedChar + in.charAt(i));
			}
		}
	} */

	public static String piglatinate(String in) {
		return "";
	}


	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String s1 = kboard.nextLine();
		//System.out.println("Please enter a string:");
		//String s2 = kboard.nextLine();

		//boolean out = RecursiveStringTools.isPalindrome(s1);
		//System.out.print("\n\nThe result is --> " + out + "\n\n");
		
		printPermutations(s1);


	}
}
