/**
 * 
 * Lead Author(s): MArcv Ferrer , Oscar Arellano
 * 
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Tracks the user's quiz performance.
 * - Stores the number of correct answers and total attempted questions.
 * - Provides methods to update, calculate, and retrieve score-related data.
 * 
 * Object-Oriented Relationships:
 * - Score is-a Object
 * - Score has-a int (correct)
 * - Score has-a int (total)
 */
public class Score {

    // Number of correct answers given by the user
    private int correct = 0;

    // Total number of questions attempted
    private int total = 0;

    /**
     * Purpose: Increments both the correct and total counters.
     * Used when the user answers a question correctly.
     */
    public void increaseScore() {
        correct++;
        total++;
    }

    /**
     * Purpose: Increments only the total counter.
     * Used when the user answers incorrectly or times out.
     */
    public void incrementTotal() {
        total++;
    }

    /**
     * Purpose: Calculates and returns the user's final score as a percentage.
     *
     * @return score percentage (0–100)
     */
    public int calculatePercentage() {
        if (total == 0) {
            return 0; // Avoid dividing by zero when no questions were attempted
        } else {
            return (correct * 100 / total); // Calculate and return score as an integer percentage
        }
    }

    /**
     * Purpose: Outputs the final score to the console in formatted form.
     * (Primarily for testing/debugging purposes)
     */
    public void displayFinalScore() {
        System.out.println("Score: " + correct + "/" + total + " (" + calculatePercentage() + "%)");
    }

    /**
     * Getter: Returns the number of correct answers.
     *
     * @return correct answer count
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Getter: Returns the total number of questions attempted.
     *
     * @return total attempted questions
     */
    public int getTotal() {
        return total;
    }
}