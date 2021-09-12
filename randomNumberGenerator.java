/*
 * this program generates a file with random numbers between 0 - 100 and then put them in a txt file
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class randomNumberGenerator 
{
	public static void main(String[] args) throws IOException 
	{
		System.out.print("Name the new file \n");
		Scanner scanner = new Scanner(System.in);
		String newFileName = scanner.nextLine() + ".txt";
		File newFile = new File(newFileName);
		FileWriter newFileWriter = new FileWriter(newFileName);
		
		int size = 500000;
		int index = size + 1;
		
		Random random = new Random();
		newFileWriter.write(index + "\n");     // this will generate 500,000 random numbers. change 500,000 if you want more or less
		for(int i=0; i<=size; i++)
		{
			int x = random.nextInt(100);
			newFileWriter.write(x + " ");
		}
		newFileWriter.close();
		System.out.print("File " + newFileName + " created.");
		
	}

}
