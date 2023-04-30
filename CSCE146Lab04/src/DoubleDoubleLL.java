/*
 * Christopher Schweninger
 */
public class DoubleDoubleLL {

	private class ListNode
	{
		double data;
		ListNode flink;
		ListNode dlink;
		public ListNode(double aData, ListNode aLink, ListNode bLink)
		{
			data = aData;
			flink = aLink;
			dlink = bLink;
		}
	}
	private ListNode head;
	private ListNode current;
	public DoubleDoubleLL()
	{
		head = current = null;
	}
	public void gotoNext()
	{
		if(current == null)
			return;
		current = current.flink;
	}
	public void gotoPrev()
	{
		if(current == null)
			return;
		current = current.dlink;
	}
	public void reset()
	{
		current = head;
	}
	public void gotoEnd()
	{
		ListNode temp = head;
		while(temp.flink != null)
			temp = temp.flink;
		current = temp;
	}
	public boolean hasMore()
	{
		return current != null;
	}
	public double getCurrent()
	{
		if(current == null)
			return 0.0;
		return current.data;
	}
	public void setCurrent(double adata)
	{
		if(current == null)
			return;
		current.data = adata;
	}
	public void add(double aData)
	{
		ListNode newNode = new ListNode(aData, null, null);
		if(head == null)
		{
			head = current = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.flink != null)
			temp = temp.flink;
		temp.flink = newNode;
		newNode.dlink = temp;
	}
	public void addAfterCurrent(double adata)
	{
		if(current == null)
			return;
		ListNode newNode = new ListNode(adata, current.flink, current.dlink);
		current.flink = newNode;
		newNode.dlink = current;
		
	}
	public void remove(double adata)
	{
		current = head;
		while(current.data != adata)
			current = current.flink;
		ListNode temp2 = current;
		temp2 = temp2.dlink;
		current = current.flink;
		temp2.flink = current;
		current.dlink = temp2;
	}
	public void removeCurrent()
	{
		if(current == head)
		{
			head = head.flink;
			current = head;
		}
		else if(current.flink == null)
		{
			current = current.dlink;
			current.flink = null;
		}
		else
		{
			ListNode temp = current;
			temp = temp.dlink;
			current = current.flink;
			temp.flink = current;
			current.dlink = temp;
		}
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.flink;
		}
		System.out.println();
	}
	public boolean contains(double adata)
	{
		ListNode temp = head;
		boolean doesContain = false;
		while(temp != null)
		{
			if(temp.data == adata)
				doesContain = true;
			temp = temp.flink;
		}
		return doesContain;
	}
}
