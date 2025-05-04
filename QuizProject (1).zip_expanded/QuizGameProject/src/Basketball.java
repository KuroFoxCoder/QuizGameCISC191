import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Represents the Basketball topic for the quiz game.
 * - Provides a predefined list of basketball-related questions and answers.
 * 
 * Object-Oriented Relationships:
 * - Basketball is-a Topic (inherits from abstract class Topic)
 * - Basketball has-many Question (returns a hardcoded array of questions)
 */
public class Basketball extends Topic {

    /**
     * Purpose: Returns a fixed set of multiple-choice questions about basketball.
     * These questions are displayed in the quiz when the Basketball topic is selected.
     *
     * @return an array of basketball-related Question objects
     */
    @Override
    public Question[] getQuestions() {
    	int maxQuestions = 8; //Amount of questions for the quiz
    	int maxAnswers = 4; //There are 4 options for each question
    	Scanner qScan = null; //Initialize Scanners to make compiler happy
    	Scanner oScan = null;
    	Scanner aScan = null;
    	String[] qArray = new String[maxQuestions]; //Initialize question and correct answer String arrays, as well as initialize a Question array to put it all together
    	String[] aArray = new String[maxQuestions];
    	Question[] fun = new Question[maxQuestions];
        try
        {
        	qScan = new Scanner(new File("BasketballQuestions.txt")); //Open respective text files for questions, options, and answers
        	oScan = new Scanner(new File("BasketballOptions.txt"));
        	aScan = new Scanner(new File("BasketballAnswers.txt"));
        	for(int i=0;i<maxQuestions;i++) //Use a for loop to add questions and correct answers to respective arrays.
        	{
        		String[] tempArray = new String[maxAnswers]; //Establish a temporary array within the loop, initialized to 4 elements
        		String temp; //A temp String variable for use to make tempArray
        		qArray[i] = qScan.nextLine().toString(); //Add question text to question String array
        		temp = oScan.nextLine().toString(); //Assign a single string line to the temp String
        		aArray[i] = aScan.nextLine().toString(); //Add correct answers to correct answer String array
        		tempArray = temp.split(", "); //Make a String array surrounding instances of ", " a comma and space after, to make an array of a question's options
        		fun[i] = new Question(qArray[i],tempArray,aArray[i]); //Put the question, options, and correct answer together into a single Question class object
     
        	}
        }
        catch(FileNotFoundException e) //If a file is not found, print an error message
        {
        	System.out.println("Files not found. Returning default questions.");
        }
    	finally
    	{
    		if(qScan != null && oScan != null && aScan != null) //If Scanners were opened successfully, close them all.
    		{
    			qScan.close();
    			oScan.close();
    			aScan.close();
    		}
    		else //If one of the scanners didn't open correctly, return an array of 2 questions.
    		{
    			return new Question[] {
    		            new Question(
    		                "Which team won the NBA Championship in 2020?",
    		                new String[]{"Miami Heat", "Los Angeles Lakers", "Boston Celtics", "Toronto Raptors"},
    		                "B" // Correct: Los Angeles Lakers
    		            ),
    		            new Question(
    		                "Who is known as 'The King' in the NBA?",
    		                new String[]{"Michael Jordan", "Kevin Durant", "LeBron James", "Stephen Curry"},
    		                "C" // Correct: LeBron James
    		            )
    		        };
    		}
    	}
    	return fun;
        
    }
}