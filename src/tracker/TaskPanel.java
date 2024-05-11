package tracker;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
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
 * Version/date: 2024.04.19.001
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
	
	private String _name = "Task";
	private boolean _complete;
	private List<RequirementPanel> _requirements = new ArrayList<RequirementPanel>();
	private JPanel requirementsPanelContainer;

	///// Constructor /////
	
	public TaskPanel(String name) 
	{
		this._name = name;
		initializeUI();
	}

	///// Methods /////
	
	private void initializeUI() 
	{
		this.setBorder(new TitledBorder(this.getName()));
		this.setLayout(new BorderLayout());
		JPanel taskHeader = new JPanel();
		taskHeader.setLayout(new FlowLayout(FlowLayout.LEFT));

		
		// Add Requirement Button
		JButton addRequirementButton = new JButton("New Requirement");
		addRequirementButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String requirementName = JOptionPane.showInputDialog("What is the name of your requirement?");
				if (requirementName != null && !requirementName.isEmpty()) 
				{
					TaskPanel.this.add(new RequirementPanel(requirementName));
				}
			}
		});
		taskHeader.add(addRequirementButton);
		
		// Remove Task Button
		JButton removeTaskButton = new JButton("Delete Task");
		removeTaskButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int answer = JOptionPane.showConfirmDialog(null, "Do you wish to delete the task " + TaskPanel.this.getName() + "?");
				if (answer == JOptionPane.YES_OPTION) 
				{
					Container parentContainer = TaskPanel.this.getParent();
					while (parentContainer != null && !(parentContainer instanceof CategoryPanel)) // Loop to find desired parent
					{
					    parentContainer = parentContainer.getParent();
					}
//					System.out.println(parentContainer.getClass());
					if (parentContainer instanceof CategoryPanel)
					{
						CategoryPanel categoryPanel = (CategoryPanel) parentContainer; // Cast parentContainer onto CategoryPanel
						categoryPanel.remove(TaskPanel.this);
						categoryPanel.revalidate(); // Update layout
						categoryPanel.repaint(); // Repaint the parent container
					}
				}
			}
		});
		taskHeader.add(removeTaskButton);

		// Complete Check Box
		JCheckBox completeCheckBox = new JCheckBox();
		completeCheckBox.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_complete = completeCheckBox.isSelected();
				System.out.println(getName() + " complete? is: " + isComplete());
			}
		});
		taskHeader.add(completeCheckBox);

		// Scroll panel for listing tasks
		requirementsPanelContainer = new JPanel();
	    requirementsPanelContainer.setLayout(new BoxLayout(requirementsPanelContainer, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS alignment
	    JScrollPane scrollPane = new JScrollPane(requirementsPanelContainer);
	    scrollPane.setBorder(new TitledBorder("Requirements"));
		

		this.add(taskHeader, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	public void setName(String newName)
	{
		this._name = newName;
		((TitledBorder) this.getBorder()).setTitle(newName);
	}

	public String getName()
	{
		return this._name;
	}

	public void add(RequirementPanel requirementPanel)
	{
		_requirements.add(requirementPanel); // add to list
		requirementsPanelContainer.add(requirementPanel); // add to panel
        revalidate();
        repaint();
	}

	public void remove(RequirementPanel requirementPanel)
	{
		_requirements.remove(requirementPanel); // remove from list
		requirementsPanelContainer.remove(requirementPanel); // remove from panel
        revalidate();
        repaint();
	}
	
	public List<RequirementPanel> getRequirements()
	{
		return this._requirements;
	}

	public boolean isComplete()
	{
		return this._complete;
	}

	public void setCompleteTrue()
	{
		this._complete = true;
	}

	public void setCompleteFalse()
	{
		this._complete = false;
	}

	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		displayFrame.getContentPane().add(new TaskPanel("Test"));
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.setVisible(true);
	}
}
