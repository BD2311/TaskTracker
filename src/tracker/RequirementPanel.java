package tracker;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.002
 * 
 * Responsibilities of class:
 * 
 * Represents a panel displaying a single requirement.
 * - Displaying the name of the requirement.
 * - Providing functionality to mark the requirement as complete or incomplete.
 * - Providing functionality to remove the requirement from its parent container (if it is a TaskPanel).
 * 
 */
@SuppressWarnings("serial")
public class RequirementPanel extends JPanel implements Completable
{
	///// Fields /////

	private String _name = "Requirement"; // Default requirement name
	private boolean _complete; // Flag indicating whether the requirement is complete
	private JCheckBox completionCheckBox; // Reference to the completion checkbox component
	private JButton removeRequirementButton; // Reference to the remove button component
	private TaskPanel _parentTask; // Parent reference to TaskPanel that holds this requirement
	private TaskTrackerModel _model;

	///// Constructor /////

	/**
	 * Constructs a RequirementPanel object with the specified requirement name.
	 * 
	 * @param requirementName The name of the requirement.
	 */
	public RequirementPanel(String requirementName)
	{
		this._name = requirementName;
		initializeUI();
	}

	public RequirementPanel(String requirementName, TaskPanel parentTask, TaskTrackerModel model)
	{
		this._name = requirementName;
		this._parentTask = parentTask;
		this._model = model;
		initializeUI();
	}

	///// Methods /////

	/**
	 * Initializes the user interface of the requirement panel.
	 */
	private void initializeUI()
	{
		this.setBorder(new TitledBorder(this.getName())); // Set border with requirement name
		this.setLayout(new FlowLayout(FlowLayout.LEFT));  // Use flow layout with left alignment

		removeRequirementButton = new JButton("Remove"); // Create button to remove requirement
		removeRequirementButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent buttonPress) 
			{
				_parentTask.remove(RequirementPanel.this);
				if (!_parentTask.getRequirements().isEmpty() && _parentTask.checkIfAllRequirementsAreComplete()) // Check if parent has any requirements and check if all requirements of parent are complete
					_parentTask.setComplete(true); // Set parent task to complete if all requirements are complete
				System.out.println(RequirementPanel.this.getParentTask().getName() + " " + RequirementPanel.this.getParentTask().isComplete());
				RequirementPanel.this.getParentTask().getModel().sortTasks(RequirementPanel.this.getParentTask());
				_parentTask.revalidate(); // Update layout
				_parentTask.repaint(); // Repaint the panel
			}
		});
		this.add(removeRequirementButton); // Add removeRequirementButton to requirement panel

		// Checkbox to mark requirement as complete
		completionCheckBox = new JCheckBox();
		completionCheckBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent check)
			{
				// Toggle completion status based on checkbox state
				if (completionCheckBox.isSelected()) 
				{
					setComplete(true); // Mark requirement as complete
					if(_parentTask.checkIfAllRequirementsAreComplete()) // Check is parent task is complete after checking this requirement
						_parentTask.setComplete(true); // Set parent task to complete if all requirements are checked to be complete
					RequirementPanel.this.getModel().sortTasks(_parentTask);
				} 
				else 
				{
					setComplete(false); // Mark requirement as incomplete
					completionCheckBox.setSelected(false);
					if(!_parentTask.checkIfAllRequirementsAreComplete()) // Check is parent task is complete after checking this requirement
						_parentTask.setComplete(false); // Set parent task to incomplete if not all requirements are checked to be complete
					RequirementPanel.this.getModel().sortTasks(_parentTask);
				}
			}
		});
		this.add(completionCheckBox); // Add requirementCheckbox to requirement panel

		setVisible(true); // Make the requirement panel visible
	}

	/**
	 * Get the model of this
	 * 
	 * @return
	 */
	public TaskTrackerModel getModel()
	{
		return this._model;
	}

	/**
	 * Get the parent task of this
	 * 
	 * @return
	 */
	public TaskPanel getParentTask()
	{
		return this._parentTask;
	}

	/**
	 * Get the completion check box of this
	 * 
	 * @return
	 */
	public JCheckBox getCompletionCheckBox()
	{
		return this.completionCheckBox;
	}

	/**
	 * Get the remove button of this
	 * 
	 * @return
	 */
	public JButton getRemoveButton()
	{
		return this.removeRequirementButton;
	}

	/**
	 * Gets the name of the requirement.
	 * 
	 * @return The name of the requirement.
	 */
	public String getName()
	{
		return this._name;
	}
	
	@Override
	public String getStatus() 
	{
		if(isComplete())
			return "Complete";
		return "Incomplete";
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
		completionCheckBox.setSelected(complete);
		System.out.println(this.getName() + " is " + this.isComplete());
	}

	@Override
	public String toString()
	{
		return "Requirement: " + getName() + ", Status: " + getStatus();
	}
}