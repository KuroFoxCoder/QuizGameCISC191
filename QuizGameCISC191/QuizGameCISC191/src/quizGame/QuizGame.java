package quizGame;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class QuizGame extends JFrame
{
	private Question quizQuestion;
	private JLabel questionLabel = new JLabel();
	private JLabel answerLabelOne = new JLabel();
	private JLabel answerLabelTwo = new JLabel();
	private JLabel answerLabelThree = new JLabel();
	private JLabel answerLabelFour = new JLabel();
	private String answer;
	private QuizTimer gameTime;
	private Score score;
	private TopicScreen topicScreen = new TopicScreen();
	
	public QuizGame() //Constructor that will put together the GUI
	{
		this.setLayout(new BorderLayout());
		JPanel questionPanel = new JPanel();
		questionPanel.add(questionLabel);
		this.add(questionPanel, BorderLayout.NORTH);
		
		JPanel answerButtonPanel = new JPanel();
		JButton answerOne = new JButton("A");
		JButton answerTwo = new JButton("B");
		JButton answerThree = new JButton("C");
		JButton answerFour = new JButton("D");
		answerButtonPanel.add(answerOne);
		answerButtonPanel.add(answerTwo);
		answerButtonPanel.add(answerThree);
		answerButtonPanel.add(answerFour);
		this.add(answerButtonPanel, BorderLayout.WEST);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) //This will run the topic screen first, and based on the choices made, 
	{
		
	}
	public void startGame() //This method will start the game's code and make the game's main GUI appear.
	{
		topicScreen.displayTopics();
		String topic = topicScreen.selectTopic();
		switch(topic) 
		{
			case "Basketball":
				break;
			case "Gundam":
				break;
			case "KOF":
				break;
			case "Pokemon":
				break;
		}
	}
	public void displayQuestions(Question q)
	{
		quizQuestion = q;
		questionLabel.setText(quizQuestion.getQuestionText());
	}
	public Boolean checkAnswer(String a) //This method will call a different class to check question answers.
	{
		if(answer == a)
		{
			return true;
		}
		return false;
	}
	public void startTimer()
	{
		gameTime.startTimer();
	}
	public void updateScore() //This method will update the score in the background, and only reveal the score when the game ends.
	{
		score.increaseScore();
	}

}
