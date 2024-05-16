package tracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTaskPanel
{
	@Test
	public void testSetGetTaskPanelName()
	{
		TaskPanel taskPanel = new TaskPanel("Games");
		taskPanel.setName("Homework");
		assertEquals("Homework",taskPanel.getName());
	}

	@Test
	public void testAddRequirementPanel() 
	{
		TaskPanel taskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");
		taskPanel.add(RequirementPanel);
		assertTrue(taskPanel.getRequirements().contains(RequirementPanel));
	}

	@Test
	public void testRemoveRequirementPanel() 
	{
		TaskPanel taskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");

		taskPanel.add(RequirementPanel);
		taskPanel.remove(RequirementPanel);

		assertFalse(taskPanel.getRequirements().contains(RequirementPanel));
	}

	@Test
	public void testCheckIfAllRequirementsComplete()
	{
		TaskPanel taskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");

		taskPanel.add(RequirementPanel);
		if(taskPanel.checkIfAllRequirementsAreComplete()) // If all requirements are complete, set task to complete
			taskPanel.setComplete(true);
		assertFalse(taskPanel.isComplete());
		RequirementPanel.setComplete(true);
		if(taskPanel.checkIfAllRequirementsAreComplete()) // If all requirements are complete, set task to complete
			taskPanel.setComplete(true);
		assertTrue(taskPanel.isComplete());
	}
}
