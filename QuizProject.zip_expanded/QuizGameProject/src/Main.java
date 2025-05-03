/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Serves as the program entry point.
 * - Initializes the quiz application by launching the topic selection screen.
 * 
 * Object-Oriented Relationships:
 * - Main is-a Object
 * - Main creates-a TopicScreen (which displays the GUI and handles topic selection)
 */
public class Main {

    /**
     * The main method launches the application.
     * It creates a TopicScreen GUI that allows the user to select a quiz topic.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        new TopicScreen(); // GUI will handle topic selection and start the game
    }
}