package week2.day3;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {

		String text1 = "stops";
		String text2 = "potss";
		
		//Check if the lengths of the two strings are equal
		if (text1.length() != text2.length()) {
			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
			return;
		}

		//Convert both the strings to character arrays
		char[] text1Array = text1.toCharArray();
		char[] text2Array = text2.toCharArray();

		//Sort both the character arrays
		Arrays.sort(text1Array);
		Arrays.sort(text2Array);

		Boolean isAnagram = true;

		//Check if the sorted arrays are equal
		for (int i = 0; i < text1Array.length; i++) {
			if (text1Array[i] != text2Array[i]) {
				isAnagram = false;
				break;
			}
		}

		System.out.println(
				isAnagram == true ? "The given strings are Anagram." : "The given strings are not an Anagram.");

	}

}
