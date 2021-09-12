/* 
 * This program reads in a text file and then goes line by line checking for acceptable passwords.
 * Acceptable password requirements are as follows:
 * 		12 character minimum
 * 		No Spaces
 * 		At least 1 Upper-Case Letter = 'A - Z'
 * 		At Least 1 Lower-Case Letter = 'a - z'
 * 		At Least 1 Digit = '0 - 9'
 * 		At Least 1 Special Character = '~`!@#$%^&*()-_=+\\\\|[{]};:'\\\",<.>/?'
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class passwordChecker 
{
	public static void main(String[] args) 
	{
		int candidatePasswordCount = 0;
		int acceptablePasswordCount = 0;
		File inputFile = new File("Candidate Passwords.txt");
		inputFile.getAbsolutePath();
		try 
		{
			Scanner scanner = new Scanner(inputFile);
			while(scanner.hasNextLine())
			{
				String input = scanner.nextLine();
				candidatePasswordCount++;
				boolean lengthReq = verifyLength(input);
				boolean noSpaces = verifySpaces(input);
				boolean upperCaseReq = verifyUpperCase(input);
				boolean lowerCaseReq = verifyLowerCase(input);
				boolean digitReq = verifyDigit(input);
				boolean specialReq = verifySpecial(input);
				
				if(lengthReq == true && noSpaces == true && upperCaseReq == true && lowerCaseReq == true && digitReq == true && specialReq == true)
				{
					acceptablePasswordCount++;
				}
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("Out of " + candidatePasswordCount + " passwords only " + acceptablePasswordCount + " passwords"
							+ " met the requirements");
	}
	
	static boolean verifyLength(String input)
	{
		boolean acceptableLength = false;
		int length = input.length();
		
		if(length >= 12)
		{
			acceptableLength = true;
		}
		return acceptableLength;
	}
	
	static boolean verifySpaces(String input)
	{
		boolean noSpaces = true;
		char currentSpaceCharacter;
		for(int x = 0; x < input.length(); x++)
		{
			currentSpaceCharacter = input.charAt(x);
			if(Character.isWhitespace(currentSpaceCharacter))
			{
				noSpaces = false;
			}
		}
		return noSpaces;
	}
	
	static boolean verifyUpperCase(String input)
	{
		boolean containsUpperCase = false;
		char currentUpperCharacter;
		for(int x = 0; x < input.length(); x++)
		{
			currentUpperCharacter = input.charAt(x);
			if(Character.isUpperCase(currentUpperCharacter))
			{
				containsUpperCase = true;
			}
		}
		return containsUpperCase;
	}
	
	static boolean verifyLowerCase(String input)
	{
		boolean containsLowerCase = false;
		char currentLowerCharacter;
		for(int x = 0; x < input.length(); x++)
		{
			currentLowerCharacter = input.charAt(x);
			if(Character.isLowerCase(currentLowerCharacter))
			{
				containsLowerCase = true;
			}
		}
		return containsLowerCase;
	}
	
	static boolean verifyDigit(String input)
	{
		boolean containsDigit = false;
		char currentDigitCharacter;
		for(int x = 0; x < input.length(); x++)
		{
			currentDigitCharacter = input.charAt(x);
			if(Character.isDigit(currentDigitCharacter))
			{
				containsDigit = true;
			}
		}
		return containsDigit;
	}
	
	static boolean verifySpecial(String input)
	{
		boolean containsSpecial = false;
		String specialChars = "~`!@#$%^&*()-_=+\\\\|[{]};:'\\\",<.>/?";
		char currentSpecialCharacter;
		for(int x = 0; x < input.length(); x++)
		{
			currentSpecialCharacter = input.charAt(x);
			if(specialChars.contains(String.valueOf(currentSpecialCharacter)))
			{
				containsSpecial = true;
			}
		}
		return containsSpecial;
	}
}

