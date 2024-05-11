package tracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTaskPanel
{
	@Test
	public void testSetGetTaskPanelName()
	{
		TaskPanel TaskPanel = new TaskPanel("Games");
		TaskPanel.setName("Homework");
		assertEquals("Homework",TaskPanel.getName());
	}

	@Test
	public void testAddRequirementPanel() 
	{
		TaskPanel TaskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");

		TaskPanel.add(RequirementPanel);

		assertTrue(TaskPanel.getRequirements().contains(RequirementPanel));
	}

	@Test
	public void testRemoveRequirementPanel() 
	{
		TaskPanel TaskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");

		TaskPanel.add(RequirementPanel);
		TaskPanel.remove(RequirementPanel);

		assertFalse(TaskPanel.getRequirements().contains(RequirementPanel));
	}
}
