/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Encapsulates a single multiple-choice question.
 * - Stores the question text, possible answer options, and the correct answer.
 * - Provides methods to retrieve question data and check the correctness of user input.
 * 
 * Object-Oriented Relationships:
 * - Question is-a Object
 * - Question has-a String (question text)
 * - Question has-many String (answer options)
 * - Question has-a String (correct answer letter)
 */
public class Question {

    // The text of the question
    private String questionText;

    // Array of answer choices (has-many String)
    private String[] options;

    // The correct answer (represented by "A", "B", "C", or "D")
    private char correctAnswer;

    /**
     * Constructor: Initializes the question text, answer options, and correct answer.
     *
     * @param questionText  the full text of the question
     * @param options       a String array containing four answer options
     * @param correctAnswer the correct answer represented by "A", "B", "C", or "D"
     */
    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns the question prompt text.
     *
     * @return the text of the question
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Returns the answer choices associated with this question.
     *
     * @return an array of Strings containing the answer options
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * Compares the user-provided answer to the correct answer.
     * The comparison is case-insensitive.
     *
     * @param userAnswer the answer selected by the user ("A", "B", "C", or "D")
     * @return true if the answer is correct, false otherwise
     */
    public boolean isCorrectAnswer(String userAnswer) {
        return !userAnswer.isEmpty() && Character.toUpperCase(userAnswer.charAt(0)) == correctAnswer;
    }
}