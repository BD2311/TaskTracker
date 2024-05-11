package tracker;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.19.001
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

	private String _name = "Requirement";
	private boolean _complete; 

	///// Constructor /////

	public RequirementPanel(String requirementName)
	{
		this._name = requirementName;
		initializeUI();
	}

	///// Methods /////

	private void initializeUI()
	{
		LineBorder lineBorder = new LineBorder(null, 1);
		this.setBorder(lineBorder);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(new JLabel(this._name));

		JButton removeRequirementButton = new JButton("Remove");
		removeRequirementButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent buttonPress) 
			{
				Container parentContainer = RequirementPanel.this.getParent();
				while (parentContainer != null && !(parentContainer instanceof TaskPanel)) // Loop to find desired parent
				{
				    parentContainer = parentContainer.getParent();
				}
				System.out.println(parentContainer.getClass());
				if (parentContainer instanceof TaskPanel) 
				{
					TaskPanel parentTaskPanel = (TaskPanel) parentContainer; // Cast parentTaskPanel on TaskPanel
					parentTaskPanel.remove(RequirementPanel.this);
					parentTaskPanel.revalidate(); // Update layout
					parentTaskPanel.repaint(); // Repaint the panel
				}
			}
		});
		this.add(removeRequirementButton);

		JCheckBox requirementCheckbox = new JCheckBox();
		requirementCheckbox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent check)
			{
				if (requirementCheckbox.isSelected()) 
				{
					setCompleteTrue();
					System.out.println(getName() + " complete? is: " + isComplete());
				} 
				else 
				{
					setCompleteFalse();
					System.out.println(getName() + " complete? is: " + isComplete());
				}
			}
		});
		this.add(requirementCheckbox);

		setVisible(true);
	}

	/**
	 * Gets requirement name
	 * @return
	 */
	public String getName()
	{
		return this._name;
	}

	/**
	 * To check the completion of a requirement
	 * @return 
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
	}

	/**
	 * Set the completion of a requirement to false
	 */
	public void setCompleteFalse()
	{
		this._complete = false;
	}
}