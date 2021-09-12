/*
 *  This program reads two text files each containing a list of numbers then sorts the numbers into arrays
 *  then merges the two arrays into one array and then dumps them in another text file
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class mergeAndSort 
{
	public static void main(String[] args) throws IOException
	{
		// Welcome and ask for the first file name
		System.out.print("Hello! Welcome to Merge and Sort. \n"
						+ "Please input the file name of the first file to be sorted and merged \n");
		Scanner scanner = new Scanner(System.in);
		String fileOnePath = scanner.nextLine();
		
		
		// Open File and add the integers to an array
		File fileOne = new File(fileOnePath);
		Scanner scanFileOne = new Scanner(fileOne);
		int sizeOne = scanFileOne.nextInt();
		int[] fileOneArray = new int[sizeOne];
		int i = 0;
		System.out.print("Reading.... \n");
		System.out.print("The index is: " + sizeOne + "\n");
		while(scanFileOne.hasNextInt())
		{
			fileOneArray[i] = scanFileOne.nextInt();
			i++;
		}
		// sort the integers of file one
		int[] sortedFileOneArray = sortArrayOne(fileOneArray);
		scanFileOne.close();
		
		
		// Ask for the second file name
		System.out.print("\nPlease input the file name of the second file to be sorted and merged \n");
		String fileTwoPath = scanner.nextLine();
		
		// Open File and add the integers to an array
		File fileTwo = new File(fileTwoPath);
		Scanner scanFileTwo = new Scanner(fileTwo);
		int sizeTwo = scanFileTwo.nextInt();
		int[] fileTwoArray = new int[sizeTwo];
		int j = 0;
		System.out.print("Reading.... \n");
		System.out.print("The index is: " + sizeTwo + "\n");
		while(scanFileTwo.hasNextInt())
		{
			fileTwoArray[j] = scanFileTwo.nextInt();
			j++;
		}
		scanFileTwo.close();
		int[] sortedFileTwoArray = sortArrayTwo(fileTwoArray);
		// merge the two sorted files
		int[] mergedArray = mergeArrays(sortedFileOneArray, sortedFileTwoArray, sizeOne, sizeTwo);
		
		//create the new file containing the merged array
		System.out.print("Name the new file \n");
		String newFileName = scanner.nextLine() + ".txt";
		File newFile = new File(newFileName);
		FileWriter newFileWriter = new FileWriter(newFileName);
		newFileWriter.write(Arrays.toString(mergedArray));
		newFileWriter.close();
		System.out.print("File " + newFileName + " created.");
		
	}
	
	public static int[] sortArrayOne(int[] fileOneArray)
	{
		int temp = 0;
		for(int x=0; x<fileOneArray.length; x++)
		{
			for(int y=x+1; y<fileOneArray.length; y++)
			{
				if(fileOneArray[x] > fileOneArray[y])
				{
					temp = fileOneArray[x];
					fileOneArray[x] = fileOneArray[y];
					fileOneArray[y] = temp;
				}
			}
		}
		return fileOneArray;
	}

	public static int[] sortArrayTwo(int[] fileTwoArray)
	{
		int temp = 0;
		for(int x=0; x<fileTwoArray.length; x++)
		{
			for(int y=x+1; y<fileTwoArray.length; y++)
			{
				if(fileTwoArray[x] > fileTwoArray[y])
				{
					temp = fileTwoArray[x];
					fileTwoArray[x] = fileTwoArray[y];
					fileTwoArray[y] = temp;
				}
			}
		}
		return fileTwoArray;
	}
	
	public static int[] mergeArrays(int[] sortedFileOneArray, int[] sortedFileTwoArray, int sizeOne, int sizeTwo)
	{
		int size = sizeOne + sizeTwo;
		int[] mergedArray = new int[size];
		int z = 0;
		for(int x=0; x<sortedFileOneArray.length; x++)
		{
			if(sortedFileOneArray[x] < sortedFileTwoArray[x])
			{
				mergedArray[z] = sortedFileOneArray[x];
				z++;
			}
			else
			{
				mergedArray[z] = sortedFileTwoArray[x];
				z++;
			}
		}
		for(int x=0; x<sortedFileTwoArray.length; x++)
		{
			if(sortedFileTwoArray[x] > sortedFileOneArray[x])
			{
				mergedArray[z] = sortedFileTwoArray[x];
				z++;
			}
			else
			{
				mergedArray[z] = sortedFileOneArray[x];
				z++;
			}
		}
		return mergedArray;
	}
}