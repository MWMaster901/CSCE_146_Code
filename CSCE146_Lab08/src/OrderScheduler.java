/*
 * By Christopher Schweninger
 */
public class OrderScheduler 
{
	private MinHeap<Order> oHeap;
	private Order currentOrder;
	private int currentMinute;
	private int totalOrders;
	private double summedWaitingTimes;
	//Initializer
	public OrderScheduler()
	{
		oHeap = new MinHeap<Order>();
		currentOrder = new Order();
		currentOrder = null;
		currentMinute = 0;
		totalOrders = 0;
		summedWaitingTimes = 0;
	}
	//Adds a new order to the heap (or to the 'active' slot if this is the first order)
	public void addOrder(Order aOrder)
	{
		if(currentOrder == null)
			this.currentOrder = aOrder;
		else
			oHeap.add(aOrder);
		totalOrders++;
	}
	//This advances the time forward a minute, then if the current order is done, cycles to the next order
	public void advanceOneMinute()
	{
		currentMinute++;
		currentOrder.cookForOneMinute();
		if(currentOrder.isDone())
		{
			summedWaitingTimes += currentMinute - currentOrder.getArrivalTime();
			currentOrder = oHeap.remove();
		}
	}
	//This returns true if the ALL orders are done
	public boolean isDone()
	{
		if(currentOrder == null)
			return true;
		else
			return false;
	}
	//This just returns the average wait time spent overall on orders
	public double getAverageWaitingTime()
	{
		return summedWaitingTimes / totalOrders;
	}
	//This returns the current order being cooked
	public Order getCurrentOrder()
	{
		return currentOrder;
	}
}
