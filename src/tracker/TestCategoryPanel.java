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
		CategoryPanel CategoryPanel = new CategoryPanel("Test CategoryPanel");
		assertEquals("Test CategoryPanel", CategoryPanel.getName());
	}

	@Test
	public void testSetName()
	{
		CategoryPanel CategoryPanel = new CategoryPanel("Test CategoryPanel");
		CategoryPanel.setName("New CategoryPanel Name");
		assertEquals("New CategoryPanel Name", CategoryPanel.getName());
	}

	@Test
	public void testAddTaskPanel()
	{
		CategoryPanel CategoryPanel = new CategoryPanel("Test CategoryPanel");
		TaskPanel TaskPanel = new TaskPanel("Test TaskPanel");
		List<TaskPanel> TaskPanels = CategoryPanel.getTasks();
		assertEquals(0, TaskPanels.size());
		CategoryPanel.addTask(TaskPanel);
		assertEquals(1, TaskPanels.size());
		assertTrue(CategoryPanel.getTasks().contains(TaskPanel));
	}

	@Test
	public void testRemoveTaskPanel()
	{
		CategoryPanel CategoryPanel = new CategoryPanel("Test CategoryPanel");
		TaskPanel TaskPanel1 = new TaskPanel("TaskPanel 1");
		TaskPanel TaskPanel2 = new TaskPanel("TaskPanel 2");
		CategoryPanel.addTask(TaskPanel1);
		CategoryPanel.addTask(TaskPanel2);
		assertEquals(2, CategoryPanel.getTasks().size());

		CategoryPanel.removeTask(TaskPanel1);
		assertEquals(1, CategoryPanel.getTasks().size());
		assertFalse(CategoryPanel.getTasks().contains(TaskPanel1));
		assertTrue(CategoryPanel.getTasks().contains(TaskPanel2));
	}

	@Test
	public void testMoveTaskPanelToFromCategoryPanel()
	{
		CategoryPanel planningPanel = new CategoryPanel("Planned");
		CategoryPanel inProgressPanel = new CategoryPanel("Work in Progress");
		CategoryPanel finishedPanel = new CategoryPanel("Finished");

		TaskPanel homework = new TaskPanel("Homework");

		// Add task to planning panel
	    planningPanel.addTask(homework);
	    assertTrue(planningPanel.getTasks().contains(homework));

	    // Move task to in-progress panel
	    planningPanel.moveTaskTo(homework, inProgressPanel);
	    assertTrue(inProgressPanel.getTasks().contains(homework));
	    assertFalse(planningPanel.getTasks().contains(homework)); // Check if task is not in planning panel

	    // Move task to finished panel
	    inProgressPanel.moveTaskTo(homework, finishedPanel);
	    assertFalse(inProgressPanel.getTasks().contains(homework)); // Check if task is not in in-progress panel
	    assertTrue(finishedPanel.getTasks().contains(homework)); // Check if task is in finished panel
	}
}
