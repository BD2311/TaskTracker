package tracker;

import java.util.List;

import javax.swing.JList;
import javax.swing.border.TitledBorder;

public class TaskPanelList extends JList
{
	TaskPanelList(List<TaskPanel> listOfTasks)
	{
		initializeUI();
	}
	
	public void initializeUI()
	{
		this.setBorder(new TitledBorder("Task List"));
		
		setVisible(true);
	}
}
