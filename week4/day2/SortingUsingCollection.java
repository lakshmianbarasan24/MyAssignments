package week4.day2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] companies = new String[] {"HCL", "Wipro", "Aspire Systems", "CTS"};
		List<String> list = new ArrayList<>(List.of(companies));
		
		//Arrange the collection in ascending order
		list.sort(null);
		
		//Use reverse loop to iterate the collection
		for(int i=list.size()-1;i>=0;i--)
			System.out.println(list.get(i));
		
		//Direct reverse sorting
		list.sort(Comparator.reverseOrder());
		System.out.println(list);
		
	}

}
