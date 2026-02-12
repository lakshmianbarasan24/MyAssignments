package week2.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Approach1: Using Enhanced For Loops");
		// Array declaration
		int array1[] = { 3, 2, 11, 4, 6, 7 };
		int array2[] = { 1, 2, 8, 4, 9, 7 };

		for (int array1Element : array1) {
			for (int array2Element : array2) {
				// Print array1 element if matched
				if (array1Element == array2Element)
					System.out.println(array2Element);

			}
		}
		
		System.out.println("Approach2: Using Sets");
		
		Integer array3[] = { 3, 2, 11, 4, 6, 7 };
		Integer array4[] = { 1, 2, 8, 4, 9, 7 };
		
		//Create set using array input
		Set<Integer> set1 = new HashSet<>(Arrays.asList(array3));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(array4));
		
		//To find the intersection
		set1.retainAll(set2);
		
		for(Integer element:set1)
			System.out.println(element);

	}

}
