package tracker;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class TaskPanel extends JPanel
{
	///// Fields /////
	
	private String _name;
	private boolean _complete;
	private List<RequirementPanel> _requirements = new ArrayList<RequirementPanel>();
	
	///// Constructor /////
	
	public TaskPanel()
	{
		initializeUI();
	}
	
	public TaskPanel(String name)
	{
		this._name = name;
		initializeUI();
	}
	
	///// Methods /////
	
	private void initializeUI()
	{
		JLabel taskLabel = new JLabel(this._name);
		this.add(taskLabel);
		
		JButton addRequirementButton = new JButton("New Requirement");
		this.add(addRequirementButton);
		
		RequirementPanel testRequirement = new RequirementPanel("Test");
		this.addRequirementPanel(testRequirement);
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
	
	public void addRequirementPanel(RequirementPanel requirementPanel)
	{
		this._requirements.add(requirementPanel); // Add requirementPanel's requirement to TaskPanel's task
		this.add(requirementPanel);
	}
	
	public void removeRequirementPanel(RequirementPanel requirementPanel)
	{
		this._requirements.remove(requirementPanel);
		this.remove(requirementPanel);
	}
	
	public List<RequirementPanel> getRequirements()
	{
		return this._requirements;
	}
}
