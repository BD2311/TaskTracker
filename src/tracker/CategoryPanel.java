package tracker;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CategoryPanel extends JPanel
{
	///// Fields /////

	private String _name = "Category";
	private TaskScrollPane _taskScrollPane;

	///// Constructor /////

	public CategoryPanel(String name)
	{
		this._name = name;
		initializeUI();
	}

	///// Methods /////

	public void initializeUI()
	{
		this.setBorder(new TitledBorder("Category"));
		this.setLayout(new BorderLayout());
		JPanel categoryHeader = new JPanel();

		JLabel categoryLabel = new JLabel(this._name);
		categoryHeader.add(categoryLabel);

		JButton addTaskButton = new JButton("New Task");
		addTaskButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent buttonPressed)
			{
				String taskName = JOptionPane.showInputDialog("What is the name of your task?");
				if (taskName != null && !taskName.isEmpty())
				{
					CategoryPanel.this.addTask(new TaskPanel(taskName));
					CategoryPanel.this.revalidate();
					CategoryPanel.this.repaint();
				}
			}
		});
		categoryHeader.add(addTaskButton);
		_taskScrollPane = new TaskScrollPane();
		
		this.add(categoryHeader, BorderLayout.NORTH);
		this.add(_taskScrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	/**
	 * Adds task to tasks
	 * @param taskPanel
	 */
	public void addTask(TaskPanel taskPanel)
	{
		_taskScrollPane.addTask(taskPanel);
	}

	/**
	 * Removes task from tasks
	 * @param taskToRemove
	 */
	public void removeTask(TaskPanel taskToRemove)
	{
		_taskScrollPane.removeTask(taskToRemove);
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
	public TaskScrollPane getTaskScrollPane()
	{
		return this._taskScrollPane;
	}

	public void moveTaskTo(TaskPanel taskToMove, CategoryPanel categoryToMoveTo)
	{
		this.removeTask(taskToMove); // Remove task from current panel
		categoryToMoveTo.addTask(taskToMove);
	}

	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		CategoryPanel testCategoryPanel = new CategoryPanel("Category");
		TaskPanel testTaskPanel = new TaskPanel("Task");
		RequirementPanel testRequirementPanel = new RequirementPanel("Requirement");
		testTaskPanel.addRequirement(testRequirementPanel);
		testCategoryPanel.addTask(testTaskPanel);
		displayFrame.getContentPane().add(testCategoryPanel);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.show();
	}

}
