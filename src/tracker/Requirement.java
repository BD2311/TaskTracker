package tracker;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.04.19.001
 * 
 * Responsibilities of class: Allows creating Requirement objects, Requirements are effectively check boxes
 */
public class Requirement 
{
	///// Fields /////

	private String _requirementName;
	private boolean _complete; 

	///// Constructors /////
	
	/**
	 * Requirement constructor to create requirement with name
	 * @param requirementName
	 */
	public Requirement(String requirementName)
	{
		this._requirementName = requirementName;
		this._complete = false; // By default a requirement is not complete
	}

	///// Methods /////
	
	/**
	 * Gets requirement name
	 * @return
	 */
	public String getName()
	{
		return this._requirementName;
	}

	/**
	 * Gets status of complete
	 * @return true if complete, false if not complete
	 */
	public boolean isComplete()
	{
		return this._complete;
	}
	
	/**
	 * Sets complete to true
	 */
	public void setComplete()
	{
		this._complete = true;
	}
}
