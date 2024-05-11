package tracker;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class TaskScrollPane extends JScrollPane
{
	///// Fields /////
	
	private JPanel taskPanelContainer = new JPanel();
	private List<TaskPanel> _tasks = new ArrayList<TaskPanel>();
	
	///// Constructor /////
	
	TaskScrollPane()
	{
		initializeUI();
	}
	
	///// Methods /////
	
	public void initializeUI()
	{
		taskPanelContainer.setLayout((LayoutManager) new BoxLayout(taskPanelContainer, BoxLayout.Y_AXIS));
		setViewportView(taskPanelContainer);
		setBorder(new TitledBorder("Task List"));
		setVisible(true);
	}
	
	public void addTask(TaskPanel taskPanel) 
	{
		_tasks.add(taskPanel);
        taskPanelContainer.add(taskPanel);
        revalidate();
        repaint();
    }
	
	public void removeTask(TaskPanel taskPanel) 
	{
		_tasks.remove(taskPanel);
        taskPanelContainer.remove(taskPanel);
        revalidate();
        repaint();
    }
	
	public List<TaskPanel> getTaskPanels()
	{
		return this._tasks;
	}
}
