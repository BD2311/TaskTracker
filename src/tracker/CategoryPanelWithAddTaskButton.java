package tracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
				String taskName = JOptionPane.showInputDialog("What is the name of your task?");
				if (taskName != null) // Check if user has clicked "OK"
				{
					if(!taskName.isEmpty()) // Check if taskName is empty
						add(new TaskPanel(taskName, CategoryPanelWithAddTaskButton.this, CategoryPanelWithAddTaskButton.this.getModel()));
					else
						JOptionPane.showMessageDialog(null, "You must specify a name for a task.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		getCategoryHeader().add(addTaskButton);
	}

}
