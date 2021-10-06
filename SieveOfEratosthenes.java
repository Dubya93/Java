import java.util.Scanner;

/*
 *  This program finds prime numbers by using Eratosthenes' method
 */


public class SieveOfEratosthenes 
{
	public static void main(String[] args) 
	{
		System.out.print("Hello! Welcome to the Sieve of Eratosthenes!\n"
						+ "Please select a starting number larger than 1.\n");
		Scanner scanner = new Scanner(System.in);
		int startValue = scanner.nextInt();
		System.out.print("Please select an ending number. \n");
		int stopValue = scanner.nextInt();
		long startTime = System.currentTimeMillis();
		boolean primeNumber[] = new boolean[stopValue+1];
		int count = 0;
		
		// set all the values to true
		for(int i=startValue; i<=stopValue; i++)
		{
			primeNumber[i] = true;
		}
		
		// remove anything divisible by 2
		for(int i=startValue; i<= stopValue; i++)
		{
			if(primeNumber[i] == true)
			{
				if(i%2 == 0)
				{
					primeNumber[i] = false;
				}
				else if(i%3 == 0)
				{
					primeNumber[i] = false;
				}
				else if(i%5 == 0)
				{
					primeNumber[i] = false;
				}
				else if(i%7 == 0)
				{
					primeNumber[i] = false;
				}
			}
		}
					
		// display the prime numbers
		for(int i=startValue; i<=stopValue; i++)
		{
			if(primeNumber[i] == true)
			{
				System.out.print(i + " ");
				count++;
			}
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = ((stopTime - startTime));
		System.out.print("\nThere are " + count + " prime numbers");
		System.out.print("\nThis took " + elapsedTime + " Milliseconds");
	}
}
