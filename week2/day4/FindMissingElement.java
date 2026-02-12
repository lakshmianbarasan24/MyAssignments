package week2.day4;

import java.util.Arrays;

public class FindMissingElement {
	public static void main(String[] args) {
		
		System.out.println("Approach1: Using sorting & loops");
		
		int[] numbers = { 1, 4, 3, 2, 8, 6, 7 };
		
		//Sort elements
		Arrays.sort(numbers);
		
		//Find missing element by checking the array values with the index value
		for (int i = numbers[0]; i < numbers.length; i++) {
			if (numbers[i-1] != i) {
				System.out.println(i);
				break;
			}
		}
		
		System.out.println("Approach1: Using sum");
		
		//Maximum is length + 1
		int max = numbers.length+1;
		
		//Sum of natural n numbers
		long expectedSum = (max*(max+1))/2;
		
		long actualSum = 0;
		
		//Sum of array elements
		for(int num: numbers)
			actualSum+=num;
		
		int missingNum = (int) (expectedSum - actualSum);
		
		System.out.println(missingNum);
	}

}
