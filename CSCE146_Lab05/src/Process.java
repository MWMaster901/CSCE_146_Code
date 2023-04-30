/*
 * By Christopher Schweninger
 */
public class Process 
{
	private String Name;
	private double completeTime;
	//Constuctors
	public Process()
	{
		this.Name = "none";
		this.completeTime = 0.0;
	}
	public Process(String aName, double aTime)
	{
		this.setName(aName);
		this.setCompletionTime(aTime);
	}
	//Accessors
	public String getName()
	{
		return this.Name;
	}
	public double getCompletionTime()
	{
		return this.completeTime;
	}
	//Mutators
	public void setName(String aName)
	{
		if(aName != null)
			this.Name = aName;
		else
			return;
	}
	public void setCompletionTime(double aTime)
	{
		if(aTime >= 0.0)
			this.completeTime = aTime;
		else
			this.completeTime = 0.0;
	}
	//Other methods
	public String toString()
	{
		return "Process Name: "+this.Name+" Completion Time: "+this.completeTime;
	}
}
