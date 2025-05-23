import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V3 05/22/2025
 * 
 * Responsibilities of class:
 * - Abstract superclass for all quiz topics
 * - Defines contract for providing questions
 * - Provides reusable utility methods for file reading and question construction
 * 
 * Object-Oriented Relationships:
 * - Topic is-a superclass of all quiz categories (is-a relationship)
 * - Topic has-many Questions (generated through files)
 */
public abstract class Topic {

    /**
     * Purpose: Returns an array of questions for a specific topic.
     * 
     * This is an abstract method, meaning each subclass must define how the
     * questions are retrieved (typically using file input).
     * 
     * @return an array of Question objects relevant to the topic
     */
    public abstract Question[] getQuestions();

    /**
     * Reads all lines from a file and returns them as an array of Strings.
     * 
     * Can be reused by subclasses to read questions, answer options, or answer keys.
     * 
     * @param fileName the relative path to the file
     * @return a String array where each element is a line from the file
     */
    protected String[] readLinesFromFile(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read until end of file
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
            e.printStackTrace();
        }

        return lines.toArray(new String[0]); // Convert list to array
    }

    /**
     * Centralized method to create Question[] from three synchronized text files.
     * 
     * File expectations:
     * - One line per question in `questionsFile`
     * - One line per option group in `optionsFile` ("A, B, C, D" format)
     * - One line per correct answer in `answersFile` (e.g., "A")
     * 
     * @param questionsFile path to file containing questions
     * @param optionsFile path to file containing answer choices
     * @param answersFile path to file containing correct answer letters
     * @return an array of Question objects created from the provided files
     */
    protected Question[] loadQuestionsFromFiles(String questionsFile, String optionsFile, String answersFile) {
        String[] questionLines = readLinesFromFile(questionsFile);
        String[] optionLines = readLinesFromFile(optionsFile);
        String[] answerLines = readLinesFromFile(answersFile);

        ArrayList<Question> questions = new ArrayList<>();

        for (int i = 0; i < questionLines.length; i++) {
            String questionText = questionLines[i];

            // Split options using ", " delimiter (assumes consistent formatting)
            String[] options = optionLines[i].split(", ");

            // Trim and convert answer string to uppercase, then extract the first character
            char correctAnswer = answerLines[i].trim().toUpperCase().charAt(0);

            // Create and add the Question object
            questions.add(new Question(questionText, options, correctAnswer));
        }

        return questions.toArray(new Question[0]);
    }
}