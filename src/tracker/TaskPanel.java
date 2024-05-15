package tracker;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.12.001
 * 
 * Responsibilities of class:
 * 
 * Represents a panel displaying a task information and scroll pane of requirements.
 * - Displaying the task header.
 * - Providing functionality to adding requirements
 * - Providing functionality to deleting task
 * 
 */
@SuppressWarnings("serial")
public class TaskPanel extends JPanel
{
	///// Fields /////

	private String _name = "Task"; // Default task name
	private boolean _complete; // Flag indicating whether the task is complete
	private List<RequirementPanel> _requirements = new ArrayList<RequirementPanel>();  // List to store requirement panels
	private JPanel requirementsPanelContainer; // Container panel for requirement panels
	private CategoryPanel _parentCategory; // Parent reference to CategoryPanel that holds this task

	///// Constructor /////

	/**
	 * Constructs a TaskPanel object with the specified name.
	 * 
	 * @param name The name of the task.
	 */
	public TaskPanel(String name) 
	{
		this._name = name;
		initializeUI();
	}
	
	/**
	 * Constructs a TaskPanel object with the specified name and CategoryPanel.
	 * 
	 * @param name
	 * @param parentCategory
	 */
	public TaskPanel(String name, CategoryPanel parentCategory) 
	{
		this._name = name;
		this._parentCategory = parentCategory;
		initializeUI();
	}

	///// Methods /////

	/**
	 * Initializes the user interface of the task panel.
	 */
	private void initializeUI() 
	{	
		this.setBorder(new TitledBorder(this.getName())); // Set border with task name
		this.setLayout(new BorderLayout()); // Use border layout for components
		JPanel taskHeader = new JPanel(); // Create panel for task header
		taskHeader.setLayout(new FlowLayout(FlowLayout.LEFT)); // Use flow layout with left alignment


		// Add Requirement Button
		JButton addRequirementButton = new JButton("New Requirement"); // Create button to add requirements
		addRequirementButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// Prompt user for requirement name and add a new requirement panel
				String requirementName = JOptionPane.showInputDialog("What is the name of your requirement?");
				if (requirementName != null && !requirementName.isEmpty()) // Validate input
				{
					TaskPanel.this.add(new RequirementPanel(requirementName));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must specify a name for a requirement.");
				}
			}
		});
		taskHeader.add(addRequirementButton); // Add addRequirementButton to task header

		// Remove Task Button
		JButton removeTaskButton = new JButton("Delete Task"); // Create button to delete task
		removeTaskButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				// Confirm task deletion
				int answer = JOptionPane.showConfirmDialog(null, "Do you wish to delete the task " + TaskPanel.this.getName() + "?");
				if (answer == JOptionPane.YES_OPTION) 
				{
					_parentCategory.remove(TaskPanel.this);
					_parentCategory.revalidate(); // Update layout
					_parentCategory.repaint(); // Repaint the parent container
				}
			}
		});
		taskHeader.add(removeTaskButton); // Add removeTaskButton to task header

		// Complete Check Box
		JCheckBox completeCheckBox = new JCheckBox(); // Create check box to mark task complete
		completeCheckBox.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_complete = completeCheckBox.isSelected(); // Update completion status
				if(_complete == true)
				{
					setCompleteTrue();
				}
				else
				{
					setCompleteFalse();
				}
				System.out.println(getName() + " complete? is: " + isComplete()); // Output completion status
			}
		});
		taskHeader.add(completeCheckBox); // Add completeCheckBox to task header

		// Create container panel for requirement panels with vertical box layout
		requirementsPanelContainer = new JPanel();
		requirementsPanelContainer.setLayout(new BoxLayout(requirementsPanelContainer, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS alignment
		JScrollPane scrollPane = new JScrollPane(requirementsPanelContainer);
		scrollPane.setBorder(new TitledBorder("Requirements"));

		// Add components to the task panel
		this.add(taskHeader, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);

		setVisible(true); // Make the task panel visible
	}

	/**
	 * Get the parent category panel that contains this task.
	 * 
	 * @return parent The category panel that contains this task
	 */
	public CategoryPanel getParentCategory() 
	{
		return this._parentCategory;
	}

	/**
	 * Sets the name of the task.
	 * 
	 * @param newName The new name for the task.
	 */
	public void setName(String newName)
	{
		this._name = newName;
		((TitledBorder) this.getBorder()).setTitle(newName);
	}

	/**
	 * Gets the name of the task.
	 * 
	 * @return The name of the task.
	 */
	public String getName()
	{
		return this._name;
	}

	/**
	 * Adds a requirement panel to the task.
	 * 
	 * @param requirementPanel The requirement panel to be added.
	 */
	public void add(RequirementPanel requirementPanel)
	{
		_requirements.add(requirementPanel); // add to list
		requirementsPanelContainer.add(requirementPanel); // add to panel
		revalidate();
		repaint();
	}

	/**
	 * Removes a requirement panel from the task.
	 * 
	 * @param requirementPanel The requirement panel to be removed.
	 */
	public void remove(RequirementPanel requirementPanel)
	{
		_requirements.remove(requirementPanel); // remove from list
		requirementsPanelContainer.remove(requirementPanel); // remove from panel
		revalidate();
		repaint();
	}

	/**
	 * Gets the list of requirements in the task.
	 * 
	 * @return The list of requirements in the task.
	 */
	public List<RequirementPanel> getRequirements()
	{
		return this._requirements;
	}

	/**
	 * Checks if the task is complete.
	 * 
	 * @return True if the task is complete, false otherwise.
	 */
	public void checkIfAllRequirementsComplete()
	{
		for(RequirementPanel requirement : _requirements)
		{
			if(!requirement.isComplete())
			{
				setCompleteFalse();
			}
			else
				setCompleteTrue();
		}
	}

	/**
	 * Checks if the task is complete.
	 * 
	 * @return True if the task is complete, false otherwise.
	 */
	public boolean isComplete()
	{
		return this._complete;
	}

	/**
	 * Sets the completion status of the task to true.
	 */
	public void setCompleteTrue()
	{
		this._complete = true;
		for(RequirementPanel requirement : _requirements) // Set all requirements of this task to complete
		{
			requirement.setCompleteTrue();
		}
	}

	/**
	 * Sets the completion status of the task to false.
	 */
	public void setCompleteFalse()
	{
		this._complete = false;
		for(RequirementPanel requirement : _requirements) // Set all requirements of this task to incomplete
		{
			requirement.setCompleteFalse();
		}
	}

	/**
	 * Main method for testing the TaskPanel class.
	 * 
	 * @param args Command line arguments (unused).
	 */
	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		displayFrame.getContentPane().add(new TaskPanel("Test"));
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.setVisible(true);
	}
}
