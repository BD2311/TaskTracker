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
		taskPanel.setComplete(taskPanel.checkIfAllRequirementsAreComplete()); // Set complete if all reqs are complete
		assertFalse(taskPanel.isComplete());
		RequirementPanel.setComplete(true);
		taskPanel.setComplete(taskPanel.checkIfAllRequirementsAreComplete()); // Set complete if all reqs are complete
		assertTrue(taskPanel.isComplete());
	}
}
