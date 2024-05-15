package tracker;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.19.001
 * 
 * Responsibilities of class: Holds logic for computing actions handeling task tracker
 */

public class TaskTrackerModel 
{
	///// Fields /////
	
	public CategoryPanel planningPanel = new CategoryPanel("Planning");
	public CategoryPanel inProgressPanel = new CategoryPanel("In Progress");
	public CategoryPanel finishedPanel = new CategoryPanel("Finished");
	
	///// Constructor /////
	
	public TaskTrackerModel()
	{
		
	}
	
	///// Methods /////
	
	public void moveCompleteTaskToFinishedPanel(TaskPanel completeTask)
	{
		
	}
}
