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

@SuppressWarnings("serial")
public class CategoryPanel extends JPanel
{
	///// Fields /////

	private String _name = "Category";
	private List<TaskPanel> _tasks = new ArrayList<TaskPanel>();
	private JPanel _tasksPanelContainer;

	///// Constructor /////

	public CategoryPanel(String name)
	{
		this._name = name;
		initializeUI();
	}

	///// Methods /////

	private void initializeUI()
	{
		this.setBorder(new TitledBorder("Category"));
		this.setLayout(new BorderLayout());
		JPanel categoryHeader = new JPanel();
		categoryHeader.setLayout(new FlowLayout(FlowLayout.LEFT));

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
					add(new TaskPanel(taskName));
				}
			}
		});
		categoryHeader.add(addTaskButton);
		_tasksPanelContainer = new JPanel();
		_tasksPanelContainer.setLayout((LayoutManager) new BoxLayout(_tasksPanelContainer, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(_tasksPanelContainer);
		scrollPane.setBorder(new TitledBorder("Tasks"));

		this.add(categoryHeader, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	/**
	 * Adds task to tasks
	 * @param taskPanel
	 */
	public void add(TaskPanel taskPanel)
	{
		_tasks.add(taskPanel);
		_tasksPanelContainer.add(taskPanel);
		revalidate();
		repaint();
	}

	/**
	 * Removes task from tasks
	 * @param taskToRemove
	 */
	public void remove(TaskPanel taskPanel)
	{
		_tasks.remove(taskPanel);
		_tasksPanelContainer.remove(taskPanel);
		revalidate();
		repaint();
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
	
	public JPanel getTasksPanelContainer()
	{
		return this._tasksPanelContainer;
	}

	public void moveTaskTo(TaskPanel taskToMove, CategoryPanel categoryToMoveTo)
	{
		this.remove(taskToMove); // Remove task from current panel
		categoryToMoveTo.add(taskToMove);
	}

	@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
		JFrame displayFrame = new JFrame();
		CategoryPanel testCategoryPanel = new CategoryPanel("Category");
		TaskPanel testTaskPanel = new TaskPanel("Task");
		RequirementPanel testRequirementPanel = new RequirementPanel("Requirement");
		testTaskPanel.add(testRequirementPanel);
		testCategoryPanel.add(testTaskPanel);
		displayFrame.getContentPane().add(testCategoryPanel);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		displayFrame.pack();
		displayFrame.show();
	}
}
