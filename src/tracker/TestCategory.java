package tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class TestCategory {

	@Test
	public void testGetName()
	{
		Category category = new Category("Test Category");
		assertEquals("Test Category", category.getName());
	}

	@Test
	public void testSetName()
	{
		Category category = new Category("Test Category");
		category.setName("New Category Name");
		assertEquals("New Category Name", category.getName());
	}

	@Test
	public void testAddTask()
	{
		Category category = new Category("Test Category");
		Task task = new Task("Test Task", "Description");
		category.addTask(task);
		List<Task> tasks = category.getTasks();
		assertEquals(1, tasks.size());
		assertTrue(category.getTasks().contains(task));
	}

	@Test
	public void testRemoveTask()
	{
		Category category = new Category("Test Category");
		Task task1 = new Task("Task 1", "Description");
		Task task2 = new Task("Task 2", "Description");
		category.addTask(task1);
		category.addTask(task2);
		assertEquals(2, category.getTasks().size());

		category.removeTask(task1);
		assertEquals(1, category.getTasks().size());
		assertFalse(category.getTasks().contains(task1));
		assertTrue(category.getTasks().contains(task2));
	}

	@Test
	public void testMoveTaskToFromCategoryToNewCategory()
	{
		Category plannedCategory = new Category("Planned");
		Category workInProgressCategory = new Category("Work in Progress");
		Category finishedCategory = new Category("Finished");

		Task homework = new Task("Homework","Calculus 3, Problem 2");

		plannedCategory.addTask(homework);
		assertTrue(plannedCategory.getTasks().contains(homework));
		plannedCategory.moveTaskToFromCategoryToNewCategory(homework, workInProgressCategory);
		assertFalse(plannedCategory.getTasks().contains(homework));
		assertTrue(workInProgressCategory.getTasks().contains(homework));
		workInProgressCategory.moveTaskToFromCategoryToNewCategory(homework, finishedCategory);
		assertFalse(workInProgressCategory.getTasks().contains(homework));
		assertTrue(finishedCategory.getTasks().contains(homework));
	}


}
