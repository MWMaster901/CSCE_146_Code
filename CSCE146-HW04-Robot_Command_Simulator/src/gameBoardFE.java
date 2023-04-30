//Made by Christopher Schweninger
import java.io.*;
import java.util.Scanner;
public class gameBoardFE {
	private static Scanner keyboard = new Scanner(System.in);
	private static gameBoardManager newGame = new gameBoardManager();
	private static commandQueue<String> Commands;
	private static boolean finished = false;
	private static int currentCommand = 0;
	public static void main(String[] args) {
		boolean quit = false;
		while(!quit)
		{
			System.out.println("This program will run a simulation of a robot traversing a board.");
			boolean correctFileName = false;
			while(!correctFileName)
			{
				System.out.println("Enter file name for board");
				String fileName = keyboard.nextLine();
				if(fileName != null)
				{
					correctFileName = true;
					newGame.readBoardFile(fileName);
				}
				else
					System.out.println("NULL FILE NAME, TRY AGAIN");
			}
			correctFileName = false;
			while(!correctFileName)
			{
				System.out.println("Enter file name for commands");
				String fileName = keyboard.nextLine();
				if(fileName != null)
				{
					correctFileName = true;
					Commands = new commandQueue<String>();
					readCommandFile(fileName);
				}
				else
					System.out.println("NULL FILE NAME, TRY AGAIN");
			}
			finished = false;
			newGame.resetBoard();
			currentCommand = 1;
			while(!finished)
			{
				if(hasNextCommand())
				{
					System.out.println("Command "+currentCommand);
					doNextCommand();
					currentCommand++;
				}
			}
			System.out.println("Would you like to run another simulation or quit?");
			System.out.println("True to run another simulation or False to quit.");
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("True"))
				continue;
			else if(input.equalsIgnoreCase("False"))
			{
				System.out.println("Have a nice day");
				quit = true;
			}
			else
			{
				System.out.println("UNKOWN INPUT. ASSUMING QUIT.");
				System.out.println("Have a nice day");
				quit = true;
			}
		}
	}
	public static void readCommandFile(String aFile)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFile));
			while(fileScanner.hasNextLine())
			{
				String nextCommand = fileScanner.nextLine();
				if(nextCommand.equals("Move Up") || nextCommand.equals("Move Left") || nextCommand.equals("Move Right") || nextCommand.equals("Move Down"))
					Commands.enqueue(nextCommand);
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static boolean hasNextCommand()
	{
		if(Commands.peek() == null)
		{
			finished = true;
			return false;
		}
		else
			return true;
	}
	public static void doNextCommand()
	{
		String newCommand = Commands.dequeue();
		System.out.println("Command: "+newCommand);
		if(newGame.moveRobot(newCommand) == false)//Crash scenario
		{
			System.out.println("Robot Crashed at the ! (if none on screen, robot crashed into border)");
			newGame.printRobotBoard();
			finished = true;
		}
		else//Not-Crash scenario
		{
			newGame.printRobotBoard();
		}
	}
}
