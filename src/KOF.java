/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 05/03/2025
 * 
 /**
 * Lead Author(s): Marc Ferrer, Oscar Arellano
 * 
 * Version/date: V2 05/22/2025
 * 
 * Responsibilities of class:
 * - Represents the King of Fighters quiz topic.
 * - Loads data from three files (questions, options, answers).
 * 
 * Object-Oriented Relationships:
 * - KOF is-a Topic
 * - KOF has-many Questions
 */
public class KOF extends Topic {

    public KOF(String name) {
        super();
    }

    /**
     * Loads KOF quiz questions using reusable file-reading logic.
     * 
     * @return array of Question objects
     */
    @Override
    public Question[] getQuestions() {
        return loadQuestionsFromFiles(
            "questions/KOFQuestions.txt",
            "questions/KOFOptions.txt",
            "questions/KOFAnswers.txt"
        );
    }
}