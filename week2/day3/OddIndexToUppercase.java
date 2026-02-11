package week2.day3;

public class OddIndexToUppercase {

	public static void main(String[] args) {

		String test = "changeme";

		// Convert the given String to a character array.
		char[] testArray = test.toCharArray();

		// Implement a loop to iterate through each character of the String
		for (int i = 0; i < testArray.length; i++) {
			if (i % 2 == 1)
				System.out.print(Character.toUpperCase(testArray[i]));
			else
				System.out.print(testArray[i]);
		}

	}

}
