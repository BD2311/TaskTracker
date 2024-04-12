package tracker;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.10
 * 
 * Responsibilities of class: Allows creating Requirement objects, Requirements are effectively check boxes
 */
public class Requirement 
{
	///// Fields /////

	private String _requirementName;
	private boolean _complete; 

	///// Constructors /////
	
	public Requirement(String requirementName)
	{
		this._requirementName = requirementName;
		this._complete = false; // By default a requirement is not complete
	}

	///// Methods /////
	
	public String getRequirementName()
	{
		return this._requirementName;
	}

	public boolean isComplete()
	{
		return this._complete;
	}
	
	public void setComplete()
	{
		this._complete = true;
	}
}
