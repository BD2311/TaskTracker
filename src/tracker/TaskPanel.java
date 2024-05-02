package tracker;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class TaskPanel extends JPanel
{
	///// Fields /////
	
	private Task _task;
	
	///// Constructor /////
	
	public TaskPanel(Task task)
	{
		this._task = task;
		initializeUI();
	}
	
	///// Methods /////
	
	private void initializeUI()
	{
		JLabel taskLabel = new JLabel(_task.getName());
		this.add(taskLabel);
		
		JButton addRequirementButton = new JButton("New Requirement");
		this.add(addRequirementButton);
	}
	
	public void addRequirementPanel(RequirementPanel requirementPanel)
	{
		this._task.addRequirement(requirementPanel.getRequirement()); // Add requirementPanel's requirement to TaskPanel's task
		this.add(requirementPanel);
	}
	
	public Task getTask()
	{
		return this._task;
	}
}
