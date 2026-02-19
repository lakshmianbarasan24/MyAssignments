package week3.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 
Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

*/
public class FindSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Approach 1: Using sort - 
		 * Avg Time complexity - O(nlogn) 
		 * Space complexity - O(1) [constant]
		 */
		int[] nums = new int[] { 2, 2, 1 };
		// int[] nums = new int[] {4,1,2,1,2};

		Arrays.sort(nums); // Avg Time complexity for sort - O(nlogn)

		// Initialize with last element
		int result = nums[nums.length - 1];

		// loop the elements by incrementing by 2
		for (int i = 0; i < nums.length - 1; i += 2) {
			// compare with consecutive element
			if (nums[i] != nums[i + 1]) {
				result = nums[i];
				break;
			}
		}
		System.out.println(result);

		/*
		 * Approach 2: Using set 
		 * Avg Time complexity - O(n)[linear] 
		 * Space complexity - O(n)[linear]
		 */
		
		Integer[] nums2 = new Integer[] { 4, 1, 2, 1, 2 };

		// Store the array elements in set[stores unique element]
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(nums2));

		long expectedSum = 0;
		for (Integer element : set)
			expectedSum += element + element;

		long actualSum = 0;
		for (Integer num : nums2)
			actualSum += num;

		System.out.println(expectedSum - actualSum);
		
		/*
		 * Approach3 - Using XOR 
		 * Time complexity - O(n)[linear]
		 * Space complexity - O(1)[Constant]
		 */
		
		int[] nums3 = new int[] { 1 };

		int xorResult = 0;
		
		for (int num : nums3) {
			xorResult ^= num;
		}

		System.out.println(xorResult);

	}

}
