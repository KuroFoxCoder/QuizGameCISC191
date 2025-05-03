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