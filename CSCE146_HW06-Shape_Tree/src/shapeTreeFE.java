/*
 * By Christopher Schweninger
 */
import java.util.*;
public class shapeTreeFE {
	private static Scanner keyboard = new Scanner(System.in);
	private static shapeTreeManager sTM = new shapeTreeManager();
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Shape Tree!");
		boolean quit = false;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				preCommandBuffer();
				readFile();
				postCommandBuffer();
				break;
			case 2:
				preCommandBuffer();
				writeFile();
				postCommandBuffer();
				break;
			case 3:
				preCommandBuffer();
				printTraversal();
				postCommandBuffer();
				break;
			case 4:
				preCommandBuffer();
				addShape();
				postCommandBuffer();
				break;
			case 5:
				preCommandBuffer();
				removeShape();
				postCommandBuffer();
				break;
			case 6:
				preCommandBuffer();
				searchShape();
				postCommandBuffer();
				break;
			case 7:
				preCommandBuffer();
				maxShape();
				postCommandBuffer();
				break;
			case 8:
				preCommandBuffer();
				removeManyShapes();
				postCommandBuffer();
				break;
			case 0:
				System.out.println("Have a nice day");
				quit = true;
				
				default:
					System.out.println("UNKNOWN VALUE, TRY AGAIN");
			}
		}

	}
	private static void printChoices()
	{
		System.out.println("Enter 1 to Populate a Tree from a file (read file)\n"
				+ "Enter 2 to Populate a file using the current tree (write file)\n"
				+ "Enter 3 to Print a Tree Traversal (to console)\n"
				+ "Enter 4 to Add a Shape\n"
				+ "Enter 5 to Remove a Shape\n"
				+ "Enter 6 to Search for a Shape\n"
				+ "Enter 7 to Find the Shape with the Max Area\n"
				+ "Enter 8 to Remove all Shapes Greater than a Given Area\n"
				+ "Enter 0 to Quit");
	}
	private static void preCommandBuffer()
	{
		System.out.println("============================================");
	}
	private static void postCommandBuffer()
	{
		System.out.println("_____________________________________________");
		System.out.println();
	}
	private static void readFile()
	{
		System.out.println("Please give the file to read from");
		String fileName = keyboard.nextLine();
		sTM.readFile(fileName);
	}
	private static void writeFile()
	{
		System.out.println("Please give the file name to write to");
		String fileName = keyboard.nextLine();
		sTM.writeFile(fileName);
	}
	private static void printTraversal()
	{
		System.out.println("In what order should the traversal be printed in?");
		System.out.println("1. Pre-Order 2. In-Order 3. Post-Order");
		int input = keyboard.nextInt();
		switch(input)
		{
		case 1:
			sTM.printPreOrder();
			break;
		case 2:
			sTM.printInOrder();
			break;
		case 3:
			sTM.printPostOrder();
			break;
			default:
				System.out.println("UNKNOWN VALUE ASSUMING IN-ORDER");
				sTM.printInOrder();
		}
	}
	private static void addShape()
	{
		System.out.println("Please give the following details:");
		System.out.println("Shape Type:");
		String inputType = keyboard.nextLine();
		int param1, param2;
		if(inputType.equalsIgnoreCase("Circle"))
		{
			System.out.println("Radius:");
			param1 = keyboard.nextInt();
			param2 = param1;
		}
		else
		{
			System.out.println("Width:");
			param1 = keyboard.nextInt();
			System.out.println("Height:");
			param2 = keyboard.nextInt();
		}
		shape aShape = new shape(inputType, param1, param2);
		sTM.addShape(aShape);
	}
	private static void removeShape()
	{
		System.out.println("Please give the following details:");
		System.out.println("Shape Type:");
		String inputType = keyboard.nextLine();
		int param1, param2;
		if(inputType.equalsIgnoreCase("Circle"))
		{
			System.out.println("Radius:");
			param1 = keyboard.nextInt();
			param2 = param1;
		}
		else
		{
			System.out.println("Width:");
			param1 = keyboard.nextInt();
			System.out.println("Height:");
			param2 = keyboard.nextInt();
		}
		shape aShape = new shape(inputType, param1, param2);
		sTM.removeShape(aShape);
	}
	private static void searchShape()
	{
		System.out.println("Please give the following details:");
		System.out.println("Shape Type:");
		String inputType = keyboard.nextLine();
		int param1, param2;
		if(inputType.equalsIgnoreCase("Circle"))
		{
			System.out.println("Radius:");
			param1 = keyboard.nextInt();
			param2 = param1;
		}
		else
		{
			System.out.println("Width:");
			param1 = keyboard.nextInt();
			System.out.println("Height:");
			param2 = keyboard.nextInt();
		}
		shape aShape = new shape(inputType, param1, param2);
		sTM.searchForShape(aShape);
	}
	private static void maxShape()
	{
		System.out.println("The Shape with the Maximum Area is:");
		System.out.println(sTM.findMaxArea());
	}
	private static void removeManyShapes()
	{
		System.out.println("Please give the following details:");
		System.out.println("Shape Type:");
		String inputType = keyboard.nextLine();
		int param1, param2;
		if(inputType.equalsIgnoreCase("Circle"))
		{
			System.out.println("Radius:");
			param1 = keyboard.nextInt();
			param2 = param1;
		}
		else
		{
			System.out.println("Width:");
			param1 = keyboard.nextInt();
			System.out.println("Height:");
			param2 = keyboard.nextInt();
		}
		shape aShape = new shape(inputType, param1, param2);
		System.out.println("The given shape has an area of: "+aShape.getArea());
		sTM.removeShapesGreaterThan(aShape);
	}

}
