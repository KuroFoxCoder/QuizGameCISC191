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