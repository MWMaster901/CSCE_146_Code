/*
 * By Christopher Schweninger
 */
import java.io.*;
import java.util.*;
public class shapeTreeManager {
	private static String DELIM = "\t";
	private LinkedBST<shape> sBST;
	public shapeTreeManager()
	{
		sBST = new LinkedBST<shape>();
	}
	public void addShape(shape aShape)
	{
		sBST.add(aShape);
	}
	public void removeShape(shape aShape)
	{
		sBST.remove(aShape);
	}
	public void searchForShape(shape aShape)
	{
		
		boolean searchSuccess = sBST.search(aShape);
		if(searchSuccess)
			System.out.println("This shape is in the tree.");
		else
			System.out.println("This shape is not in the tree.");
	}
	public shape findMaxArea()
	{
		return sBST.findMax();
	}
	public void removeShapesGreaterThan(shape aShape)
	{
		sBST.removeGreaterThan(aShape);
	}
	public void printPreOrder()
	{
		sBST.printPreOrder();
	}
	public void printInOrder()
	{
		sBST.printInOrder();
	}
	public void printPostOrder()
	{
		sBST.printPostOrder();
	}
	public void readFile(String aFileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 2)
				{
					String aType = splitLines[0];
					int param1 = Integer.parseInt(splitLines[1]);
					int param2 = param1;
					shape aShape = new shape(aType, param1, param2);
					sBST.add(aShape);
				}
				else if(splitLines.length == 3)
				{
					String aType = splitLines[0];
					int param1 = Integer.parseInt(splitLines[1]);
					int param2 = Integer.parseInt(splitLines[2]);
					shape aShape = new shape(aType, param1, param2);
					sBST.add(aShape);
				}
			}
			fileScanner.close();
			System.out.println("File read successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void writeFile(String aFileName)
	{
		sBST.writeFile(aFileName);
	}
	
	
}
