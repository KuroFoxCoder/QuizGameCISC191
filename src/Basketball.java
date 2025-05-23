/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Represents the Basketball topic.
 * - Loads quiz questions from standardized file inputs.
 * 
 * Object-Oriented Relationships:
 * - Basketball is-a Topic
 * - Basketball has-many Questions
 */
public class Basketball extends Topic {

    public Basketball(String name) {
        super();
    }

    /**
     * Retrieves questions from Basketball-specific text files.
     * Reuses the generic loadQuestionsFromFiles() method from Topic.
     * 
     * @return array of Question objects for Basketball
     */
    @Override
    public Question[] getQuestions() {
        return loadQuestionsFromFiles(
            "questions/BasketballQuestions.txt",
            "questions/BasketballOptions.txt",
            "questions/BasketballAnswers.txt"
        );
    }
}