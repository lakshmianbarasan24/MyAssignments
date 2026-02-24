package week4.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Approach 1 - loop 
		int[] array3 = {3, 2, 11, 4, 6, 7};
		int[] array4 = {1, 2, 8, 4, 9, 7};
		
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		
		//1.Add array elements to a list
		for(int element:array3)
		{
			list3.add(element);
		}
		for(int element:array4)
		{
			list4.add(element);
		}
		
		//2.Iterate the values through the length of the list
		for(int item3:list3) {
			for(int item4:list4) {
				//3.Print the values if they are equal
				if(item3 == item4)
					System.out.println(item3);
			}
				
		}
		
		//Approach 2 - Using retain all
		Integer[] array1 = {3, 2, 11, 4, 6, 7};
		Integer[] array2 = {1, 2, 8, 4, 9, 7};
		//Integer[] array1 = {2, 2};
		//Integer[] array2 = {2, 2};
		
		List<Integer> list1 = new ArrayList<>(Arrays.asList(array1));
		List<Integer> list2 = new ArrayList<>(Arrays.asList(array2));
		
		list1.retainAll(list2);
		
		System.out.println(list1);
		
		//Approach 3 - Using set
		Set<Integer> set= new HashSet<>(list2);
		List<Integer> list = new ArrayList<>(Arrays.asList(array1));
		
		//Remove if the element is not present in list2(set)
		list.removeIf(e->!set.contains(e));
		
		System.out.println(list);
		
		
	}

}
