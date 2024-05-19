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
	private static final Color PASTELBLUE = new Color(200,235,175);
	
	///// Constructors /////
	
	/**
	 * Constructs PersonalTaskPanel with given name.
	 * 
	 * @param name
	 */
	public PersonalTaskPanel(String name) 
	{
		super("Personal Task: " + name);
	}
	
	/**
	 * Constructs PersonalTaskPanel with given name and parentCategory.
	 * 
	 * @param name
	 * @param parentCategory
	 */
	public PersonalTaskPanel(String name, CategoryPanel parentCategory)
	{
		super("Personal Task: " + name, parentCategory);
	}
	
	/**
	 * Constructs PersonalTaskPanel with given name, parentCategory, and model.
	 * 
	 * @param name
	 * @param parentCategory
	 * @param model
	 */
	public PersonalTaskPanel(String name, CategoryPanel parentCategory, TaskTrackerModel model)
	{
		super("Personal Task: " + name, parentCategory, model);
	}
	
	///// Methods /////
	
	@Override
	protected void createPanel()
	{
		super.createPanel();
		
		setBackground(PASTELBLUE);
	}
}
