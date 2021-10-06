import java.math.BigInteger;
import java.util.Scanner;

public class fibonacciRecursive 
{
	public static void main(String[] args) 
	{
		
		System.out.print("Hello! Welcome to the Long Fibonacci Program. Please enter a Long Parameter: ");
		Scanner scanner = new Scanner(System.in);
		long fibonacciNumber = scanner.nextLong();
		
		long fibLoopTimeStart = System.currentTimeMillis();
		long fibonacciLoop = fibonacci_loop(fibonacciNumber);
		long fibLoopTimeStop = System.currentTimeMillis();
		long fibLoopTime = fibLoopTimeStop - fibLoopTimeStart;
		
		System.out.print("\n");
		System.out.print("The Fibonacci of " + fibonacciNumber + " using a Recursive method is " + fibonacciLoop + ". This Recursive took " 
							+ fibLoopTime + " milliseconds.");
		System.out.print("\n");
		
		long fibRecursiveTimeStart = System.currentTimeMillis();
		long fibonacciRecursive = fibonacci_Recursive(fibonacciNumber);
		long fibRecursiveTimeStop = System.currentTimeMillis();
		long fibRecursiveTime = fibRecursiveTimeStop - fibRecursiveTimeStart;
		
		System.out.print("\n");
		System.out.print("The Fibonacci of " + fibonacciNumber + " using a Recursive method is " + fibonacciRecursive + ". This Recursive took " 
							+ fibRecursiveTime + " milliseconds.");
		System.out.print("\n");
	}
	
	public static long fibonacci_loop(long fibonacciNumber)
	{
		long fibonacci = 1;
		long x = 1;
		long y = 1;
			if(fibonacciNumber > 2)
			{
				for(int i = 3; i<=fibonacciNumber; i++)
				{
					fibonacci = x + y;
					x = y;
					y = fibonacci;
				}
			}
		return fibonacci;
	}
	
	public static long fibonacci_Recursive(long fibonacciNumber)
	{
		long fibonacci = 1;
		
		if(fibonacciNumber > 2)
		{
			fibonacci = fibonacci_Recursive(fibonacciNumber - 1) + fibonacci_Recursive(fibonacciNumber - 2);
		}
		return fibonacci;
	}

}
