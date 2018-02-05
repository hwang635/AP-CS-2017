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
		if(in.length() <= 1)
			return true;
		else {
			String inNew;
			if(!(Character.isLetter(in.charAt(0)) || Character.isDigit(in.charAt(0)) ))
				 inNew = in.substring(1);
				
			boolean isPalindrome = (in.charAt(0) == in.charAt(in.length() - 1));
				inNew = in.substring(1, in.length()-1);
			
			return isPalindrome && isPalindrome(inNew);
		}
	}


	public static String removePunctuation() {
		return "";
	}

	// Exercise #3
	public static void printPermutations(String in) {

	}



	public static String piglatinate(String in) {
		return "";
	}



	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please enter a string:");
		String s1 = kboard.nextLine();
		//System.out.println("Please enter a string:");
		//String s2 = kboard.nextLine();

		boolean out = RecursiveStringTools.isPalindrome(s1);
		System.out.print("\n\nThe result is --> " + out + "\n\n");
		
		
	}
}
