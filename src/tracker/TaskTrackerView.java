package tracker;

import java.awt.BorderLayout;
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
		this.setLayout(new BorderLayout());

		CategoryPanel planningPanel = new CategoryPanel(_model.planningCategory);
		CategoryPanel inProgressPanel = new CategoryPanel(_model.inProgressCategory);
		CategoryPanel finishedPanel = new CategoryPanel(_model.finishedCategory);

		this.add(planningPanel, BorderLayout.WEST);
		this.add(inProgressPanel, BorderLayout.CENTER);
		this.add(finishedPanel, BorderLayout.EAST);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String args[])
	{
		new TaskTrackerView();
	}

}
