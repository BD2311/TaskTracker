package tracker;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class CategoryPanel extends JPanel
{
	///// Fields /////
	
	private String _name = "Category";
	private List<TaskPanel> _tasks = new ArrayList<TaskPanel>();
	
	///// Constructor /////
	
	public CategoryPanel(String name)
	{
		this._name = name;
		initializeUI();
	}
	
	///// Methods /////
	
	public void initializeUI()
	{
		JLabel categoryLabel = new JLabel(this._name);
		this.add(categoryLabel);
		
		JButton addTaskButton = new JButton("New Task");
		this.add(addTaskButton);
		
		setVisible(true);
	}
	
	/**
	 * Adds task to tasks
	 * @param taskPanel
	 */
	public void addTask(TaskPanel taskPanel)
	{
		this._tasks.add(taskPanel);
		this.add(taskPanel);
	}
	
	/**
	 * Removes task from tasks
	 * @param taskToRemove
	 */
	public void removeTask(TaskPanel taskToRemove)
	{
		_tasks.remove(taskToRemove);
	}
	
	/**
	 * Gets name of category
	 * @return
	 */
	public String getName()
	{
		return this._name;
	}
	
	/**
	 * Sets name of category
	 * @param newName
	 */
	public void setName(String newName)
	{
		 this._name = newName;
	}
	
	/**
	 * Gets list of tasks of category
	 * @return
	 */
	public List<TaskPanel> getTasks()
	{
		return this._tasks;
	}
	
	public void moveTaskTo(TaskPanel taskToMove, CategoryPanel categoryToMoveTo)
	{
		this.removeTask(taskToMove); // Remove task from current panel
	    categoryToMoveTo.addTask(taskToMove);
	}
	
}
