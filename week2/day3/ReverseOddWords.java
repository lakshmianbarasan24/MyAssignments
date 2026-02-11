package week2.day3;

public class ReverseOddWords {

	public static void main(String[] args) {

		String test = "I am a software tester";

		// Split the words and have it in an array
		String[] words = test.split(" ");

		// Traverse through each word using loop
		for (int i = 0; i < words.length; i++) {

			// Find the odd index within the loop
			if (i % 2 == 1) {

				// Convert the String array into a character array
				char[] oddWordArray = words[i].toCharArray();
				StringBuilder reversedOddWord = new StringBuilder();

				// Print the even position words using another loop
				for (int j = oddWordArray.length - 1; j >= 0; j--) {
					reversedOddWord.append(oddWordArray[j]);
				}

				System.out.print(reversedOddWord.toString() + " ");
			} else {
				System.out.print(words[i] + " ");
			}

		}

	}

}
