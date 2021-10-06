/*
 * 	Author: Warren Wright
 * 	Description: This program accepts one parameter on the command line (the rank of the Fibonacci number to be computed) and 
 * 					produces that Fibonacci number and the number of digits in that Fibonacci Number.
 * 
 */

import java.math.BigInteger;
import java.util.Scanner;


public class bigIntegerFibonacci 
{
	public static BigInteger[] theMemo;
	public static void main(String[] args) 
	{
		System.out.print("Hello! Welcome to the Big Integer Fibonacci Program. Please enter a Big Integer Parameter: ");
		Scanner scanner = new Scanner(System.in);
		BigInteger fibonacciNumber = scanner.nextBigInteger();
		theMemo = new BigInteger[fibonacciNumber.intValue() + 1];
		
		long fibLoopTimeStart = System.currentTimeMillis();
		BigInteger fibonacciLoop = fibonacci_loop(fibonacciNumber);
		long fibLoopTimeStop = System.currentTimeMillis();
		long fibLoopTime = fibLoopTimeStop - fibLoopTimeStart;
		
		System.out.print("\n");
		System.out.print("The Fibonacci of " + fibonacciNumber + " using a looping method is " + fibonacciLoop + ". This loop took " 
							+ fibLoopTime + " milliseconds.");
		System.out.print("\n");
		
		long fibRecursiveTimeStart = System.currentTimeMillis();
		BigInteger fibonacciRecursive = fibonacci_recursive(fibonacciNumber);
		long fibRecursiveTimeStop = System.currentTimeMillis();
		long fibRecursiveTime = fibRecursiveTimeStop - fibRecursiveTimeStart;
		
		System.out.print("\n");
		System.out.print("The Fibonacci of " + fibonacciNumber + " using a recursive method is " + fibonacciRecursive + ". This recursion took "
							+ fibRecursiveTime + " milliseconds.");
		System.out.print("\n");
		
		
	}

	public static BigInteger fibonacci_loop(BigInteger fibonacciNumber)
	{
		theMemo[fibonacciNumber.intValue()] = BigInteger.ZERO;
		BigInteger fibonacci = BigInteger.ONE;
		BigInteger x = BigInteger.ONE;
		BigInteger y = BigInteger.ONE;
			if(fibonacciNumber.intValue() > 2)
			{
				if(theMemo[fibonacciNumber.intValue()].compareTo(BigInteger.ZERO) != 0)
				{
					fibonacci = theMemo[fibonacciNumber.intValue()];
				}
				else
				{
					for(int i = 3; i<=fibonacciNumber.intValue(); i++)
					{
						fibonacci = x.add(y);
						x = y;
						y = fibonacci;
						theMemo[fibonacciNumber.intValue()] = fibonacci;
					}
				}
				
			}
		return fibonacci;
	}
	
	
	public static BigInteger fibonacci_recursive(BigInteger fibonacciNumber)
	{
		BigInteger fibonacci = theMemo[fibonacciNumber.intValue()];
			if(fibonacciNumber.intValue() > 2)
			{
				if(theMemo[fibonacciNumber.intValue()].compareTo(BigInteger.ZERO) != 0)
				{
					fibonacci = theMemo[fibonacciNumber.intValue()];
				}
				else
				{
					fibonacci = (fibonacci_recursive(fibonacciNumber.subtract(BigInteger.ONE))).add(fibonacci_recursive(fibonacciNumber.subtract(BigInteger.TWO)));
					theMemo[fibonacciNumber.intValue()] = fibonacci;
				}
							
			}
		return fibonacci;
	}
	
}
