package quizGame;

import javax.swing.*;
import java.awt.BorderLayout;

public class TopicScreen extends JFrame
{
	private JFrame topicScreen;
	private String chosenTopic;
	private QuizGame newGame;
	private String[] topics = {"Basketball","Pokemon","Gundam","KOF"};
	public TopicScreen()
	{
		this.setLayout(new BorderLayout());
		JPanel instructions = new JPanel();
		JLabel instructionLabel = new JLabel("Use the drop-down menu to choose a topic:");
		instructions.add(instructionLabel);
		this.add(instructions, BorderLayout.NORTH);
		
		JPanel menuPanel = new JPanel();
		JComboBox<String> topicMenu = new JComboBox<String>();
		for(int i = 0; i < topics.length;i++)
		{
			topicMenu.addItem(topics[i]);
		}
		menuPanel.add(topicMenu);
		this.add(menuPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		JButton topicPicker = new JButton();
		topicPicker.setText("Pick Topic");
		topicPicker.addActionListener(e -> {this.selectTopic(topicMenu.getSelectedItem().toString());});
		buttonPanel.add(topicPicker);
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void selectTopic(String picked) 
	{
		chosenTopic = picked;
		System.out.println(chosenTopic);
		new QuizGame(chosenTopic);
		this.dispose();
	}
	
}
