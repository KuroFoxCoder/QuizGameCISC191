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
 * - Represents the King of Fighters (KOF) topic in the quiz.
 * - Supplies a set of pre-defined multiple-choice questions specific to KOF.
 * 
 * Object-Oriented Relationships:
 * - KOF is-a Topic (inherits from abstract class Topic)
 * - KOF has-many Question (provides a fixed array of quiz questions)
 */
public class KOF extends Topic {

    /**
     * Purpose: Returns an array of KOF-related multiple-choice questions.
     * These are predefined and relate to characters and teams from the franchise.
     *
     * @return an array of Question objects representing KOF quiz content
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
        	qScan = new Scanner(new File("KofQuestions.txt"));
        	oScan = new Scanner(new File("KofOptions.txt"));
        	aScan = new Scanner(new File("KofAnswers.txt"));
        	for(int i=0;i<maxQuestions;i++)
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
    		                "Who is the main protagonist of The King of Fighters '94?",
    		                new String[]{"Iori Yagami", "Rugal Bernstein", "Kyo Kusanagi", "Terry Bogard"},
    		                "C" // Correct: Kyo Kusanagi
    		            ),
    		            new Question(
    		                "Which team does Terry Bogard belong to?",
    		                new String[]{"Fatal Fury Team", "Japan Team", "Art of Fighting Team", "Hero Team"},
    		                "A" // Correct: Fatal Fury Team
    		            )
    		        };
    		}
    	}
    	return fun;
        
    }
}