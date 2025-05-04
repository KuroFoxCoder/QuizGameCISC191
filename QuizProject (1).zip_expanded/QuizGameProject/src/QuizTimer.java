import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * Version/date: V1 04/28/2025
 * 
 * Responsibilities of class:
 * - Manages a countdown timer using Swing’s Timer class.
 * - Notifies the controller when time expires.
 * - Provides basic start/stop timer operations.
 * 
 * Object-Oriented Relationships:
 * - QuizTimer is-a Object
 * - QuizTimer has-a javax.swing.Timer
 * - QuizTimer interacts with a Runnable (callback pattern)
 */
public class QuizTimer {

    // Stores the remaining seconds during countdown
    private int seconds;

    // Swing timer that ticks every 1 second (has-a Timer)
    private Timer timer;

    /**
     * Purpose: Starts the timer countdown.
     * 
     * @param label       JLabel to update on screen with the remaining time
     * @param startSeconds the total number of seconds for the countdown
     * @param onTimeout   a Runnable function to execute when time reaches 0
     */
    public void startTimer(JLabel label, int startSeconds, Runnable onTimeout) {
        seconds = startSeconds;                      // Initialize countdown
        label.setText(String.valueOf(seconds));      // Display starting time

        // Create a Swing Timer that ticks every 1000ms (1 second)
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seconds--;                           // Decrease time
                label.setText(String.valueOf(seconds)); // Update time on screen

                if (seconds <= 0) {
                    stopTimer();                     // Stop the timer
                    onTimeout.run();                 // Execute timeout callback
                }
            }
        });

        timer.start(); // Begin countdown
    }

    /**
     * Purpose: Stops the timer if it's running.
     */
    public void stopTimer() {
        if (timer != null) {
            timer.stop();  // Stops ticking
        }
    }
}