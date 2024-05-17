package tracker;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

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

	public TaskTrackerModel()
	{
		planningPanel = new CategoryPanelWithAddTaskButton("Planning", this);
		inProgressPanel = new CategoryPanel("In Progress", this);
		finishedPanel = new CategoryPanel("Finished", this);
	}

	///// Methods /////

	public void sortTasks(TaskPanel taskToSort) 
	{
		if (taskToSort.isComplete()) 
		{
			// Task is already complete
			taskToSort.getParentCategory().moveTaskTo(taskToSort, finishedPanel);
			taskToSort.setParentCategory(finishedPanel);
			System.out.println(taskToSort.toString());
			System.out.println(planningPanel.toString());
			System.out.println(inProgressPanel.toString());
			System.out.println(finishedPanel.toString());
		} 
		else if (taskToSort.isPartiallyComplete()) 
		{
			// Task has at least one complete requirement but not all
			taskToSort.getParentCategory().moveTaskTo(taskToSort, inProgressPanel);
			taskToSort.setParentCategory(inProgressPanel);
			System.out.println(taskToSort.toString());
			System.out.println(planningPanel.toString());
			System.out.println(inProgressPanel.toString());
			System.out.println(finishedPanel.toString());
		} 
		else 
		{
			// Task has no complete requirements
			taskToSort.getParentCategory().moveTaskTo(taskToSort, planningPanel);
			taskToSort.setParentCategory(planningPanel);
			System.out.println(taskToSort.toString());
			System.out.println(planningPanel.toString());
			System.out.println(inProgressPanel.toString());
			System.out.println(finishedPanel.toString());
		}
	}

	public void exportTasks()
	{
		try 
		{
			String fileName = "myTasks.txt";
			BufferedWriter outputWriter = new BufferedWriter(new FileWriter(fileName));
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
