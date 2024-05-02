package tracker;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

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
		JLabel requirementLabel = new JLabel(_requirement.getName());
		this.add(requirementLabel);
		
		JButton removeRequirementButton = new JButton("Remove");
		add(removeRequirementButton);
		
		JCheckBox requirementCheckbox = new JCheckBox();
		this.add(requirementCheckbox);
	
		setVisible(true);
	}
	
	public Requirement getRequirement()
	{
		return this._requirement;
	}
}
