import javax.swing.*;
import java.awt.event.*;

/**
 * Lead Author(s): Marc Ferrer , Oscar Arellano
 * 
 * 
 * Version/date: V1 04/28/2025
 * 
 * Responsibilities of class: - Controls the quiz flow using a selected Topic. -
 * Displays questions and answer options in a Swing GUI. - Handles timing,
 * answer selection, score calculation, and game end.
 * 
 * Object-Oriented Relationships: - QuizGame is-a Object (implicit) - QuizGame
 * has-a Topic - QuizGame has-a QuizTimer - QuizGame has-a Score - QuizGame
 * has-many Question - QuizGame has-many JButton (options) - QuizGame has-many
 * JLabel (answer labels)
 * 
 * Refereces:
 * 
 */
public class QuizGame {

	// The selected topic that provides the questions (has-a Topic)
	private Topic selectedTopic;

	// Array of questions from the topic (has-many Question)
	private Question[] questions;

	// Tracks the current question index
	private int index = 0;

	// Score tracker for correct answers (has-a Score)
	private Score score;

	// Timer for each question (has-a QuizTimer)
	private QuizTimer timer;

	// Number of seconds per question
	private final int questionTime = 15;

	// GUI Components (has-a JFrame)
	private JFrame frame;

	// Timer label for count down
	private JLabel timerLabel;

	// Displays "Question 1", "Question 2", etc.
	private JTextField questionNumber;

	// Area to display the question text
	private JTextArea questionArea;

	// Buttons for answer choices A–D (has-many JButton)
	private JButton[] optionButtons;

	// Labels to display each answer option (has-many JLabel)
	private JLabel[] optionLabels;

	/**
	 * Constructor: Initializes the quiz with the selected topic and sets up GUI.
	 * 
	 * @param topic the quiz topic to load questions from
	 */
	public QuizGame(Topic topic) {
		this.selectedTopic = topic;
		this.questions = selectedTopic.getQuestions(); // Retrieve questions from the topic
		this.score = new Score(); // Initialize the score tracker
		this.timer = new QuizTimer(); // Initialize the countdown timer
		setupGUI(); // Build the graphical user interface
		startGame(); // Begin the game loop
	}

	/**
	 * Sets up the main graphical user interface using Java Swing components.
	 */
	private void setupGUI() {
		frame = new JFrame("Quiz Game");
		frame.setSize(700, 700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Top field for question number
		questionNumber = new JTextField();
		questionNumber.setBounds(0, 0, 700, 50);
		questionNumber.setHorizontalAlignment(JTextField.CENTER);
		questionNumber.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
		questionNumber.setEditable(false);
		frame.add(questionNumber);

		// Area for the question text
		questionArea = new JTextArea();
		questionArea.setBounds(0, 60, 700, 60);
		questionArea.setLineWrap(true);
		questionArea.setWrapStyleWord(true);
		questionArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 22));
		questionArea.setEditable(false);
		frame.add(questionArea);

		// Setup 4 option buttons and labels
		optionButtons = new JButton[4];
		optionLabels = new JLabel[4];

		for (int i = 0; i < 4; i++) {
			final int idx = i;

			// Create buttons for A, B, C, D
			optionButtons[i] = new JButton(String.valueOf((char) ('A' + i)));
			optionButtons[i].setBounds(10, 140 + i * 100, 80, 80);
			optionButtons[i].setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));
			optionButtons[i].addActionListener(e -> checkAnswer(idx));
			frame.add(optionButtons[i]);

			// Create answer option labels
			optionLabels[i] = new JLabel();
			optionLabels[i].setBounds(100, 140 + i * 100, 580, 80);
			optionLabels[i].setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 22));
			frame.add(optionLabels[i]);
		}

		// Countdown timer label
		timerLabel = new JLabel("15");
		timerLabel.setBounds(600, 600, 80, 50);
		timerLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 40));
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(timerLabel);

		// Display the frame
		frame.setVisible(true);
	}

	/**
	 * Starts the quiz by resetting the index and score.
	 */
	private void startGame() {
		index = 0;
		score = new Score(); // Reset score if playing again
		showQuestion();
	}

	/**
	 * Displays the current question and starts the timer.
	 */
	private void showQuestion() {
		if (index >= questions.length) {
			endGame(); // All questions answered
			return;
		}

		Question current = questions[index];
		questionNumber.setText("Question " + (index + 1));
		questionArea.setText(current.getQuestionText());

		String[] opts = current.getOptions();
		for (int i = 0; i < 4; i++) {
			optionButtons[i].setEnabled(true);
			optionLabels[i].setText(opts[i]);
			optionLabels[i].setForeground(java.awt.Color.BLACK);
		}

		// Start count down timer for this question
		timer.startTimer(timerLabel, questionTime, () -> handleTimeout());
	}

	/**
	 * Called when a user selects an answer.
	 * 
	 * @param chosenIndex the index (0–3) of the selected answer
	 */
	private void checkAnswer(int chosenIndex) {
		disableButtons();
		timer.stopTimer();

		Question current = questions[index];
		String chosenLetter = String.valueOf((char) ('A' + chosenIndex));
		boolean correct = current.isCorrectAnswer(chosenLetter);

		if (correct) {
			score.increaseScore(); // Increment score
		} else {
			optionLabels[chosenIndex].setForeground(java.awt.Color.RED); // Highlight incorrect
			score.incrementTotal();
		}

		// Highlight the correct answer in green
		for (int i = 0; i < 4; i++) {
			if (current.isCorrectAnswer(String.valueOf((char) ('A' + i)))) {
				optionLabels[i].setForeground(java.awt.Color.GREEN);
			}
		}

		// Delay before showing the next question
		Timer pause = new Timer(2000, e -> {
			index++;
			showQuestion();
		});
		pause.setRepeats(false);
		pause.start();
	}

	/**
	 * Called when time runs out and the user hasn’t answered.
	 */
	private void handleTimeout() {
		disableButtons();

		Question current = questions[index];

		// Highlight correct vs. incorrect options
		for (int i = 0; i < 4; i++) {
			if (current.isCorrectAnswer(String.valueOf((char) ('A' + i)))) {
				optionLabels[i].setForeground(java.awt.Color.GREEN);
			} else {
				optionLabels[i].setForeground(java.awt.Color.RED);
			}
		}

		Timer pause = new Timer(2000, e -> {
			index++;
			showQuestion();
		});
		pause.setRepeats(false);
		pause.start();
	}

	/**
	 * Disables all option buttons to prevent multiple clicks.
	 */
	private void disableButtons() {
		for (JButton button : optionButtons) {
			button.setEnabled(false);
		}
	}

	/**
	 * Ends the quiz and displays the final results to the user.
	 */
	private void endGame() {
		for (JButton button : optionButtons)
			button.setVisible(false);
		for (JLabel label : optionLabels)
			label.setVisible(false);

		questionNumber.setText("RESULTS");
		questionArea.setText("You got " + score.getCorrect() + " out of " + score.getTotal()
				+ " correct.\nFinal Score: " + score.calculatePercentage() + "%");
		timerLabel.setVisible(false);
	}
}