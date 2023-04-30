/*
 * By Christopher Schweninger
 */
public class Prizes {
	private String prizeName;
	private int prizeValue;
	public Prizes()
	{
		this.prizeName = "No Name";
		this.prizeValue = 0;
	}
	public Prizes(String aName, int aValue)
	{
		this.setPrizeName(aName);
		this.setPrizeValue(aValue);
	}
	public String getPrizeName()
	{
		return this.prizeName;
	}
	public int getPrizeValue()
	{
		return this.prizeValue;
	}
	public void setPrizeName(String aName)
	{
		this.prizeName = aName;
	}
	public void setPrizeValue(int aValue)
	{
		this.prizeValue = aValue;
	}
	public String toString()
	{
		return "Prize name: "+this.prizeName+" Value: "+this.prizeValue;
	}
	public boolean equals(Prizes aP)
	{
		return aP != null && this.prizeName.equals(aP.getPrizeName()) && this.prizeValue == aP.getPrizeValue();
	}
}
