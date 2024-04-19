package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.19.001
 * 
 * Responsibilities of class: Holds list of requirements, knows when it is complete if list of requirements are complete
 */
public class Task 
{
	///// Fields /////

	private String _taskName;
	private String _taskDescription;
	private boolean _complete;
	private List<Requirement> _requirements;

	///// Constructors /////

	public Task()
	{
	}
	
	public Task(String taskName)
	{
		this._taskName = taskName;
	}
	
	/**
	 * Task constructor to create task starting with name and description
	 * @param taskName
	 * @param taskDescription
	 */
	public Task(String taskName, String taskDescription)
	{
		this._taskName = taskName;
		this._taskDescription = taskDescription;
		this._complete = false; // By default a task will be not complete as it will start in the work in progress section
		this._requirements = new ArrayList<Requirement>(); // Requirements will be stored 
	}

	///// Methods /////
	
	/**
	 * Gets task name
	 * @return task name
	 */
	public String getName()
	{
		return this._taskName;
	}
	
	/**
	 * Set task name
	 * @param newTaskName
	 */
	public void setName(String newTaskName)
	{
		this._taskName = newTaskName;
	}
	
	/**
	 * Get task description
	 * @return task description
	 */
	public String getDescription()
	{
		return this._taskDescription;
	}
	
	/**
	 * Set task description
	 * @param newTaskDescription
	 */
	public void setTaskDescription(String newTaskDescription)
	{
		this._taskDescription = newTaskDescription;
	}

	/**
	 * Adds requirement to an existing task's list of requirements
	 * @param requirementToAdd
	 */
	public void addRequirement(Requirement requirementToAdd)
	{
		_requirements.add(requirementToAdd);
	}

	/**
	 * Removes requirement from an existing task's list of requirements
	 * @param requirementToRemove
	 */
	public void removeRequirement(Requirement requirementToRemove)
	{
		_requirements.remove(requirementToRemove);
	}

	/**
	 * Gets list of requirements from an existing task
	 * @return list of requirements
	 */
	public List<Requirement> getRequirements() 
	{
		return _requirements;
	}

	/**
	 * Checks if all requirements in a task's list of requirements is complete
	 * @return true if all requirements in list are complete, false if some requirements are incomplete
	 */
	public boolean isAllRequirementsComplete()
	{
		for(Requirement requirement : _requirements)
		{
			if(!requirement.isComplete())
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets status of complete
	 * @return true if complete, false if not complete
	 */
	public boolean isComplete()
	{
		return this._complete;
	}
	
	/**
	 * Sets task complete
	 */
	public void setComplete()
	{
		this._complete = true;
	}

}
