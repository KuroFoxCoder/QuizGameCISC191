package quizGame;

import javax.swing.*;
import java.awt.BorderLayout;

public class TopicScreen extends JFrame
{
	private JFrame topicScreen;
	private String chosenTopic;
	private String[] topics = {"Basketball","Pokemon","Gundam","KOF"};
	public TopicScreen()
	{
		
	}
	public void displayTopics()
	{
		
		chosenTopic = null;
	}
	public void selectTopic() 
	{
		chosenTopic = null;
	}
	
}
