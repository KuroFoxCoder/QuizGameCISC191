/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Represents the Pokémon quiz topic.
 * - Loads questions and answers from formatted text files.
 * 
 * Object-Oriented Relationships:
 * - Pokemon is-a Topic
 * - Pokemon has-many Questions
 */
public class Pokemon extends Topic {

    public Pokemon(String name) {
        super();
    }

    /**
     * Loads Pokémon topic questions from respective data files.
     * 
     * @return array of Question objects for this topic
     */
    @Override
    public Question[] getQuestions() {
        return loadQuestionsFromFiles(
            "questions/PokemonQuestions.txt",
            "questions/PokemonOptions.txt",
            "questions/PokemonAnswers.txt"
        );
    }
}