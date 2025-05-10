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
 * - Defines a concrete implementation of the Topic class for the Gundam quiz category.
 * - Supplies a fixed list of Gundam-related multiple-choice questions.
 * 
 * Object-Oriented Relationships:
 * - Gundam is-a Topic (inherits from abstract Topic)
 * - Gundam has-many Question (returns an array of Question objects)
 * 
 * References:
 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#split-java.lang.String-
 * https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 * 
 */
public class Gundam extends Topic {

    /**
     * Purpose: Returns an array of multiple-choice questions related to the Gundam franchise.
     *
     * @return an array of Question objects representing the quiz content for Gundam
     */
    @Override
    public Question[] getQuestions()
    {
    	int maxQuestions = 20; //Amount of questions for the quiz
    	int maxAnswers = 4; //There are 4 options for each question
    	Scanner questionScanner = null; //Initialize Scanners to make compiler happy
    	Scanner optionScanner = null;
    	Scanner answerScanner = null;
    	String[] questionArray = new String[maxQuestions]; //Initialize question and correct answer String arrays, as well as initialize a Question array to put it all together
    	String[] answerArray = new String[maxQuestions];
    	Question[] fun = new Question[maxQuestions];
        try
        {
        	questionScanner = new Scanner(new File("GundamQuestions.txt"));
        	optionScanner = new Scanner(new File("GundamOptions.txt"));
        	answerScanner = new Scanner(new File("GundamAnswers.txt"));
        	for(int i=0;i<maxQuestions;i++)
        	{
        		String[] tempArray = new String[maxAnswers]; //Establish a temporary array within the loop, initialized to 4 elements
        		String temp; //A temp String variable for use to make tempArray
        		questionArray[i] = questionScanner.nextLine().toString(); //Add question text to question String array
        		temp = optionScanner.nextLine().toString(); //Assign a single string line to the temp String
        		answerArray[i] = answerScanner.nextLine().toString(); //Add correct answers to correct answer String array
        		tempArray = temp.split(", "); //Make a String array surrounding instances of ", " a comma and space after, to make an array of a question's options
        		fun[i] = new Question(questionArray[i],tempArray,answerArray[i]); //Put the question, options, and correct answer together into a single Question class object
     
        	}
        }
        catch(FileNotFoundException e) //If a file is not found, print an error message
        {
        	System.out.println("Files not found. Returning default questions.");
        }
    	finally
    	{
    		if(questionScanner != null)//If Scanners were opened successfully, close them all.
    		{
    			questionScanner.close();
    		}
    		if(optionScanner != null)
    		{
    			optionScanner.close();
    		}
    		if(answerScanner != null)
    		{
    			answerScanner.close();
    		}
    		else //If one of the scanners didn't open correctly, return an array of 2 questions.
    		{
    			return new Question[] 
                		{
                    new Question(
                        "What is the name of the original Gundam pilot?",
                        new String[]{"Setsuna F. Seiei", "Heero Yuy", "Amuro Ray", "Banagher Links"},
                        "C" // Correct: Amuro Ray
                    ),
                    new Question(
                        "What organization is the main antagonist in 'Mobile Suit Gundam Wing'?",
                        new String[]{"ZAFT", "Titans", "OZ", "Celestial Being"},
                        "C" // Correct: OZ
                    )
                		};
    		}
    	}
    	return fun;
    	
    	
    }
}