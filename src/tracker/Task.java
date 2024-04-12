package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.10
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
	 * gets task name
	 * @return task name
	 */
	public String getName()
	{
		return this._taskName;
	}
	
	/**
	 * set task name
	 * @param newTaskName
	 */
	public void setName(String newTaskName)
	{
		this._taskName = newTaskName;
	}
	
	/**
	 * get task description
	 * @return task description
	 */
	public String getDescription()
	{
		return this._taskDescription;
	}
	
	/**
	 * set task description
	 * @param newTaskDescription
	 */
	public void setTaskDescription(String newTaskDescription)
	{
		this._taskDescription = newTaskDescription;
	}

	/**
	 * adds requirement to an existing task's list of requirements
	 * @param requirementToAdd
	 */
	public void addRequirement(Requirement requirementToAdd)
	{
		_requirements.add(requirementToAdd);
	}

	/**
	 * removes requirement from an existing task's list of requirements
	 * @param requirementToRemove
	 */
	public void removeRequirement(Requirement requirementToRemove)
	{
		_requirements.remove(requirementToRemove);
	}

	/**
	 * gets list of requirements from an existing task
	 * @return list of requirements
	 */
	public List<Requirement> getRequirements() 
	{
		return _requirements;
	}

	/**
	 * checks if all requirements in a task's list of requirements is complete
	 * @return true if all requirements in list are complete, false if some requirements are incomplete
	 */
	public boolean checkIfAllRequirementsAreComplete()
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
	 * manually sets a task complete
	 */
	public void setComplete()
	{
		this._complete = true;
	}
	
	/**
	 * checks if a task is complete
	 * @return true if complete, false if not complete
	 */
	public boolean checkComplete()
	{
		return this._complete;
	}

}
