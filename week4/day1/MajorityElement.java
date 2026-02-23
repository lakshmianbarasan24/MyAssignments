package week4.day1;

import java.util.Arrays;

public class MajorityElement {
	/*
	 * Given an array nums of size n, return the majority element.
	 * 
	 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
	 * may assume that the majority element always exists in the array.
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,2,3] Output: 3 Example 2:
	 * 
	 * Input: nums = [2,2,1,1,1,2,2] Output: 2
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        //Using sorting - Time complexity O(NlogN)
        int[] nums = {2,2,3,1,1,2,2};
        Arrays.sort(nums);
        System.out.println(nums[nums.length/2]);
        
        //Using Pattern based algorithm - Time complexity O(N)
		/*
		 * Majority element appears more than n/2
		 * It can never be fully cancelled out
		 * Other elements cancel each other
		 */
        int[] nums1 = {3,2,3};
        int ans = 0;
        int count = 0;
        for(int num: nums1)
        {
        	if(count == 0)
        		ans = num;
        	count += (num == ans)?1:-1;
        }
        System.out.println(ans);
	}

}
