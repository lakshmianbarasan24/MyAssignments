package week2.day3;

public class RemoveDuplicateWords {

	public static void main(String[] args) {

		// Initialization
		String text = "We learn Java basics as part of java sessions in java week1";
		int count = 0;

		// Split the text into an array of words using space as the delimiter
		String[] words = text.split(" ");

		// Create two nested for loops to compare each word with every other word in the
		// String array.
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				// If a duplicate word is found, it is replaced with an empty string and the
				// count is incremented.
				if (words[i].equalsIgnoreCase(words[j])) {
					count++;
					words[j] = "";
				}
			}
		}

		// if the count is greater than 1, it prints the modified words array.
		if (count > 0) {
			for (int i = 0; i < words.length; i++) {
				if (words[i] != "")
					System.out.print(words[i] + " ");
			}
		}

	}

}
