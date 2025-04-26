package quizGame;

import javax.swing.*;
import java.awt.BorderLayout;

public class TopicScreen extends JFrame
{
	private JFrame topicScreen;
	private String chosenTopic;
	private String[] topics = {"Basketball","Pokemon","Gundam","KOF"};
	public void displayTopics()
	{
		this.setLayout(new BorderLayout());
		JPanel instructions = new JPanel();
		JLabel instructionLabel = new JLabel("Use the drop-down menu to choose a topic:");
		instructions.add(instructionLabel);
		this.add(instructions, BorderLayout.NORTH);
		
		JPanel menuPanel = new JPanel();
		JComboBox<String> topicMenu = new JComboBox<String>();
		menuPanel.add(topicMenu);
		this.add(menuPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		JButton topicPicker = new JButton();
		topicPicker.setText("Pick Topic");
		buttonPanel.add(topicPicker);
		this.add(buttonPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public String selectTopic() 
	{
		chosenTopic = null;
		return chosenTopic;
	}
	
}
