/*
 * Christopher Schweninger
 */
import java.util.Scanner;
public class VideoGameDatabaseFE {

	private static Scanner keyboard = new Scanner(System.in);
	private static VideoGameDatabaseManager VGDBmanager = new VideoGameDatabaseManager();
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Video Game Database Manager.");
		boolean quit = false;
		while(!quit)
		{
			printChoices();
			int choice = keyboard.nextInt();
			keyboard.nextLine();
			switch(choice)
			{
			case 1:
				readFile();
				break;
			case 2:
				searchDatabase();
				break;
			case 3:
				VGDBmanager.printDatabase();
				break;
			case 4:
				quit = true;
				System.out.println("Good bye.");
				break;
				
				default:
					System.out.println("Invalid Input, please try again");
			}
		}
	}
	public static void printChoices()
	{
		System.out.println("Enter 1 to read a file\n"
				+ "Enter 2 to search the database\n"
				+ "Enter 3 to print database\n"
				+ "Enter 4 to quit");
		
	}
	public static void readFile()
	{
		System.out.println("Enter the file name to read from.");
		String fileName = keyboard.nextLine();
		VGDBmanager.readVGFile(fileName);
	}
	public static void searchDatabase()
	{
		System.out.println("Please enter the search parameter for game name.\n"
				+ "* (Asterick) can be used instead as a wildcard search option.");
		String nameParameter = keyboard.nextLine();
		System.out.println("Please enter the search parameter for console.\n"
				+ "* (Asterick) can be used instead as a wildcard search option.");
		String consoleParameter = keyboard.nextLine();
		VGDBmanager.searchVGDatabase(nameParameter, consoleParameter);
		System.out.println("Search results: ");
		VGDBmanager.printSearchResult();
		System.out.println("Would you like to write this result to a file?");
		System.out.println("Enter 1 to save to a NEW file\n"
				+ "Enter 2 to save to a PRE-EXISTING file\n"
				+ "Enter 4 to NOT save results.");
		int saveChoice = keyboard.nextInt();
		keyboard.nextLine();
		switch(saveChoice)
		{
		case 1:
			System.out.println("Please give the file name");
			String newFileName = keyboard.nextLine();
			VGDBmanager.writeVGFile(newFileName, false);
			VGDBmanager.clearSearchedGame();
			break;
		case 2:
			System.out.println("Please give the file name");
			String preExistFileName = keyboard.nextLine();
			VGDBmanager.writeVGFile(preExistFileName, true);
			VGDBmanager.clearSearchedGame();
			break;
		case 4:
			System.out.println("Returning to menu");
			VGDBmanager.clearSearchedGame();
			break;
			
			default:
				System.out.println("Invalid input, assuming to NOT save results.");
				System.out.println("Returning to menu");
				VGDBmanager.clearSearchedGame();
		}
	}

}
