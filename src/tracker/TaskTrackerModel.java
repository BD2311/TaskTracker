package tracker;

import java.util.ArrayList;
import java.util.List;

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
	
	public void sortTasks(List<TaskPanel> allTasks)
	{
		allTasks = getAllTasks(); // Before sortingTasks get all tasks
		
		
	}

	/**
	 * 
	 * 
	 * @return all tasks within each CategoryPanel
	 */
	private List<TaskPanel> getAllTasks()
	{
		List<TaskPanel> allTasks = new ArrayList<TaskPanel>();
		allTasks.addAll(planningPanel.getTasks());
		allTasks.addAll(inProgressPanel.getTasks());
		allTasks.addAll(finishedPanel.getTasks());
		
		return allTasks;
	}
}
