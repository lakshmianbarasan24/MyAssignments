package week2.day1;

public class IsPrime {

	public static void main(String[] args) {

		int number = 3;
		boolean isPrime = true;
		
		//logic to find if number is prime or not
		for (int i = 2; i <= number - 1; i++) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}

		//print based on isPrime flag
		if (isPrime)
			System.out.println(number + " is a prime number");
		else
			System.out.println(number + " is a non-prime number");

	}

}
