/*
 * By Christopher Schweninger
 */
public class Fruit implements Comparable<Fruit>
{
	private String type;
	private double weight;
	public Fruit()
	{
		this.setType("apple");
		this.setWeight(1.0);
	}
	public Fruit(String aName, double aWeight)
	{
		this.setType(aName);
		this.setWeight(aWeight);
	}
	public void setType(String aName)
	{
		if(aName == null)
			this.type = "apple";
		else if(aName.equalsIgnoreCase("apple") || aName.equalsIgnoreCase("orange") || aName.equalsIgnoreCase("banana") ||
				aName.equalsIgnoreCase("kiwi") ||aName.equalsIgnoreCase("tomato"))
			this.type = aName;
		else
			this.type = "apple";
	}
	public void setWeight(double aWeight)
	{
		if(aWeight <= 0.0)
			this.weight = 1.0;
		else
			this.weight = aWeight;
	}
	public String getType()
	{
		return this.type;
	}
	public double getWeight()
	{
		return this.weight;
	}
	public String toString()
	{
		return "Type: "+this.type+" Weight: "+this.weight;
	}
	public int compareTo(Fruit aFruit)
	{
		if(aFruit == null)
			return -1;
		else if(this.weight != aFruit.getWeight())
		{
			double temp = this.weight - aFruit.getWeight();
			if(temp > 0)
				return 1;
			else
				return -1;
		}
		else 
			return this.type.compareToIgnoreCase(aFruit.getType());
		
	}
}
