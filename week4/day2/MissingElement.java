package week4.day2;

import java.util.ArrayList;
import java.util.List;

public class MissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 10, 6, 8));

		// Sort in ascending order
		list.sort(null);

		// loop the elements
		for (int i = 0; i < list.size() - 1; i++) {
			// check the current element + 1 is not equal to the next element.
			// This comparison checks if there is a gap in the sequence of numbers
			if (list.get(i) + 1 != list.get(i + 1))
				System.out.println(list.get(i) + 1);
		}
	}

}
