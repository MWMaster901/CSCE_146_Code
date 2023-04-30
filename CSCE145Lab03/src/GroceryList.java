/*
 * By Christopher Schweninger
 */
public class GroceryList {

	//Create a Internal class ListNode
	private class ListNode
	{
		//With instance variables Data of type GroceryItem and Link of type ListNode
		GroceryItem Data;
		ListNode link;
		//Default Constructor
		public ListNode()
		{
			Data = new GroceryItem();
			link = null;
		}
		//Parameterized Constructor
		public ListNode(String aName, double aValue, ListNode alink)
		{
			Data = new GroceryItem(aName, aValue);
			link = alink;
		}
			
	}
	//Create instance variables head, current, previous
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	//Constructor -default that initialized head, current, and previous to an empty ListNode
	public GroceryList()
	{
		head = current = previous = null;
	}
	//This method shift current to the next available non-null node
	public void gotoNext()
	{
		if(current != null)
		{
			previous = current;
			current = current.link;
		}
	}
	//This method returns the data at the current node. Returns nothing if current node is null(empty)
	public GroceryItem getCurrent()
	{
		if(current == null)
			return null;
		return current.Data;
	}
	//This method sets the current node based on the given data. Does nothing if the current node is null OR if the data provided is also null
	public void setCurrent(GroceryItem aGI)
	{
		if(current != null)
			if(aGI != null)
				current.Data = aGI;
	}
	//This method adds a new item(data) to the end of the list
	public void addItem(GroceryItem aGI)
	{
		if(aGI != null)
		{
			ListNode newNode = new ListNode(aGI.getName(), aGI.getValue(), null);
			if(head == null)
			{
				head = current = newNode;
				return;
			}
			ListNode temp = head;
			while(temp.link != null)
				temp = temp.link;
			temp.link = newNode;
		}
	}
	//This method add a new item(data) immediately after the current node
	public void addItemAfterCurrent(GroceryItem aGI, ListNode link)
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(aGI.getName(), aGI.getValue(), current.link);
		current.link = newNode;
	}
	//This method removes the current node from the list
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.link;
			current = head;
		}
		else
		{
			previous.link = current.link;
			current = current.link;
		}
	}
	public void showList()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.Data.toString());
			temp = temp.link;
		}
	}
	public boolean contains(GroceryItem aGI)
	{
		ListNode temp = head;
		boolean tempBoolean = false;
		while(temp != null)
		{
			if(temp.Data.equals(aGI))
				tempBoolean = true;
			temp = temp.link;
		}
		return tempBoolean;
	}
	public double totalCost()
	{
		ListNode temp = head;
		double tempD = 0.0;
		while(temp != null)
		{
			tempD += temp.Data.getValue();
			temp = temp.link;
		}
		return tempD;
	}
	//Create multiple methods
		
		//removeCurrent, showList, contains, and totalCost
}
