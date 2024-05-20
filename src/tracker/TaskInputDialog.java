package tracker;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TaskInputDialog 
{
	private String taskName;
	private String taskType;
	private JTextField taskNameField;
	private JRadioButton workTaskButton;
	private JRadioButton personalTaskButton;
	private int result;

	/**
	 * Constructs the TaskInputDialog and initializes the UI components.
	 */
	public TaskInputDialog() 
	{
		initializeUI();
	}

	/**
	 * Initializes the user interface of the input dialog.
	 */
	private void initializeUI() 
	{
		taskNameField = new JTextField();
		workTaskButton = new JRadioButton("WorkTask");
		personalTaskButton = new JRadioButton("PersonalTask");
		ButtonGroup group = new ButtonGroup();
		group.add(workTaskButton);
		group.add(personalTaskButton);

		// Create a panel to hold the radio buttons and input field
		JPanel panel = new JPanel(new BorderLayout(5, 5));

		// Create a sub-panel for the radio buttons
		JPanel taskTypePanel = new JPanel(new GridLayout(1, 2));
		taskTypePanel.add(workTaskButton);
		taskTypePanel.add(personalTaskButton);

		// Add the radio buttons panel to the main panel
		panel.add(taskTypePanel, BorderLayout.NORTH);

		// Add the input field to the main panel
		panel.add(taskNameField, BorderLayout.CENTER);

		// Show the JOptionPane with the custom panel
		result = JOptionPane.showConfirmDialog(null, panel, "Create new task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

		// Handle the user's input
		if (result == JOptionPane.OK_OPTION) {
			this.taskName = taskNameField.getText();
			if (workTaskButton.isSelected()) 
			{
				this.taskType = "WorkTask";
			} 
			else if (personalTaskButton.isSelected()) 
			{
				this.taskType = "PersonalTask";
			} 
			else 
			{
				this.taskType = null;
			}
		}
	}
	
	/**
	 * Gets the result of the user's actions such as clicking ok option
	 * 
	 * @return result of user action
	 */
	public int getResult()
	{
		return this.result;
	}

	/**
	 * Returns the name of the task input by the user.
	 * 
	 * @return taskName
	 */
	public String getTaskName() 
	{
		return taskName;
	}

	/**
	 * Returns the type of the task input by the user.
	 * 
	 * @return taskType
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * Checks if the input is valid.
	 * 
	 * @return true if both task name and task type are provided
	 */
	public boolean isInputValid() 
	{
		return taskName != null && !taskName.isEmpty() && taskType != null;
	}

	/**
	 * Main method to demonstrate the TaskInputDialog.
	 */
	public static void main(String[] args) 
	{
		TaskInputDialog inputDialog = new TaskInputDialog();

		if (inputDialog.isInputValid()) 
		{
			System.out.println("Task Name: " + inputDialog.getTaskName());
			System.out.println("Task Type: " + inputDialog.getTaskType());
		} else {
			System.out.println("Invalid input.");
		}
	}
}
