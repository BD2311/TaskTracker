package tracker;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CategoryPanel extends JPanel
{
	///// Fields /////
	
	private Category _category;
	
	///// Constructor /////
	
	public CategoryPanel(Category category)
	{
		this._category = category;
		initializeUI();
	}
	
	///// Methods /////
	
	public void initializeUI()
	{
		JLabel categoryLabel = new JLabel(_category.getName());
		this.add(categoryLabel);
		
		JButton addTaskButton = new JButton("New Task");
		this.add(addTaskButton);
		
		Requirement testRequirement = new Requirement("Test");
		RequirementPanel testRequirementPanel = new RequirementPanel(testRequirement);
		this.add(testRequirementPanel);
	
		setVisible(true);
	}
	
	public Category getCategory()
	{
		return this._category;
	}
}
