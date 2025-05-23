/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Represents the Gundam topic in the quiz game.
 * - Loads question data from three synchronized files.
 * 
 * Object-Oriented Relationships:
 * - Gundam is-a Topic (inherits from Topic)
 * - Gundam has-many Questions (loaded from files)
 */
public class Gundam extends Topic {

    /**
     * Constructs a new Gundam topic with the given name.
     * 
     * @param name the display name of the topic
     */
    public Gundam(String name) {
        super();
    }

    /**
     * Loads Gundam-related quiz questions from the designated text files.
     * Uses the inherited loadQuestionsFromFiles() method from Topic.
     * 
     * @return an array of Question objects for this topic
     */
    @Override
    public Question[] getQuestions() {
        return loadQuestionsFromFiles(
            "questions/GundamQuestions.txt",
            "questions/GundamOptions.txt",
            "questions/GundamAnswers.txt"
        );
    }
}