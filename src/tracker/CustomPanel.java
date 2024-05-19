package tracker;

import javax.swing.JPanel;

/**
 * Lead Author(s):
 * @author Branden Della bdella@email.com
 * 
 * Version/date: 2024.05.18.001
 * 
 * Responsibilities of class:
 * 
 * Contains functional methods and signatures for creating a custom panel to use in the view.
 * 
 */
@SuppressWarnings("serial")
public abstract class CustomPanel extends JPanel
{
	private String _name;
	protected TaskTrackerModel _model; // Reference to the model
	
	public CustomPanel(String name)
	{
		this._name = name;
	}
	
	/**
	 * Creates the user panel.
	 */
	protected abstract void createPanel();
	
	/**
	 * Gets the name.
	 */
	public String getName()
	{
		return this._name;
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param newName
	 */
	public void setName(String newName)
	{
		this._name = newName;
	}
	
	/**
	 * Gets the model.
	 * 
	 * @return model
	 * @throws ModelNotFoundException Throw exception if model is null
	 */
	public TaskTrackerModel getModel() throws ModelNotFoundException
	{
		if(this._model == null)
			throw new ModelNotFoundException();
		return this._model;
	}
}
