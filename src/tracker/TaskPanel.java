package tracker;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

public class TaskPanel extends JPanel
{
	///// Fields /////

	private String _name = "Task";
	private boolean _complete;
	private List<RequirementPanel> _requirements = new ArrayList<RequirementPanel>();

	///// Constructor /////

	public TaskPanel(String name)
	{
		this._name = name;
		initializeUI();
	}

	///// Methods /////

	private void initializeUI()
	{
		this.add(new JLabel(this._name));
		this.setBorder(new TitledBorder("Task"));

		JButton addRequirementButton = new JButton("New Requirement");
		addRequirementButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent buttonPressed)
			{
				String requirementName = JOptionPane.showInputDialog("What is the name of your requirement?");
				if (requirementName != null && !requirementName.isEmpty()) 
				{
		            TaskPanel.this.addRequirement(new RequirementPanel(requirementName));
		            TaskPanel.this.revalidate();
		            TaskPanel.this.repaint();
		        }
			}
		});
		this.add(addRequirementButton);

		JButton removeTaskButton = new JButton("Remove Task");
		removeTaskButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent buttonPressed) 
			{
				int answer =JOptionPane.showConfirmDialog(null, "Do you wish to remove " + TaskPanel.this.getName() + " ?");
				Container parentContainer = TaskPanel.this.getParent();
				switch(answer)
				{
				case 0:
				{
					// If the parent container is an instance of TaskPanel,
					// remove this RequirementPanel from it
					if (parentContainer instanceof CategoryPanel) 
					{
						CategoryPanel parentCategoryPanel = (CategoryPanel) parentContainer;
						parentCategoryPanel.removeTask(TaskPanel.this);
						parentCategoryPanel.revalidate(); // Update layout
						parentCategoryPanel.repaint(); // Repaint the panel
					}	
				}
				default:
				{
					// Do nothing
				}
				}
			}
		});
		this.add(removeTaskButton);


		JCheckBox completeCheckBox = new JCheckBox();
		completeCheckBox.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent check) 
			{
				if(completeCheckBox.isSelected())
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
		this.add(completeCheckBox);

		setVisible(true);
	}

	public void setCompleteTrue() 
	{
		this._complete = true;
	}

	public void setCompleteFalse()
	{
		this._complete = false;
	}

	public boolean isComplete()
	{
		return this._complete;
	}

	/**
	 * Gets task name
	 * @return task name
	 */
	public String getName()
	{
		return this._name;
	}

	/**
	 * Set task name
	 * @param newTaskName
	 */
	public void setName(String newName)
	{
		this._name = newName;
	}

	public void addRequirement(RequirementPanel requirementPanel)
	{
		this.add(requirementPanel);
		this._requirements.add(requirementPanel); // Add requirementPanel's requirement to TaskPanel's task
	}

	public void removeRequirement(RequirementPanel requirementPanel)
	{
		this.remove(requirementPanel);
		this._requirements.remove(requirementPanel);
	}

	public List<RequirementPanel> getRequirements()
	{
		return this._requirements;
	}

	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		displayFrame.getContentPane().add(new TaskPanel("Test"));
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.show();
	}
}
