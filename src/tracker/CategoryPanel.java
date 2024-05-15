package tracker;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.12.001
 * 
 * Responsibilities of class:
 * 
 * Represents a panel displaying a category information and scroll pane of tasks.
 * - Displaying the category header.
 * - Providing functionality to adding tasks
 * 
 */
@SuppressWarnings("serial")
public class CategoryPanel extends JPanel
{
	///// Fields /////

	private String _name = "Category"; // Default category name
	private List<TaskPanel> _tasks = new ArrayList<TaskPanel>(); // List to store task panels
	private JPanel _tasksPanelContainer; // Container panel for task panels

	///// Constructor /////

	/**
	 * Constructs a CategoryPanel object with the specified name.
	 * 
	 * @param name The name of the category.
	 */
	public CategoryPanel(String name)
	{
		this._name = name;
		initializeUI();
	}

	///// Methods /////

	/**
	 * Initializes the user interface of the category panel.
	 */
	private void initializeUI()
	{

		this.setBorder(new TitledBorder("Category")); // Set border with category name
		this.setLayout(new BorderLayout()); // Use border layout for components
		JPanel categoryHeader = new JPanel();
		categoryHeader.setLayout(new FlowLayout(FlowLayout.LEFT));

		// Create and configure category header
		JLabel categoryLabel = new JLabel(this._name);
		categoryHeader.add(categoryLabel);

		JButton addTaskButton = new JButton("New Task");
		addTaskButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String taskName = JOptionPane.showInputDialog("What is the name of your task?");
				if (taskName != null && !taskName.isEmpty()) 
				{
					add(new TaskPanel(taskName, CategoryPanel.this));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You must specify a name for a task.");
				}
			}
		});
		categoryHeader.add(addTaskButton);

		// Create container panel for task panels with vertical box layout
		_tasksPanelContainer = new JPanel();
		_tasksPanelContainer.setLayout((LayoutManager) new BoxLayout(_tasksPanelContainer, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(_tasksPanelContainer);
		scrollPane.setBorder(new TitledBorder("Tasks"));

		// Add components to the category panel
		this.add(categoryHeader, BorderLayout.NORTH);
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
     * Gets the name of the category.
     * 
     * @return The name of the category.
     */
	public String getName()
	{
		return this._name;
	}

	/**
     * Sets the name of the category.
     * 
     * @param newName The new name for the category.
     */
	public void setName(String newName)
	{
		this._name = newName;
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
     * Gets the container panel for tasks.
     * 
     * @return The container panel for tasks.
     */
	public JPanel getTasksPanelContainer()
	{
		return this._tasksPanelContainer;
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

	/**
     * Main method for testing the CategoryPanel class.
     * 
     * @param args Command line arguments (unused).
     */
	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		CategoryPanel testCategoryPanel = new CategoryPanel("Category");
		TaskPanel testTaskPanel = new TaskPanel("Task", testCategoryPanel);
		RequirementPanel testRequirementPanel = new RequirementPanel("Requirement");
		testTaskPanel.add(testRequirementPanel);
		testCategoryPanel.add(testTaskPanel);
		displayFrame.getContentPane().add(testCategoryPanel);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.show();
	}
}
