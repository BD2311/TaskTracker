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
public class PersonalTaskPanel extends TaskPanel
{
	///// Constructors /////
	
	public PersonalTaskPanel(String name) 
	{
		super("Personal Task: " + name);
	}
	
	public PersonalTaskPanel(String name, CategoryPanel parentCategory)
	{
		super("Personal Task: " + name, parentCategory);
	}
	
	public PersonalTaskPanel(String name, CategoryPanel parentCategory, TaskTrackerModel model)
	{
		super("Personal Task: " + name, parentCategory, model);
	}
	
	///// Methods /////
	
	@Override
	protected void initializeUI()
	{
		super.initializeUI();
		
		setBackground(new Color(200,235,175));
	}
}
