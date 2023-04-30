/*
 * By Christopher Schweninger
 */
public class sheep implements Comparable<sheep>
{
	private String name;
	private int sheerTime;
	private int sheerTimeLeft;
	private int arrivalTime;
	//Constructors
	public sheep()
	{
		this.setName("None");
		this.setSheerTime(1);
		this.setArrivalTime(0);
	}
	public sheep(String aName, int aSheerTime, int aArrivalTime)
	{
		this.setName(aName);
		this.setSheerTime(aSheerTime);
		this.setArrivalTime(aArrivalTime);
	}
	//Mutators
	public void setName(String aName)
	{
		if(aName == null)
			this.name = "None";
		else
			this.name = aName;
	}
	public void setSheerTime(int aSheerTime)
	{
		if(aSheerTime <= 0)
		{
			this.sheerTime = 1;
			this.sheerTimeLeft = sheerTime;
		}
		else
		{
			this.sheerTime = aSheerTime;
			this.sheerTimeLeft = sheerTime;
		}
	}
	public void setArrivalTime(int aArrivalTime)
	{
		if(aArrivalTime < 0)
			this.arrivalTime = 0;
		else
			this.arrivalTime = aArrivalTime;
	}
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public int getSheerTime()
	{
		return this.sheerTime;
	}
	public int getSheerTimeLeft()
	{
		return this.sheerTimeLeft;
	}
	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	//Other Methods
	//This returns the vital information for this sheep
	public String toString()
	{
		return "Name: "+this.name+", Sheer Time: "+this.sheerTime+", Arrival Time: "+this.arrivalTime;
	}
	//Compares the sheer time first, then the name. Favors the smaller of the two
	public int compareTo(sheep aSheep)
	{
		if(this.sheerTime > aSheep.getSheerTime())
			return 1;
		else if(this.sheerTime < aSheep.getSheerTime())
			return -1;
		else
		{
			if(this.name.compareToIgnoreCase(aSheep.getName()) != 0)
				return -(this.name.compareToIgnoreCase(aSheep.getName()));
			else
				return 0;
		}
	}
	//This compares arrival time.
	public int compareArrivalTime(sheep aSheep)
	{
		if(this.arrivalTime < aSheep.getArrivalTime())
			return 1;
		else if(this.arrivalTime > aSheep.getArrivalTime())
			return -1;
		else 
			return 0;
	}
	//Advances the shearing by one time unit
	public void sheerForOneTimeUnit()
	{
		this.sheerTimeLeft--;
	}
	//Returns true if this sheep has finished being sheared
	public boolean isDone()
	{
		if(this.sheerTimeLeft <= 0)
			return true;
		else
			return false;
	}
}
