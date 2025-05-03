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
 */
public class Gundam extends Topic {

    /**
     * Purpose: Returns an array of multiple-choice questions related to the Gundam franchise.
     *
     * @return an array of Question objects representing the quiz content for Gundam
     */
    @Override
    public Question[] getQuestions() {
        return new Question[] {
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