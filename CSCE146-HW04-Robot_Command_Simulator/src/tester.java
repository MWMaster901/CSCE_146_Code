//TESTING PURPOSES ONLY
import java.io.*;
import java.util.Scanner;
public class tester {
	private static Scanner keyboard = new Scanner(System.in);
	private static gameBoardManager newGame = new gameBoardManager();
	private static commandQueue<String> Commands;
	public static void main(String[] args) {
		System.out.println("TESTING PURPOSES ONLY!");
		System.out.println("Enter file name for board");
		String fileName = keyboard.nextLine();
		if(fileName != null)
			newGame.readBoardFile(fileName);
		else
		{
			System.out.println("INCORRECT FILE NAME");
			System.exit(0);
		}
		System.out.println("Enter file name for commands");
		String commandName = keyboard.nextLine();
		if(commandName != null)
		{
			Commands = new commandQueue<String>();
			readQueueFile(commandName);
		}
		else
		{
			System.out.println("INCORRECT FILE NAME");
			System.exit(0);
		}
		boolean quit = false;
		while(!quit)
		{
			newGame.printRobotBoard();
			System.out.println("1 for Up, 2 for Left, 3 for Right, 4 for Down, 5 to next command, 9 to quit");
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				System.out.println("You choose up.");
				System.out.println("Movement Success?: "+newGame.moveRobot("Move Up"));
				break;
			case 2:
				System.out.println("You choose left.");
				System.out.println("Movement Success?: "+newGame.moveRobot("Move Left"));
				break;
			case 3:
				System.out.println("You choose right.");
				System.out.println("Movement Success?: "+newGame.moveRobot("Move Right"));
				break;
			case 4:
				System.out.println("You choose down.");
				System.out.println("Movement Success?: "+newGame.moveRobot("Move Down"));
				break;
			case 5:
				System.out.println("Running next command.");
				runNextCommand();
				break;
			case 9:
				System.out.println("Good bye");
				quit = true;
				break;
				default:
					System.out.println("INVALID INPUT, TRY AGAIN");
			}
		}
		

	}
	public static void readQueueFile(String aFile)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aFile));
			while(fileScanner.hasNextLine())
			{
				String nextCommand = fileScanner.nextLine();
				if(nextCommand.equals("Move Up") || nextCommand.equals("Move Left") || nextCommand.equals("Move Right") || nextCommand.equals("Move Down"))
					Commands.enqueue(nextCommand);
				else
					break;
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void runNextCommand()
	{
		if(Commands.peek() == null)
		{
			System.out.println("No more commands");
		}
		else
		{
			String command = Commands.dequeue();
			System.out.println("Movement Success?: "+newGame.moveRobot(command));
		}
	}

}
//TESTING PURPOSES ONLY