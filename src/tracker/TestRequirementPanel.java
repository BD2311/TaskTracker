package tracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRequirementPanel {

	@Test
	public void testSetComplete() 
	{
		RequirementPanel requirement = new RequirementPanel("test");
		assertFalse(requirement.isComplete());
		requirement.setCompleteTrue();
		assertTrue(requirement.isComplete());
	}

}
