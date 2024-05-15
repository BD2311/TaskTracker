package tracker;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.12.001
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
public class WorkTaskPanel extends TaskPanel
{

	///// Fields /////

	///// Constructor /////
	
	public WorkTaskPanel(String name) 
	{
		super("Work Task: " + name);
	}
	
	public WorkTaskPanel(String name, CategoryPanel parentCategory, TaskTrackerModel model)
	{
		super("Work Task: " + name);
	}

	///// Methods /////

	
}
