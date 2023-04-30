/*
 * By Christopher Schweninger
 */
import java.util.*;
import java.io.*;
public class FruitTreeTester {
	private static String DELIM = "\t";
	private static Fruit rFruit = new Fruit("Kiwi", 0.9482193843337194);
	private static Scanner keyboard = new Scanner(System.in);
	private static LinkedBST<Fruit> fBST = new LinkedBST<Fruit>();
	public static void main(String[] args) 
	{
		System.out.println("Please input the file name: ");
		String input = keyboard.nextLine();
		fillOutTree(input);
		printPostBuffer();
		System.out.println("Printing in-order traversal");
		printBuffer();
		fBST.printInOrder();
		printPostBuffer();
		System.out.println("Printing pre-order traversal");
		printBuffer();
		fBST.printPreOrder();
		printPostBuffer();
		System.out.println("Printing post-order traversal");
		printBuffer();
		fBST.printPostOrder();
		printPostBuffer();
		System.out.println("Deleting Kiwi	0.9482193843337194");
		printBuffer();
		fBST.remove(rFruit);
		printPostBuffer();
		System.out.println("Printing in-order traversal");
		printBuffer();
		fBST.printInOrder();
	}
	private static void fillOutTree(String aFileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFileName));
			while(fileScanner.hasNextLine()) 
			{
				String nextFruit = fileScanner.nextLine();
				String[] splitFruit = nextFruit.split(DELIM);
				if(splitFruit.length == 2)
				{
					String fruitType = splitFruit[0];
					double fruitWeight = Double.parseDouble(splitFruit[1]);
					Fruit aFruit = new Fruit(fruitType, fruitWeight);
					fBST.add(aFruit);
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static void printBuffer()
	{
		System.out.println("------------------------------------------------------------------------");
		System.out.println();
	}
	private static void printPostBuffer()
	{
		System.out.println();
		System.out.println("========================================================================");
	}

}
