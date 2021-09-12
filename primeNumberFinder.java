/*
 * This program reads in a text file and then goes line by line looking for Prime Numbers
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class primeNumberFinder 
{
	public static void main(String[] args) 
	{
		int candidatePrimeCount = 0;
		int acceptablePrimeCount = 0;
		File inputFile = new File("IntPrimes.txt");
		inputFile.getAbsolutePath();
		try 
		{
			Scanner scanner = new Scanner(inputFile);
			while(scanner.hasNextInt())
			{
				int input = scanner.nextInt();
				candidatePrimeCount++;
				boolean isPrime = verifyPrime(input);
				
				if(isPrime == true)
				{
					acceptablePrimeCount++;
				}
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("Out of " + candidatePrimeCount + " numbers, only " + acceptablePrimeCount + " are prime numbers");
	}
	
	static boolean verifyPrime(int input)
	{
		boolean isPrime = true;
		if(input == 0 || input == 1)
		{
			isPrime = false;
		}
		else
		{
			for (int x = 2; x <= input/2; x++)
			{
				if(input % x == 0)
				{
					isPrime = false;
				}
			}
		}
		return isPrime;
	}
}
