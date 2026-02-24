package week4.day2;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Using ASCII logic
		String s1 = "TestLeaf";
		// String s = "loveTestLeaf";
		int[] freq = new int[256];
		int result1 = -1;
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			freq[c]++;
		}

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (freq[c] == 1) {
				result1 = i;
				break;
			}
		}
		System.out.println(result1);

		// Using HashMap
		String s = "aabb";
		int result = -1;
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) == 1) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}

}
