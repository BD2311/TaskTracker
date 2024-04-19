package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.19.001
 * 
 * Responsibilities of class: Allows creating Category objects, Category objects are effectively storages for a list of tasks 
 */
public class Category 
{
	///// Fields /////
	
	private String _categoryName;
	private List<Task> _tasks;
	
	///// Constructors /////
	
	/**
	 * Category constructor to create category with name
	 * @param categoryName
	 */
	public Category(String categoryName)
	{
		this._categoryName = categoryName;
		this._tasks = new ArrayList<Task>();
	}
	
	///// Methods /////
	
	/**
	 * Gets name of category
	 * @return
	 */
	public String getName()
	{
		return this._categoryName;
	}
	
	/**
	 * Sets name of category
	 * @param newName
	 */
	public void setName(String newName)
	{
		 this._categoryName = newName;
	}
	
	/**
	 * Gets list of tasks of category
	 * @return
	 */
	public List<Task> getTasks()
	{
		return this._tasks;
	}
	
	/**
	 * Adds task to category
	 * @param taskToAdd
	 */
	public void addTask(Task taskToAdd)
	{
		_tasks.add(taskToAdd);
	}
	
	/**
	 * Removes task from category
	 * @param taskToRemove
	 */
	public void removeTask(Task taskToRemove)
	{
		_tasks.remove(taskToRemove);
	}
	
	/**
	 * Moves task from this category to another
	 * @param taskToMove
	 * @param newCategory
	 */
	public void moveTaskFromToCategory(Task taskToMove, Category newCategory)
	{
		if(_tasks.contains(taskToMove))
		{
			_tasks.remove(taskToMove);
			newCategory.addTask(taskToMove);
		}
	}
}
