package tracker;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.001
 * 
 * Responsibilities of class:
 * 
 * This class represents the view of the Task Tracker application. It is responsible for 
 * displaying the planning, in-progress, and finished panels of tasks.
 * 
 * The main method instantiates an object of this class, triggering the display of the Task Tracker UI.
 */
@SuppressWarnings("serial")
public class TaskTrackerView extends JFrame 
{
	///// Fields /////

	private TaskTrackerModel _model;

	///// Constructor /////

	/**
	 * Constructs a TaskTrackerView object with default settings.
	 */
	public TaskTrackerView() 
	{
		initializeUI(new TaskTrackerModel());
	}

	///// Methods /////

	/**
	 * Initializes the user interface of the Task Tracker.
	 * 
	 * @param model The TaskTrackerModel object representing the data model for the Task Tracker.
	 */
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

	/**
     * Calculates the minimum size of the Task Tracker window based on the preferred sizes
     * of its components.
     * 
     * @return The minimum size of the Task Tracker window.
     */
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
		width += 1000;
		height += 500;

		return new Dimension(width, height);
	}

	/**
     * The main method to instantiate and display the Task Tracker application.
     * 
     * @param args Command line arguments (unused).
     */
	public static void main(String args[]) 
	{
		new TaskTrackerView();
	}
}
