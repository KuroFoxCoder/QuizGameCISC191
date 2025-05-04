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
 * - Represents the Pokémon topic for the quiz game.
 * - Provides a fixed list of Pokémon related multiple choice questions.
 * 
 * Object-Oriented Relationships:
 * - Pokemon is-a Topic (inherits from abstract class Topic)
 * - Pokemon has-many Question (returns an array of quiz questions)
 */
public class Pokemon extends Topic {

    /**
     * Purpose: Returns a list of multiple-choice questions themed around the Pokémon franchise.
     * These questions are shown when the Pokémon topic is selected in the quiz.
     *
     * @return an array of Question objects specific to Pokémon trivia
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
        	qScan = new Scanner(new File("PokemonQuestions.txt"));
        	oScan = new Scanner(new File("PokemonOptions.txt"));
        	aScan = new Scanner(new File("PokemonAnswers.txt"));
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
    		                "What type is Pikachu?",
    		                new String[]{"Fire", "Electric", "Water", "Psychic"},
    		                "B" // Correct: Electric
    		            ),
    		            new Question(
    		                "Who is Ash’s first Pokemon?",
    		                new String[]{"Pikachu", "Charmander", "Squirtle", "Bulbasaur"},
    		                "A" // Correct: Pikachu
    		            )
    		        };
    		}
    	}
    	return fun;
    	
    	
    }
}