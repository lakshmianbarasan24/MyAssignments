package week5.day2;

import java.util.HashSet;
import java.util.Set;

public class Jewels {
	/*
	 * You're given strings jewels representing the types of stones that are jewels,
	 * and stones representing the stones you have. Each character in stones is a
	 * type of stone you have. You want to know how many of the stones you have are
	 * also jewels.
	 * 
	 * Letters are case sensitive, so "a" is considered a different type of stone
	 * from "A".
	 * 
	 * Example 1:
	 * 
	 * Input: jewels = "aA", stones = "aAAbbbb" Output: 3
	 * 
	 * Example 2:
	 * 
	 * Input: jewels = "z", stones = "ZZ" Output: 0
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Approach 1 : Using set
		String jewels = "z";
		String stones = "ZZ";
		int output = 0;

		Set<Character> jewel = new HashSet<>();
		for (int i = 0; i < jewels.length(); i++)
			jewel.add(jewels.charAt(i));

		for (int i = 0; i < stones.length(); i++) {
			char stone = stones.charAt(i);
			if (jewel.contains(stone))
				output++;

		}
		System.out.println(output);
		
		//Approach 2 : Using indexOf method - Not efficient
		int count = 0;
		for (char c : stones.toCharArray()) {
		    if (jewels.indexOf(c) != -1) {
		        count++;
		    }
		}
		System.out.println(count);
	}

}
