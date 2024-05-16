package tracker;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.001
 * 
 * Responsibilities of class: Holds logic for computing actions handeling task tracker
 */

public class TaskTrackerModel 
{
	///// Fields /////

	public CategoryPanel planningPanel;
	public CategoryPanel inProgressPanel;
	public CategoryPanel finishedPanel;

	///// Constructor /////

	public TaskTrackerModel()
	{
		planningPanel = new CategoryPanelWithAddTaskButton("Planning", this);
		inProgressPanel = new CategoryPanel("In Progress", this);
		finishedPanel = new CategoryPanel("Finished", this);
	}

	///// Methods /////

	public void sortTasks(TaskPanel taskToSort) 
	{
		if (taskToSort.isComplete()) 
		{
			// Task is already complete
			taskToSort.getParentCategory().moveTaskTo(taskToSort, finishedPanel);
			taskToSort.setParentCategory(finishedPanel);
			System.out.println(taskToSort.getName() + " has all requirements complete");
		} 
		else if (taskToSort.isPartiallyComplete()) 
		{
			// Task has at least one complete requirement but not all
			taskToSort.getParentCategory().moveTaskTo(taskToSort, inProgressPanel);
			taskToSort.setParentCategory(inProgressPanel);
			System.out.println(taskToSort.getName() + " has at least one complete requirement");
		} 
		else 
		{
			// Task has no complete requirements
			taskToSort.getParentCategory().moveTaskTo(taskToSort, planningPanel);
			taskToSort.setParentCategory(planningPanel);
			System.out.println(taskToSort.getName() + " has no requirements");
		}
	}
}
