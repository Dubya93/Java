/*
 * 	Author: Warren Wright
 * 	Description: This program accepts an integer and then creates the factorial of that integer. 
 */

import java.math.BigInteger;
import java.util.Scanner;

public class factorialLoopVsRecursion 
{
	public static void main(String[] args) 
	{
		System.out.print("Hello! Welcome to the factorial program. Please enter a number: ");
		Scanner scanner = new Scanner(System.in);
		BigInteger factorialInitial = scanner.nextBigInteger();
		
		long loopTimeOne = System.currentTimeMillis();
		BigInteger factorialLoop = factorial_loop(factorialInitial);
		long loopTimeTwo = System.currentTimeMillis();
		long loopTime = loopTimeTwo - loopTimeOne;
		System.out.print("\n");
		System.out.print(factorialInitial + "! = " + factorialLoop + " and the loop version took " + (loopTime) +  " milliseconds.");
		
		
		System.out.print("\n" + factorialLoop.bitCount() + "\n");
		
		long recursiveTimeOne = System.currentTimeMillis();
		BigInteger factorialRecursive = factorial_recursive(factorialInitial);
		long recursiveTimeTwo = System.currentTimeMillis();
		long recursiveTime = recursiveTimeTwo - recursiveTimeOne;
		System.out.print("\n");
		System.out.print(factorialInitial + "! = " + factorialRecursive + " and the recursive version took " + (recursiveTime) +  " milliseconds.");
		
		System.out.print("\n" + factorialRecursive.bitCount());
		
	}
	
	public static BigInteger factorial_loop(BigInteger factorialInitial)
	{
		
		BigInteger factorial = BigInteger.ONE;
		for(int x= factorialInitial.intValue(); x>0; x--)
		{
			factorial = factorial.multiply(BigInteger.valueOf(x));
			System.out.print(x + " ");
			
		}
		
		return factorial;
	}
	
	public static BigInteger factorial_recursive(BigInteger factorialInitial)
	{
		
		if(factorialInitial.equals(BigInteger.ZERO))
		{
			return BigInteger.ONE;
		}
		else
		{
			System.out.print(factorialInitial + " ");
			return (factorialInitial.multiply(factorial_recursive(factorialInitial.subtract(BigInteger.ONE))));
		}
	}
	
	
}
