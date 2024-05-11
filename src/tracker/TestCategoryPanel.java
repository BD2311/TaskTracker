package tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class TestCategoryPanel 
{

	@Test
	public void testGetName() 
	{
		CategoryPanel categoryPanel = new CategoryPanel("Test CategoryPanel");
		assertEquals("Test CategoryPanel", categoryPanel.getName());
	}

	@Test
	public void testSetName() 
	{
		CategoryPanel categoryPanel = new CategoryPanel("Test CategoryPanel");
		categoryPanel.setName("New CategoryPanel Name");
		assertEquals("New CategoryPanel Name", categoryPanel.getName());
	}

	@Test
	public void testAddTaskPanel() 
	{
		CategoryPanel categoryPanel = new CategoryPanel("Test CategoryPanel");
		TaskPanel taskPanel = new TaskPanel("Test TaskPanel");
		categoryPanel.addTask(taskPanel);
		assertTrue(categoryPanel.getTaskScrollPane().getTaskPanels().contains(taskPanel));
	}

	@Test
	public void testRemoveTaskPanel() 
	{
		CategoryPanel categoryPanel = new CategoryPanel("Test CategoryPanel");
		TaskPanel taskPanel1 = new TaskPanel("TaskPanel 1");
		TaskPanel taskPanel2 = new TaskPanel("TaskPanel 2");
		categoryPanel.addTask(taskPanel1);
		categoryPanel.addTask(taskPanel2);
		assertEquals(2, categoryPanel.getTaskScrollPane().getTaskPanels().size());

		categoryPanel.removeTask(taskPanel1);
		assertEquals(1, categoryPanel.getTaskScrollPane().getTaskPanels().size());
		assertFalse(categoryPanel.getTaskScrollPane().getTaskPanels().contains(taskPanel1));
		assertTrue(categoryPanel.getTaskScrollPane().getTaskPanels().contains(taskPanel2));
	}

	@Test
	public void testMoveTaskPanelToFromCategoryPanel() {
		CategoryPanel planningPanel = new CategoryPanel("Planned");
		CategoryPanel inProgressPanel = new CategoryPanel("Work in Progress");
		CategoryPanel finishedPanel = new CategoryPanel("Finished");

		TaskPanel homework = new TaskPanel("Homework");

		// Add task to planning panel
		planningPanel.addTask(homework);
		assertTrue(planningPanel.getTaskScrollPane().getTaskPanels().contains(homework));

		// Move task to in-progress panel
		planningPanel.moveTaskTo(homework, inProgressPanel);
		assertTrue(inProgressPanel.getTaskScrollPane().getTaskPanels().contains(homework));
		assertFalse(planningPanel.getTaskScrollPane().getTaskPanels().contains(homework)); // Check if task is not in planning panel

		// Move task to finished panel
		inProgressPanel.moveTaskTo(homework, finishedPanel);
		assertFalse(inProgressPanel.getTaskScrollPane().getTaskPanels().contains(homework)); // Check if task is not in in-progress panel
		assertTrue(finishedPanel.getTaskScrollPane().getTaskPanels().contains(homework)); // Check if task is in finished panel
	}
}
