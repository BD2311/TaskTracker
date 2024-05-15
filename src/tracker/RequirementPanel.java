package tracker;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.12.001
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
public class RequirementPanel extends JPanel
{
	///// Fields /////

	private String _name = "Requirement"; // Default requirement name
	private boolean _complete; // Flag indicating whether the requirement is complete
	private JCheckBox completionCheckBox;
	private TaskPanel _parentTask; // Parent reference to TaskPanel that holds this requirement

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

	public RequirementPanel(String requirementName, TaskPanel parentTask)
	{
		this._name = requirementName;
		this._parentTask = parentTask;
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

		JButton removeRequirementButton = new JButton("Remove"); // Create button to remove requirement
		removeRequirementButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent buttonPress) 
			{
				_parentTask.remove(RequirementPanel.this);
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
					setCompleteTrue(); // Mark requirement as complete
					
					
				} 
				else 
				{
					setCompleteFalse(); // Mark requirement as incomplete
					
				}
			}
		});
		this.add(completionCheckBox); // Add requirementCheckbox to requirement panel

		setVisible(true); // Make the requirement panel visible
	}

	public TaskPanel getParentTask()
	{
		return this._parentTask;
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

	/**
	 * Checks if the requirement is complete.
	 * 
	 * @return True if the requirement is complete, false otherwise.
	 */
	public boolean isComplete()
	{
		return this._complete;
	}

	/**
	 * Set the completion of a requirement to true
	 */
	public void setCompleteTrue()
	{
		this._complete = true;
		completionCheckBox.setSelected(true);
	}

	/**
	 * Set the completion of a requirement to false
	 */
	public void setCompleteFalse()
	{
		this._complete = false;
		completionCheckBox.setSelected(false);
	}
}