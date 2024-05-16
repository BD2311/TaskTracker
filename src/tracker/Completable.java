package tracker;

public interface Completable 
{
	public String getStatus();
	
	public boolean isComplete();
	
	public void setComplete(boolean complete);
}
