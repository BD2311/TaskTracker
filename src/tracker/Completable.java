package tracker;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.15.002
 * 
 * Responsibilities of interface:
 * 
 * Holds signatures for class that is completable
 * - Contains methods to get completion status
 * - Contains methods to set completion status
 * 
 */
public interface Completable 
{	
	/**
	 * Get the status depending on if this is complete
	 */
	public String getStatus();
	
	/**
	 * Checks if this is complete.
	 * 
	 * @return True if complete
	 */
	public boolean isComplete();
	
	/**
	 * Sets this to complete
	 * 
	 * @param complete True is complete, False is incomplete
	 */
	public void setComplete(boolean complete);
}
