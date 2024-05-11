package tracker;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TaskTrackerView extends JFrame {
	///// Fields /////

	private TaskTrackerModel _model;

	///// Constructor /////

	public TaskTrackerView() 
	{
		initializeUI(new TaskTrackerModel());
	}

	///// Methods /////

	private void initializeUI(TaskTrackerModel model)
	{
		this._model = model;
		this.setLayout(new GridLayout());

		this.add(_model.planningPanel);
		this.add(_model.inProgressPanel);
		this.add(_model.finishedPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(calculateMinimumSize());
		setVisible(true);
	}

	private Dimension calculateMinimumSize() 
	{
		int width = 0;
		int height = 0;

		// Calculate the total preferred width and maximum preferred height
		for (Component component : getContentPane().getComponents()) 
		{
			Dimension preferredSize = component.getPreferredSize();
			width += preferredSize.width;
			height = Math.max(height, preferredSize.height);
		}

		// Add some padding (e.g., 20 pixels) to the width and height
		width += 20;
		height += 20;

		return new Dimension(width, height);
	}

	public static void main(String args[]) 
	{
		new TaskTrackerView();
	}
}
