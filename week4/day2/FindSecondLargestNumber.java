package week4.day2;

import java.util.ArrayList;
import java.util.List;

public class FindSecondLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>(List.of(3, 2, 11, 4, 6, 7));
		
		//Sort list
		list.sort(null);
		
		//Find the second largest element
		int result = list.get(list.size()-2);
		System.out.println(result);
		
		//Using reverse sorting
		/*list.sort(Comparator.reverseOrder());
		int result = list.get(1);
		System.out.println(result);*/
	}

}
