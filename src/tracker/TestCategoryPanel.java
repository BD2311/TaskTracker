package tracker;

import org.junit.Test;
import static org.junit.Assert.*;

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
		categoryPanel.add(taskPanel);
		assertTrue(categoryPanel.getTasks().contains(taskPanel));
	}

	@Test
	public void testRemoveTaskPanel() 
	{
		CategoryPanel categoryPanel = new CategoryPanel("Test CategoryPanel");
		TaskPanel taskPanel1 = new TaskPanel("TaskPanel 1");
		TaskPanel taskPanel2 = new TaskPanel("TaskPanel 2");
		categoryPanel.add(taskPanel1);
		categoryPanel.add(taskPanel2);
		assertEquals(2, categoryPanel.getTasks().size());

		categoryPanel.remove(taskPanel1);
		assertEquals(1, categoryPanel.getTasks().size());
		assertFalse(categoryPanel.getTasks().contains(taskPanel1));
		assertTrue(categoryPanel.getTasks().contains(taskPanel2));
	}

	@Test
	public void testMoveTaskPanelToFromCategoryPanel() {
		CategoryPanel planningPanel = new CategoryPanel("Planned");
		CategoryPanel inProgressPanel = new CategoryPanel("Work in Progress");
		CategoryPanel finishedPanel = new CategoryPanel("Finished");

		TaskPanel homework = new TaskPanel("Homework");

		// Add task to planning panel
		planningPanel.add(homework);
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
	
	@Test
	public void testCategoryToString()
	{
		CategoryPanel inProgress = new CategoryPanel("In Progress");
		TaskPanel homework = new TaskPanel("Homework");
		RequirementPanel math = new RequirementPanel("Math");
		RequirementPanel english = new RequirementPanel("English");
		RequirementPanel history = new RequirementPanel("History");
		RequirementPanel science = new RequirementPanel("Science");
		
//		math.setComplete(true);
		homework.add(math);
		homework.add(english);
		homework.add(history);
		homework.add(science);
		inProgress.add(homework);
		
		System.out.println(inProgress);
	}
}
