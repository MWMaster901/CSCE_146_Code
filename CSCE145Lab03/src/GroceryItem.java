/*
 * By Christopher Schweninger
 */
public class GroceryItem {

	//Two instance variables
	private String name;
	private double value;
	//Default and parameterized constructor
	public GroceryItem ()
	{
		this.name = "none";
		this.value = 0.0;
	}
	public GroceryItem(String aName, double aValue)
	{
		//Checks and sets name
		if(aName == null)
			this.setName("none");
		else
			this.setName(aName);
		//Checks and sets value
		if(aValue < 0.0)
			this.setValue(0);
		else
			this.setValue(aValue);
	}
	//Accessors and mutators
	public String getName()
	{
		return this.name;
	}
	public double getValue()
	{
		return this.value;
	}
	public void setName(String aName)
	{
		if(aName == null)
			return;
		this.name = aName;
	}
	public void setValue(double aValue)
	{
		if(aValue < 0.0)
			return;
		this.value = aValue;
	}
	//Extra methods
	public String toString()
	{
		return "Grocerty Item Name: "+this.name+" Value: "+this.value;
	}
	public boolean equals(GroceryItem aGI)
	{
		return aGI != null && this.name.equals(aGI.getName()) && this.value == aGI.getValue();
	}
}
