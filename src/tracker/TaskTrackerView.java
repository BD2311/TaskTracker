package tracker;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class TaskTrackerView extends JFrame
{
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
		setVisible(true);
	}

	public static void main(String args[])
	{
		new TaskTrackerView();
	}

}
