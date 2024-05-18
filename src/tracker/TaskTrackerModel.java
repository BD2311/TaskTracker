package tracker;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.001
 * 
 * Responsibilities of class: Holds logic for computing actions handeling task tracker
 */
public class TaskTrackerModel 
{
	///// Fields /////

	public CategoryPanel planningPanel;
	public CategoryPanel inProgressPanel;
	public CategoryPanel finishedPanel;

	///// Constructor /////

	/**
	 * Constructs the model of 
	 */
	public TaskTrackerModel()
	{
		planningPanel = new CategoryPanelWithAddTaskButton("Planning", this);
		inProgressPanel = new CategoryPanel("In Progress", this);
		finishedPanel = new CategoryPanel("Finished", this);
	}

	///// Methods /////

	public void sortTasks(TaskPanel taskToSort) 
	{
		if (taskToSort.isComplete()) // If a task is complete
		{
			taskToSort.getParentCategory().moveTaskTo(taskToSort, finishedPanel);
			taskToSort.setParentCategory(finishedPanel);
			System.out.println(taskToSort.toString());
			System.out.println(planningPanel.toString());
			System.out.println(inProgressPanel.toString());
			System.out.println(finishedPanel.toString());
		} 
		else if (taskToSort.isPartiallyComplete()) // If a task has atleast one complete requirement
		{
			taskToSort.getParentCategory().moveTaskTo(taskToSort, inProgressPanel);
			taskToSort.setParentCategory(inProgressPanel);
			System.out.println(taskToSort.toString());
			System.out.println(planningPanel.toString());
			System.out.println(inProgressPanel.toString());
			System.out.println(finishedPanel.toString());
		} 
		else // Task has no complete requirements
		{
			taskToSort.getParentCategory().moveTaskTo(taskToSort, planningPanel);
			taskToSort.setParentCategory(planningPanel);
			System.out.println(taskToSort.toString());
			System.out.println(planningPanel.toString());
			System.out.println(inProgressPanel.toString());
			System.out.println(finishedPanel.toString());
		}
	}

	/**
	 * Creates a text file where it writes and displays the categories
	 */
	public void exportTasks()
	{
		try 
		{
			String fileName = "myTasks.txt";
			String currentDate = new SimpleDateFormat("yyyy.MM.dd HH.mm").format(new Date());
			BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileName));
			outputWriter.write("myTasks exported on: " + currentDate + "\n");
			outputWriter.write(planningPanel.toString());
			outputWriter.write(inProgressPanel.toString());
			outputWriter.write(finishedPanel.toString());
			outputWriter.close();

			// Open the file after writing
			File file = new File(fileName);
			if (Desktop.isDesktopSupported()) 
			{
				Desktop desktop = Desktop.getDesktop();
				if (file.exists()) 
				{
					desktop.open(file);
				}
			} 
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
