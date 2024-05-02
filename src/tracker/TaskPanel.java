package tracker;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

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
		
		JButton addRequirementButton = new JButton("New Requirement");
		this.add(addRequirementButton);
		
		setVisible(true);
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
		displayFrame.add(new TaskPanel("Test"));
		displayFrame.show();
	}
}
