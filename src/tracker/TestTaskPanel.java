package tracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTaskPanel
{
	@Test
	public void testSetGetTaskPanelName()
	{
		TaskPanel TaskPanel = new TaskPanel();
		TaskPanel.setName("Homework");
		assertEquals("Homework",TaskPanel.getName());
	}

	@Test
	public void testAddRequirementPanel() 
	{
		TaskPanel TaskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");

		TaskPanel.addRequirementPanel(RequirementPanel);

		assertTrue(TaskPanel.getRequirements().contains(RequirementPanel));
	}

	@Test
	public void testRemoveRequirementPanel() 
	{
		TaskPanel TaskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");

		TaskPanel.addRequirementPanel(RequirementPanel);
		TaskPanel.removeRequirementPanel(RequirementPanel);

		assertFalse(TaskPanel.getRequirements().contains(RequirementPanel));
	}
}
