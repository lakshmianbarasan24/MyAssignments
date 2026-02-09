package week2.day1;

public class Palindrome {

	public static void main(String[] args) {

		// Initialization
		int input = 121;
		int output = 0;
		
		//Edge case - negative numbers
		if (input < 0) {
		    System.out.println("It is not a Palindrome");
		    return;
		}
		
		// Logic to reverse integer
		for (int i = input; i > 0; i /= 10) {
			int temp = i % 10;
			output = (output * 10) + temp;
		}

		// Print the result
		if (input == output)
			System.out.println("It is a Palindrome");
		else
			System.out.println("It is not a Palindrome");

	}

}
