/*
 * By Christopher Schweninger
 */
public class Order implements Comparable<Order>
{
	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft;
	//Constructors
	public Order ()
	{
		this.setCustomer("none");
		this.setFoodOrder("none");
		this.setCookingTime(1);
		this.setArrivalTime(0);
	}
	public Order (String aCustomer, String aFoodOrder, int aCookingTime, int aArrivalTime)
	{
		this.setCustomer(aCustomer);
		this.setFoodOrder(aFoodOrder);
		this.setCookingTime(aCookingTime);
		this.setArrivalTime(aArrivalTime);
	}
	//Mutators
	public void setCustomer(String aCustomer)
	{
		if(aCustomer == null)
			this.customer = "none";
		else
			this.customer = aCustomer;
	}
	public void setFoodOrder(String aFoodOrder)
	{
		if(aFoodOrder == null)
			this.foodOrder = "none";
		else
			this.foodOrder = aFoodOrder;
	}
	public void setCookingTime(int aCookingTime)
	{
		if(aCookingTime <= 0)
		{
			this.cookingTime = 1;
			this.cookingTimeLeft = cookingTime;
		}
		else
		{
			this.cookingTime = aCookingTime;
			this.cookingTimeLeft = aCookingTime;
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
	public String getCustomer()
	{
		return this.customer;
	}
	public String getFoodOrder()
	{
		return this.foodOrder;
	}
	public int getCookingTime()
	{
		return this.cookingTime;
	}
	public int getArrivalTime()
	{
		return this.arrivalTime;
	}
	public int getCookingTimeLeft()
	{
		return this.cookingTimeLeft;
	}
	//Other methods
	public String toString()
	{
		return "Customer: "+this.customer+", Order: "+this.foodOrder+", Cooking Time Left: "+this.cookingTimeLeft;
	}
	//Compares the cooking time of this order to another. Favors the order with the smaller order
	public int compareTo(Order aOrder)
	{
		if(this.cookingTime > aOrder.getCookingTime())
			return 1;
		else if(this.cookingTime < aOrder.getCookingTime())
			return -1;
		else
			return 0;
	}
	//Cooks for one minute
	public void cookForOneMinute()
	{
		this.cookingTimeLeft--;
	}
	//Returns true if this order has no cooking time left
	public boolean isDone()
	{
		if(this.cookingTimeLeft <= 0)
			return true;
		else
			return false;
	}
	
}
