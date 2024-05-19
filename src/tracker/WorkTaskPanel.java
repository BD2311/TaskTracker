package tracker;

import java.awt.Color;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.001
 * 
 * Responsibilities of class:
 * 
 * Represents a panel displaying a task information and scroll pane of requirements.
 * - Use inheritence to construct Task with prefix "Work Task: " +  name
 * 
 */
@SuppressWarnings("serial")
public class WorkTaskPanel extends TaskPanel
{
	public WorkTaskPanel(String name) 
	{
		super("Work Task: " + name);
	}
	
	public WorkTaskPanel(String name, CategoryPanel parentCategory)
	{
		super("Work Task: " + name, parentCategory);
	}
	
	public WorkTaskPanel(String name, CategoryPanel parentCategory, TaskTrackerModel model)
	{
		super("Work Task: " + name, parentCategory, model);
	}
	
	@Override
	protected void createPanel()
	{
		super.createPanel();
		
		setBackground(new Color(175,200,235));
	}
}
