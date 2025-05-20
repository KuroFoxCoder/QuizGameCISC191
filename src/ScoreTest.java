import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test class for the Score class.
 * 
 * Purpose:
 * - To verify that the Score class correctly tracks correct answers and total attempts
 * - To ensure percentage calculations are accurate based on user performance
 * - To handle edge cases such as divide-by-zero
 * 
 * Author: Oscar Arellano , Marc Ferrer
 * Date: 05/11/2025
 */
public class ScoreTest {

    private Score score; // Each test will use a fresh instance of the Score class

    /**
     * Setup method executed before each test.
     * Ensures a clean Score object is used for test isolation.
     */
    @BeforeEach
    public void setUp() {
        score = new Score();
    }

    /**
     * Test that the initial state of the Score object is zeroed out.
     * Verifies correct and total counters are zero and percentage is 0%.
     */
    @Test
    public void testInitialValues() {
        assertEquals(0, score.getCorrect(), "Correct answers should start at 0");
        assertEquals(0, score.getTotal(), "Total questions should start at 0");
        assertEquals(0, score.calculatePercentage(), "Percentage should be 0 if no questions attempted");
    }

    /**
     * Test the increaseScore() method.
     * Verifies that both correct and total counters increment when a correct answer is recorded.
     */
    @Test
    public void testIncreaseScoreIncrementsBoth() {
        score.increaseScore(); // Simulate 1 correct answer
        assertEquals(1, score.getCorrect(), "Correct count should increase by 1");
        assertEquals(1, score.getTotal(), "Total count should also increase by 1");
    }

    /**
     * Test the incrementTotal() method.
     * Verifies that only the total counter increments when an incorrect or skipped answer is recorded.
     */
    @Test
    public void testIncrementTotalOnlyIncrementsTotal() {
        score.incrementTotal(); // Simulate 1 wrong answer or timeout
        assertEquals(0, score.getCorrect(), "Correct count should remain unchanged");
        assertEquals(1, score.getTotal(), "Total count should increase by 1");
    }

    /**
     * Test the calculatePercentage() method with a realistic 20-question quiz scenario.
     * Simulates 12 correct and 8 incorrect answers.
     */
    @Test
    public void testPercentageCalculationOutOfTwenty() {
        // Simulate 12 correct answers
        for (int i = 0; i < 12; i++) {
            score.increaseScore();
        }

        // Simulate 8 incorrect answers
        for (int i = 0; i < 8; i++) {
            score.incrementTotal();
        }

        assertEquals(12, score.getCorrect(), "Should track 12 correct answers");
        assertEquals(20, score.getTotal(), "Should track 20 total attempts");
        assertEquals(60, score.calculatePercentage(), "Expected score: 60%");
    }

    /**
     * Test calculatePercentage() for a perfect score scenario.
     * All questions are answered correctly.
     */
    @Test
    public void testPerfectScore() {
        for (int i = 0; i < 20; i++) {
            score.increaseScore(); // 20 correct, 20 total
        }
        assertEquals(100, score.calculatePercentage(), "Perfect score should return 100%");
    }

    /**
     * Test calculatePercentage() when no correct answers are given.
     * Only incorrect answers are simulated.
     */
    @Test
    public void testZeroScore() {
        for (int i = 0; i < 20; i++) {
            score.incrementTotal(); // 0 correct, 20 total
        }
        assertEquals(0, score.getCorrect(), "No correct answers should be recorded");
        assertEquals(20, score.getTotal(), "Should track 20 total attempts");
        assertEquals(0, score.calculatePercentage(), "Expected score: 0%");
    }
}