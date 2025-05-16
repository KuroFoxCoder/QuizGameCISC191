/**
 * 
 * Lead Author(s): MArc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Provides an abstract template for quiz topic classes.
 * - Requires subclasses to implement and return a list of questions.
 * 
 * Object-Oriented Relationships:
 * - Topic is-a abstract superclass
 * - Topic is extended by specific quiz categories (Pokemon, Basketball, KOF, Gundam)
 * - Topic has-many Question[] (each subclass provides a collection of questions)
 */
public abstract class Topic {

    /**
     * Purpose: Returns an array of questions related to this topic.
     * Subclasses must implement this method to define their own questions.
     *
     * @return an array of Question objects
     */
    public abstract Question[] getQuestions();
}