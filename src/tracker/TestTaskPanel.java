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
	public void testIfAllRequirementsComplete()
	{
		TaskPanel taskPanel = new TaskPanel("Test TaskPanel");
		RequirementPanel RequirementPanel = new RequirementPanel("Test RequirementPanel");
		RequirementPanel RequirementPanel2 = new RequirementPanel("Test RequirementPanel2");
		
//		taskPanel.add(RequirementPanel);
//		RequirementPanel.setCompleteTrue();
//		taskPanel.checkIfAllRequirementsComplete();
//		assertTrue(taskPanel.isComplete());
//		
//		taskPanel.add(RequirementPanel2);
//		taskPanel.checkIfAllRequirementsComplete();
//		assertFalse(taskPanel.isComplete());
//		RequirementPanel2.setCompleteTrue();
//		taskPanel.checkIfAllRequirementsComplete();
//		assertTrue(taskPanel.isComplete());
	}
}
