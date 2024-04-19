package tracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTask 
{
	@Test
	public void testSetGetTaskName()
	{
		Task task = new Task();
		task.setName("Homework");

		assertEquals("Homework",task.getName());
	}

	@Test
	public void testSetGetTaskDescription()
	{
		Task task = new Task();
		task.setTaskDescription("Calculus 3, Triple Integrals");

		assertEquals("Calculus 3, Triple Integrals",task.getDescription());
	}

	@Test
	public void testAddRequirement() 
	{
		Task task = new Task("Test Task", "Description");
		Requirement requirement = new Requirement("Test Requirement");

		task.addRequirement(requirement);

		assertTrue(task.getRequirements().contains(requirement));
	}

	@Test
	public void testRemoveRequirement() 
	{
		Task task = new Task("Test Task", "Description");
		Requirement requirement = new Requirement("Test Requirement");

		task.addRequirement(requirement);
		task.removeRequirement(requirement);

		assertFalse(task.getRequirements().contains(requirement));
	}

	@Test
	public void testCheckIfAllRequirementsComplete()
	{
		Task task = new Task("Test Task", "Description");
		Requirement requirement1 = new Requirement("Test Requirement");
		Requirement requirement2 = new Requirement("Test Requirement");

		task.addRequirement(requirement1);
		task.addRequirement(requirement2);

		assertFalse(task.isAllRequirementsComplete());	

		requirement1.setComplete();
		assertFalse(task.isAllRequirementsComplete());		

		requirement1.setComplete();
		assertFalse(task.isAllRequirementsComplete());	

		requirement2.setComplete();
		assertTrue(task.isAllRequirementsComplete());
	}

	@Test
	public void testSetComplete()
	{
		Task task1 = new Task("Test Task1", "Description");
		Task task2 = new Task("Test Task1", "Description");
		Requirement requirement1 = new Requirement("Test Requirement");

		assertFalse(task1.isComplete());

		task1.setComplete();

		assertTrue(task1.isComplete());

		assertFalse(task2.isComplete());
	}
}
