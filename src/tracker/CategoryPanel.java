package tracker;

import javax.swing.*;

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
	
	public Category getCategory()
	{
		return this._category;
	}
	
	public void initializeUI()
	{
		JLabel categoryLabel = new JLabel(_category.getName());
		this.add(categoryLabel);
	
		setVisible(true);
	}

	public static void main(String args[])
	{
		JFrame showCategoryPanel = new JFrame();
		Category testCategory = new Category("testCategory");
		CategoryPanel testCategoryPanel = new CategoryPanel(testCategory);
		showCategoryPanel.add(testCategoryPanel);
		showCategoryPanel.pack();
		showCategoryPanel.setVisible(true);
	}
}
