import java.util.Scanner;
import java.util.Random;
/** Program header:  WarrenWright_magic8ball.java
 *
 * Author:    Warren Wright
 * Class:     Advanced Java
 *
 * Brief Program Description:
 *   This is the program that replicates a magic 8 ball. The user asks it a question and the magic 8 ball randomly generates
 *   an answer. At the end the magic 8 ball will tell you how questions it has answered.
 */
public class magic8ball
{
	public static void main(String[] args)
	{
		// variables
		Scanner userInput = new Scanner(System.in);
		Random random = new Random();
		int x = 0;
		String question;
		String [] possibleAnswer = {"Ask again later", "Yes", "No", "That is in the cards", "Most definitely not", "100%, for sure",
						"What do you think this is? a therapy session?", "How could you ask such a thing?!", "..."};
		// Program Start
		System.out.print("Hello, this is the magic 8 ball! \n");
		// Looping function to keep asking questions until nothing is asked.
		do
		{
			System.out.print("Ask a question. \n");
			question = userInput.nextLine();
			// check to see if question is empty or not
			if (question != "")
			{
				// check to see if it was actually a question or not
				if (question.contains("?"))
				{
					int pickAnswer = random.nextInt(possibleAnswer.length);
					System.out.print(possibleAnswer[pickAnswer] + "\n");
					x++;
				}
				else
				{
					System.out.print("That was not a question... \n");
				}
			}
		} while(question != "");
		System.out.print("The magic 8 ball answered " + x + " questions");
	}
}