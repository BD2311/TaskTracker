package tracker;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RequirementPanel extends JPanel
{
	///// Fields /////
	
	private Requirement _requirement;
	
	///// Constructor /////
	
	public RequirementPanel(Requirement requirement)
	{
		this._requirement = requirement;
		initializeUI();
	}
	
	///// Methods /////
	
	private void initializeUI()
	{
		JLabel categoryLabel = new JLabel(_requirement.getName());
		this.add(categoryLabel);
	
		setVisible(true);
	}
}
