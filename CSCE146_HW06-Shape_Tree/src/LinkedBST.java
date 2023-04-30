/*
 * By Christopher Schweninger
 */
import java.io.*;
public class LinkedBST <T extends Comparable<T>>
{
	private class Node
	{
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;//Root node(top of tree)
	public LinkedBST()
	{
		root = null;
	}
	public void add(T aData)
	{
		if(root == null)
			root = new Node(aData);
		else
			add(root,aData);
	}
	private Node add(Node aNode, T aData)
	{
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data) < 0)//Left
			aNode.leftChild = add(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0)//Right
			aNode.rightChild = add(aNode.rightChild, aData);
		return aNode;
	}
	public boolean search(T aData)
	{
		return search(root,aData);
	}
	private boolean search(Node aNode, T aData)
	{
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data) < 0)//Left
			return search(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0)//Right
			return search(aNode.rightChild, aData);
		else
			return true;
	}
	public void remove(T aData)
	{
		root = remove(root, aData);
	}
	private Node remove(Node aNode, T aData)
	{
		if(aNode == null)
			return null;
		//Find the node to remove
		else if(aData.compareTo(aNode.data) < 0)
			aNode.leftChild = remove(aNode.leftChild, aData);//Search left
		else if(aData.compareTo(aNode.data) > 0)
			aNode.rightChild = remove(aNode.rightChild, aData);//Search right
		else//Found the node
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;//Remove left child node
			else if(aNode.leftChild == null)
				return aNode.rightChild;//Remove this node, but keep right child node
			Node temp = findMin(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);//This sums up to remove and replace this node with right child node
		}
		return aNode;
	}
	private Node findMin(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMin(aNode.leftChild);
	}
	public T findMax()
	{
		return findMax(root);
	}
	private T findMax(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.rightChild == null)
			return aNode.data;
		else
			return findMax(aNode.rightChild);
	}
	public void removeGreaterThan(T aData)
	{
		removeGreaterThan(root, aData);
	}
	private void removeGreaterThan(Node aNode, T aData)
	{
		if(aNode == null)
			return;
		//Find the node to start the removal
		else if(aData.compareTo(aNode.data) < 0)
			removeGreaterThan(aNode.leftChild, aData);//Search left
		else if(aData.compareTo(aNode.data) > 0)
			removeGreaterThan(aNode.rightChild, aData);//Search right
		else //Found it
		{
			aNode.rightChild = null; //This removes a children that are greater than it
			Node temp = findFirstLessThanOrEqualToThis(root, aData);
			if(temp.data.compareTo(aData) != 0)
			{
				temp.rightChild = aNode;
				root = temp;
			}
			else
				root = temp;
		}
	}
	private Node findFirstLessThanOrEqualToThis(Node aNode, T aData)
	{
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data) < 0)
			aNode.leftChild = findFirstLessThanOrEqualToThis(aNode.leftChild, aData);
		else
			return aNode;
		return aNode;
	}
	public void printPreOrder()//Prints the highest to lowest branch in left to right order
	{
		printPreOrder(root);
	}
	private void printPreOrder(Node aNode)
	{
		if(aNode == null)//Checks to make the movement was possible
			return;
		System.out.println(aNode.data);//Process
		printPreOrder(aNode.leftChild);//Go left (if possible)
		printPreOrder(aNode.rightChild);//Go right (if possible)
	}
	public void printInOrder()//Prints the tree in smallest to largest order
	{
		printInOrder(root);
	}
	private void printInOrder(Node aNode)
	{
		if(aNode == null)//Checks to make the movement was possible
			return;
		printInOrder(aNode.leftChild);//Go left (if possible)
		System.out.println(aNode.data);//Process
		printInOrder(aNode.rightChild);//Go right (if possible)
	}
	public void printPostOrder()//Prints the lowest to highest branch first in left to right order
	{
		printPostOrder(root);
	}
	private void printPostOrder(Node aNode)
	{
		if(aNode == null)//Checks to make the movement was possible
			return;
		printPostOrder(aNode.leftChild);//Go left (if possible)
		printPostOrder(aNode.rightChild);//Go right (if possible)
		System.out.println(aNode.data);//Process
	}
	public void writeFile(String fileName)
	{
		writeFile(root, fileName);
	}
	public void writeFile(Node mainNode, String fileName)
	{
	    FileOutputStream outputStream = null;
	    PrintWriter printWriter = null;

	    try
	    {

	        outputStream = new FileOutputStream(fileName);
	        printWriter = new PrintWriter(outputStream); 

	        write(mainNode, printWriter);

	        printWriter.flush();

	  }catch(IOException e)
	  {
	     System.out.println("An error occured");
	      printWriter.close();
	  }

	}

	 public void write(Node mainNode, PrintWriter w)
	 {
	     if(mainNode != null){
	      write(mainNode.leftChild, w);
	      w.print(mainNode);
	      write(mainNode.rightChild, w); 
	    }
	 }
	
}
