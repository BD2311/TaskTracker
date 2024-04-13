package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.10
 * 
 * Responsibilities of class: Allows creating Category objects, Category objects are effectively storages for a list of tasks 
 */
public class Category 
{
	///// Fields /////
	
	private String _categoryName;
	private List<Task> _tasks;
	
	///// Constructors /////
	
	public Category(String categoryName)
	{
		this._categoryName = categoryName;
		this._tasks = new ArrayList<Task>();
	}
	
	///// Methods /////
	
	public String getName()
	{
		return this._categoryName;
	}
	
	public void setName(String newName)
	{
		 this._categoryName = newName;
	}
	
	public List<Task> getTasks()
	{
		return this._tasks;
	}
	
	public void addTask(Task taskToAdd)
	{
		_tasks.add(taskToAdd);
	}
	
	public void removeTask(Task taskToRemove)
	{
		_tasks.remove(taskToRemove);
	}
	
	public void moveTaskToFromCategory(Task taskToMove, Category newCategory)
	{
		if(_tasks.contains(taskToMove))
		{
			_tasks.remove(taskToMove);
			newCategory.addTask(taskToMove);
		}
	}
}
