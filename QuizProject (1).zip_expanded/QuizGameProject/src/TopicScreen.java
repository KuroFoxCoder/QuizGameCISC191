import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 05/03/2025
 * 
 * Responsibilities of class:
 * - Displays a graphical menu for the user to select a quiz topic.
 * - Instantiates the corresponding Topic subclass and launches a new QuizGame.
 * - Provides the initial screen to begin the quiz experience.
 * 
 * Object-Oriented Relationships:
 * - TopicScreen is-a Object
 * - TopicScreen has-a JFrame
 * - TopicScreen has-many JButton (topic selection buttons)
 * - TopicScreen creates-a QuizGame (on button press)
 */
public class TopicScreen {

    /**
     * Constructor: Builds the topic selection window and initializes event handling.
     */
    public TopicScreen() {
        // Create the main window
        JFrame frame = new JFrame("Choose Your Topic");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10)); // 4 buttons, vertically aligned

        // Create buttons for each available quiz topic
        JButton btnPokemon = new JButton("Pokémon");
        JButton btnBasketball = new JButton("Basketball");
        JButton btnGundam = new JButton("Gundam");
        JButton btnKOF = new JButton("King of Fighters");

        // When Pokémon is selected, launch a new QuizGame with Pokemon questions
        btnPokemon.addActionListener(e -> {
            frame.dispose(); // Close this window
            new QuizGame(new Pokemon()); // Start game
        });

        // When Basketball is selected
        btnBasketball.addActionListener(e -> {
            frame.dispose();
            new QuizGame(new Basketball());
        });

        // When Gundam is selected
        btnGundam.addActionListener(e -> {
            frame.dispose();
            new QuizGame(new Gundam());
        });

        // When KOF is selected
        btnKOF.addActionListener(e -> {
            frame.dispose();
            new QuizGame(new KOF());
        });

        // Add all buttons to the frame (GUI)
        frame.add(btnPokemon);
        frame.add(btnBasketball);
        frame.add(btnGundam);
        frame.add(btnKOF);

        // Center the window on screen
        frame.setLocationRelativeTo(null);

        // Display the topic selection screen
        frame.setVisible(true);
    }
}