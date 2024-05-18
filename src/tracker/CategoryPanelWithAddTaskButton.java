package tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.001
 * 
 * Responsibilities of class:
 * 
 * Represents a panel displaying a category information and scroll pane of tasks.
 * - Displaying the category header.
 * - Providing functionality to adding tasks
 * 
 */
@SuppressWarnings("serial")
public class CategoryPanelWithAddTaskButton extends CategoryPanel
{

	public CategoryPanelWithAddTaskButton(String name) 
	{
		super(name);
		initializeUI();
	}

	public CategoryPanelWithAddTaskButton(String name, TaskTrackerModel model) 
	{
		super(name, model);
		initializeUI();
	}

	/**
	 * Initializes the user interface of the category panel.
	 */
	@Override
	protected void initializeUI()
	{
		super.initializeUI();

		JButton addTaskButton = new JButton("New Task");
		addTaskButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				TaskInputDialog inputDialog = new TaskInputDialog();

				if(inputDialog.isInputValid())
				{
					String taskName = inputDialog.getTaskName();
					String taskType = inputDialog.getTaskType();

					try
					{
						switch (taskType) 
						{
						case "WorkTask":
							new WorkTaskPanel(taskName, CategoryPanelWithAddTaskButton.this, CategoryPanelWithAddTaskButton.this.getModel());
							break;
						case "PersonalTask":
							new PersonalTaskPanel(taskName, CategoryPanelWithAddTaskButton.this, CategoryPanelWithAddTaskButton.this.getModel());
							break;
						default:
							throw new IllegalArgumentException("Unknown task type: " + taskType);
						}
					}
					catch(ModelNotFoundException exception)
					{
						switch (taskType) 
						{
						case "WorkTask":
							new WorkTaskPanel(taskName, CategoryPanelWithAddTaskButton.this);
							break;
						case "PersonalTask":
							new PersonalTaskPanel(taskName, CategoryPanelWithAddTaskButton.this);
							break;
						default:
							throw new IllegalArgumentException("Unknown task type: " + taskType);
						}
					}
					catch(IllegalArgumentException exception)
					{
						exception.getStackTrace();
					}
				}
				else 
				{
	                JOptionPane.showMessageDialog(null, "You must specify a name and type for a task.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
	            }
			}
		});
		
		getCategoryHeader().add(addTaskButton);
	}

	/**
	 * Main method for testing the CategoryPanel class.
	 * - Tests visual representation of a Category
	 * - (Bug) Functionality conflicts with sort tasks method
	 * 
	 * @param args Command line arguments (unused).
	 */
	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		CategoryPanelWithAddTaskButton testCategoryPanel = new CategoryPanelWithAddTaskButton("Category With Add Task Button");
		TaskPanel testTaskPanel = new TaskPanel("Task", testCategoryPanel);
		RequirementPanel testRequirementPanel = new RequirementPanel("Requirement", testTaskPanel);
		testTaskPanel.add(testRequirementPanel);
		testCategoryPanel.add(testTaskPanel);
		displayFrame.getContentPane().add(testCategoryPanel);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.show();
	}

}
