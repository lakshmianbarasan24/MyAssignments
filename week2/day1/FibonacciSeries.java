package week2.day1;
import java.util.Scanner;

public class FibonacciSeries {
	
	public static void main(String[] args) {
		
		//Reading input using Scanner
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the range:");
		int range = sc.nextInt();
		
		//Initializing variables
		int f1 = 0;
		int f2 = 1;
		
		//Print fibonacci series in the range
		for(int i = 1; i <= range; i++)
		{
			System.out.println(f1);
			
			//swap
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		
		sc.close();

	}

}
