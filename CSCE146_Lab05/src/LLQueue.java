/*
 * By Christopher Schweninger
 */
public class LLQueue <T> implements QueueI<T>
{
	private class listNode
	{
		T data;
		listNode link;
		public listNode(T aData, listNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private listNode head;
	private listNode tail;
	public LLQueue()
	{
		head = tail = null;
	}
	public void enqueue(T aData)
	{
		listNode newNode = new listNode(aData, null);
		if(head == null)//Queue empty
		{
			head = tail = newNode;
			return;
		}
		//Queue not empty
		tail.link = newNode;
		tail = tail.link;
	}
	public T dequeue()
	{
		if(head == null)//Queue empty
			return null;
		//Else queue not empty
		T ret = head.data;
		head = head.link;
		return ret;
	}
	public T peek()
	{
		if(head == null)//Queue empty
			return null;
		//Else
		return head.data;
	}
	public void print()
	{
		for(listNode temp = head;temp != null; temp = temp.link)//This simply just goes through the whole linked list starting from the head and going to tail
			System.out.println(temp.data);
	}
}
