package quizGame;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class QuizGame extends JFrame
{
	private Question quizQuestion;
	private String answer;
	private QuizTimer gameTime;
	private Score score;
	private TopicScreen topicScreen;
	private JFrame gameScreen;
	
	public QuizGame() //Constructor that will put together the GUI
	{
		
	}
	public void startGame() //This method will start the game's code and make the GUIs appear.
	{
		
	}
	public void displayQuestions(Question q)
	{
		quizQuestion = q;
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
