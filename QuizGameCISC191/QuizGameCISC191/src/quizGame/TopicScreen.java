package quizGame;

import javax.swing.*;
import java.awt.BorderLayout;

public class TopicScreen extends JFrame //A TopicScreen is-a JFrame
{
	private String chosenTopic; //A topicScreen has-a chosen topic
	private String[] topics = {"Basketball","Pokemon","Gundam","KOF"}; //A TopicScreen has-an array of topics
	public TopicScreen()
	{
		this.setLayout(new BorderLayout()); //Set the layout of the TopicScreen to be a BorderLayout
		JPanel instructions = new JPanel(); //Make a panel for instructions
		JLabel instructionLabel = new JLabel("Use the drop-down menu to choose a topic:"); //Add a label with the instructions on the JPanel
		instructions.add(instructionLabel); //Add the label to the instruction panel
		this.add(instructions, BorderLayout.NORTH); //Add the panel to the north side of the JFrame
		
		JPanel menuPanel = new JPanel(); //Make a new JPanel for the drop-down menu
		JComboBox<String> topicMenu = new JComboBox<String>(); //Set up a drop-down menu for the topics.
		for(int i = 0; i < topics.length;i++) //For every index in the topic array, add the respective topic to the drop-down menu.
		{
			topicMenu.addItem(topics[i]);
		}
		menuPanel.add(topicMenu); //Add the drop-down menu to the panel when it has all the topics in
		this.add(menuPanel, BorderLayout.CENTER); //Add the menu panel to the center portion of the border layout.
		
		JPanel buttonPanel = new JPanel(); //Make a new Panel for the button 
		JButton topicPicker = new JButton(); //Make a button for the panel
		topicPicker.setText("Pick Topic"); //Label the button
		topicPicker.addActionListener(e -> {this.selectTopic(topicMenu.getSelectedItem().toString());}); //Add functionality to the button, which will start the game in the method called by the button.
		buttonPanel.add(topicPicker); //Add the button to the panel
		this.add(buttonPanel, BorderLayout.SOUTH); //Add the panel to the south side of the JFrame.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set the TopicScreen to close when the close button is pressed.
		pack();
		setVisible(true); //Show the JFrame
	}
	public void selectTopic(String picked) 
	{
		chosenTopic = picked; //Set the chosen topic
		System.out.println(chosenTopic);
		new QuizGame(chosenTopic); //Start a new QuizGame with the chosen Topic
		this.dispose(); //Close the TopicScreen.
	}
	
}
