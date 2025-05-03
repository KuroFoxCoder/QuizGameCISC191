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