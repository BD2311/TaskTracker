package tracker;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.19.001
 * 
 * Responsibilities of class:
 * 
 * 
 */
public class RequirementPanel extends JPanel
{
	///// Fields /////
	
	private String _name;
	private boolean _complete; 
	
	///// Constructor /////
	
	public RequirementPanel(String requirementName)
	{
		this._name = requirementName;
		initializeUI();
	}
	
	///// Methods /////
	
	private void initializeUI()
	{
		JLabel requirementLabel = new JLabel(this._name);
		this.add(requirementLabel);
		
		JButton removeRequirementButton = new JButton("Remove");
		add(removeRequirementButton);
		
		JCheckBox requirementCheckbox = new JCheckBox();
		this.add(requirementCheckbox);
	
		setVisible(true);
	}
	
	/**
	 * Gets requirement name
	 * @return
	 */
	public String getName()
	{
		return this._name;
	}

}
