package tracker;

import java.awt.BorderLayout;
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
 * Version/date: 2024.05.15.002
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
public class TaskPanel extends JPanel implements Completable
{
	///// Fields /////

	private String _name = "Task"; // Default task name
	private boolean _complete; // Flag indicating whether the task is complete
	private List<RequirementPanel> _requirements = new ArrayList<RequirementPanel>();  // List to store requirement panels
	private JPanel requirementsPanelContainer; // Container panel for requirement panels
	private JCheckBox completionCheckBox; // Reference to the completion checkbox component
	private JButton addRequirementButton;
	private CategoryPanel _parentCategory; // Parent reference to CategoryPanel that holds this task
	private TaskTrackerModel _model;

	///// Constructor /////

	/**
	 * Constructs a TaskPanel with name.
	 * 
	 * @param name The name of the task.
	 */
	public TaskPanel(String name) 
	{
		this._name = name;
		initializeUI();
	}
	
	/**
	 * Constructs a TaskPanel with name and reference to parentCategory
	 * 
	 * @param name The name of the Task.
	 * @param parentCategory The reference to the parentCategory
	 */
	public TaskPanel(String name, CategoryPanel parentCategory)
	{
		this._name = name;
		this._parentCategory = parentCategory;
		parentCategory.add(this);
		initializeUI();
	}

	/**
	 * Constructs a TaskPanel with name, reference to parentCategory, and reference to model.
	 * 
	 * @param name The name of the Task.
	 * @param parentCategory The reference to the parentCategory
	 * @param model The reference to the model
	 */
	public TaskPanel(String name, CategoryPanel parentCategory, TaskTrackerModel model) 
	{
		this._name = name;
		this._parentCategory = parentCategory;
		this._model = model;
		parentCategory.add(this);
		initializeUI();
	}

	///// Methods /////

	/**
	 * Initializes the user interface of the task panel.
	 */
	protected void initializeUI() 
	{	
		this.setBorder(new TitledBorder(this.getName())); // Set border with task name
		this.setLayout(new BorderLayout()); // Use border layout for components
		JPanel taskHeader = new JPanel(); // Create panel for task header
		taskHeader.setLayout(new FlowLayout(FlowLayout.LEFT)); // Use flow layout with left alignment

		// Add Requirement Button
		addRequirementButton = new JButton("New Requirement"); // Create button to add requirements
		addRequirementButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// Prompt user for requirement name and add a new requirement panel
				String requirementName = JOptionPane.showInputDialog("What is the name of your requirement?");
				if (requirementName != null) // Check if user presses "OK"
				{
					if(!requirementName.isEmpty())
					{
						new RequirementPanel(requirementName, TaskPanel.this, TaskPanel.this.getModel());
						TaskPanel.this.getModel().sortTasks(TaskPanel.this);
					}
					else
						JOptionPane.showMessageDialog(null, "You must specify a name for a requirement.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
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
					System.out.println(TaskPanel.this.getParentCategory().getName());
				}
			}
		});
		taskHeader.add(removeTaskButton); // Add removeTaskButton to task header

		// Complete Check Box
		completionCheckBox = new JCheckBox(); // Create check box to mark task complete
		completionCheckBox.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				TaskPanel.this.setComplete(completionCheckBox.isSelected()); // Update completion status
				TaskPanel.this.setEnabledAllRequirements(_complete);
				TaskPanel.this.setAllRequirementsComplete(_complete);
				TaskPanel.this.getModel().sortTasks(TaskPanel.this);
			}
		});
		taskHeader.add(completionCheckBox); // Add completeCheckBox to task header

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
	 * Get the model
	 * 
	 * @return model
	 */
	public TaskTrackerModel getModel()
	{
		return this._model;
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
	 * Sets the parentCategory to a CategoryPanel
	 * 
	 * @param categoryPanel
	 */
	public void setParentCategory(CategoryPanel categoryPanel) 
	{
		this._parentCategory = categoryPanel;
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
		requirementsPanelContainer.revalidate();
		requirementsPanelContainer.repaint();
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
		requirementsPanelContainer.revalidate();
		requirementsPanelContainer.repaint();
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
	 * Checks if the task is complete by traversing completion status of all requirements.
	 * 
	 * @return True if the task is complete, false otherwise.
	 */
	public boolean checkIfAllRequirementsAreComplete()
	{
		for(RequirementPanel requirement : _requirements)
		{
			if(!requirement.isComplete())
			{
				System.out.println("Not all requirements are complete");
				return false;
			}
		}
		System.out.println("All requirements are complete");
		return true;
	}

	/**
	 * If all requirements are complete, set this to complete
	 * 
	 * @param complete
	 */
	public void setCompleteIfAllRequirementsAreComplete(boolean complete)
	{
		if(checkIfAllRequirementsAreComplete())
		{
			setComplete(complete);
		}
	}

	/**
	 * Sets enabled all requirements within a task to complete
	 * 
	 * @param complete
	 */
	public void setEnabledAllRequirements(boolean complete)
	{
		for(RequirementPanel requirement : _requirements)
		{
			requirement.getCompletionCheckBox().setSelected(complete);
			requirement.setEnabled(!complete); // Disable or enable all requirement's components
		}
	}

	/**
	 * Sets all requirements within this to complete
	 * 
	 * @param complete
	 */
	public void setAllRequirementsComplete(boolean complete)
	{
		for(RequirementPanel requirement : _requirements)
		{
			requirement.setComplete(complete);
		}
	}

	/**
	 * Checks if task has any requirements
	 * 
	 * @return true if no requirements, false if contains requirements
	 */
	public boolean hasNoRequirements()
	{
		if(this.getRequirements().isEmpty()) 
		{
			return true;
		}
		return false;
	}

	/**
	 * Checks if task has any complete requirements
	 * 
	 * @return true if atleast one requirement is complete, false if no requirement is complete
	 */
	public boolean isPartiallyComplete()
	{
		for (RequirementPanel requirement : _requirements)
		{
			if(requirement.isComplete())
				return true;
		}
		return false;
	}

	/**
	 * Gets a list of all requirements in this task.
	 * 
	 * @return A string representing the list of requirements.
	 */
	public String getRequirementsStatus() 
	{
		StringBuilder listOfRequirements = new StringBuilder();
		for (RequirementPanel requirement : _requirements) 
		{
			listOfRequirements.append("   >> ").append(requirement.toString()).append("\n");
		}
		return listOfRequirements.toString();
	}

	@Override
	public boolean isComplete()
	{
		return this._complete;
	}

	@Override
	public void setComplete(boolean complete)
	{
		this._complete = complete;
		addRequirementButton.setEnabled(!complete);
		completionCheckBox.setSelected(complete);
		setEnabledAllRequirements(complete);
		System.out.println(getName() + " complete? is: " + isComplete()); // Output completion status
	}

	@Override
	public String getStatus() 
	{
		if(isComplete())
			return "Complete";
		return "Incomplete";
	}

	@Override
	public String toString()
	{
		return "Task: " + this.getName() + ", Status: " + getStatus()
		+ "\n  ----------------"
		+ "\n" + getRequirementsStatus();
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
