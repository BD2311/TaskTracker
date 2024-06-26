package tracker;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.001
 * 
 * Responsibilities of class:
 * 
 * Represents a panel displaying a category information and scroll pane of tasks.
 * - Displaying the category header.
 * 
 */
@SuppressWarnings("serial")
public class CategoryPanel extends CustomPanel
{
	///// Fields /////

	private List<TaskPanel> _tasks = new ArrayList<TaskPanel>(); // List to store task panels
	private JPanel _tasksPanelContainer; // Container panel for task panels
	private JPanel _categoryHeader;

	///// Constructor /////

	/**
	 * Constructs a CategoryPanel object with name.
	 * 
	 * @param name The name of the category.
	 */
	public CategoryPanel(String name)
	{
		super(name);
		createPanel();
	}

	/**
	 * Constructs a CategoryPanel with name and reference to model.
	 * 
	 * @param name The name of the category.
	 * @param model The reference to the model
	 */
	public CategoryPanel(String name, TaskTrackerModel model)
	{
		super(name);
		this._model = model;
		createPanel();
	}

	///// Methods /////

	/**
	 * Initializes the user interface of the category panel.
	 */
	protected void createPanel()
	{

		this.setBorder(new TitledBorder("")); // Set border for separation purposes
		this.setLayout(new BorderLayout()); // Use border layout for components
		_categoryHeader = new JPanel();
		_categoryHeader.setLayout(new FlowLayout(FlowLayout.LEFT));

		// Create and configure category header
		JLabel categoryLabel = new JLabel(this.getName());
		_categoryHeader.add(categoryLabel);

		// Create container panel for task panels with vertical box layout
		_tasksPanelContainer = new JPanel();
		_tasksPanelContainer.setLayout((LayoutManager) new BoxLayout(_tasksPanelContainer, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(_tasksPanelContainer);
		scrollPane.setBorder(new TitledBorder("Tasks"));
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.getVerticalScrollBar().setBlockIncrement(64);

		// Add components to the category panel
		this.add(_categoryHeader, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);

		setVisible(true); // Make the category panel visible
	}

	/**
	 * Adds a task panel to the category.
	 * 
	 * @param taskPanel The task panel to be added.
	 */
	public void add(TaskPanel taskPanel)
	{
		taskPanel.setParentCategory(this);
		_tasks.add(taskPanel);
		_tasksPanelContainer.add(taskPanel);
		revalidate();
		repaint();
	}

	/**
	 * Removes a task panel from the category.
	 * 
	 * @param taskPanel The task panel to be removed.
	 */
	public void remove(TaskPanel taskPanel)
	{
		_tasks.remove(taskPanel);
		_tasksPanelContainer.remove(taskPanel);
		revalidate();
		repaint();
	}

	/**
	 * Gets the list of tasks in the category.
	 * 
	 * @return The list of tasks in the category.
	 */
	public List<TaskPanel> getTasks()
	{
		return this._tasks;
	}

	/**
	 * Gets status of all tasks in this Category
	 * 
	 * @return
	 */
	public String getStatusOfTasks()
	{
		StringBuilder listOfTasks = new StringBuilder();
		for (TaskPanel task : _tasks) 
		{
			listOfTasks.append(" > ").append(task.toString()).append("\n");
		}
		return listOfTasks.toString();
	}

	/**
	 * Gets the container panel for tasks.
	 * 
	 * @return The container panel for tasks.
	 */
	public JPanel getTasksPanelContainer()
	{
		return this._tasksPanelContainer;
	}

	/**
	 * Gets the categoryHeader of this
	 * 
	 * @return
	 */
	public JPanel getCategoryHeader()
	{
		return this._categoryHeader;
	}

	/**
	 * Moves a task panel to another category panel.
	 * 
	 * @param taskToMove The task panel to move.
	 * @param categoryToMoveTo The category panel to move the task panel to.
	 */
	public void moveTaskTo(TaskPanel taskToMove, CategoryPanel categoryToMoveTo)
	{
		this.remove(taskToMove); // Remove task from current panel
		categoryToMoveTo.add(taskToMove);
	}

	@Override
	public String toString()
	{
		return getName() + ":"
				+ "\n--------------------------------"
				+ "\n" + getStatusOfTasks();
	}

	/**
	 * Main method for testing the CategoryPanel class.
	 * - Tests visual representation of a Category
	 * - (Bug) Functionality conflicts with sort tasks method
	 * 
	 * @param args Command line arguments (unused).
	 */
	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		CategoryPanel testCategoryPanel = new CategoryPanel("Category");
		TaskPanel testTaskPanel = new TaskPanel("Task", testCategoryPanel);
		RequirementPanel testRequirementPanel = new RequirementPanel("Requirement", testTaskPanel);
		testTaskPanel.add(testRequirementPanel);
		testCategoryPanel.add(testTaskPanel);
		displayFrame.getContentPane().add(testCategoryPanel);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.show();
	}
}
