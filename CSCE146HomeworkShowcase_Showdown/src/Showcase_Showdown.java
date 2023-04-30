/*
 * By Christopher Schweninger
 */
import java.util.*;
import java.io.*;
public class Showcase_Showdown {

	public static Scanner keyboard = new Scanner(System.in);
	public static Random rand = new Random();
	public static final String DELIM = "\t";
	public static final int DEF_SIZE = 10;
	public static void main(String[] args) {
		System.out.println("Welcome to Showcase Showdown! You will have to guess the approximate value of 5 randomly chosen items!");
		System.out.println("Before we can begin, could you please input the file name of the prizes");
		String tempFileName = keyboard.nextLine();
		Prizes[] prizeList = readPrizeFile(tempFileName);
		boolean menuQuit = false;
		while(!menuQuit)
		{
			System.out.println("You items are: ");
			int prizeTotal = randomPrizeTotal(prizeList);
			System.out.println("Guess the TOTAL value of these items. \nIf you would like to guess, type GUESS (not case sensitive)\nIf you would like to quit type QUIT (not case sensitive).");
			String inputString = keyboard.nextLine();
			if(inputString.equalsIgnoreCase("quit") == true)
			{
				System.out.println("Thanks for playing.");
				System.exit(0);
			}
			else if(inputString.equalsIgnoreCase("guess") == true)
			{
				System.out.println("Please make your guess. \nIf you guess is between TOTAL and TOTAL-1300 you win! \nIf you guess incorrectly, you lose :(");
				int totalGuess = keyboard.nextInt();
				keyboard.nextLine();
				int lowerPrizeTotal = prizeTotal - 1300;
				if(totalGuess >= lowerPrizeTotal && totalGuess <= prizeTotal)
				{
					System.out.println("Congrats your guess is within the range. The total was: "+prizeTotal);
					System.out.println("Restarting...");
				}
				else
				{
					System.out.println("Sadly your guess is not within the range. The total was: "+prizeTotal);
					System.out.println("Restarting...");
				}
			}
			else
			{
				System.out.println("ERROR, STRING INPUT NOT VALID. RESTARTING");
				System.out.println("Restarting...");
			}
			
		}
		//TODO Ask for file name, setup game

	}
	
	public static int randomPrizeTotal(Prizes aPrizeArray[])
	{
		int prizeTotal = 0;
		String[] randPrizeName = new String[5];
		int[] randPrize = new int[5];
		for(int r : randPrize)
			randPrize[r] = 0;
		int prizeSelected = 0;
		int[] uniquePrize = new int[5];
		int temp = 0;
		int temp2 = 0;
		boolean allSelected = false;
		boolean singleSelected = false;
		while(!allSelected)
		{
			
			while(!singleSelected)
			{
				prizeSelected = rand.nextInt(aPrizeArray.length);
				temp = 0;
				for(int i=0;i<uniquePrize.length;i++)
				{
					if(prizeSelected != uniquePrize[i])
						temp++;
					
					if(temp == 5)
					singleSelected = true;	
				}
			}
			randPrizeName[temp2] = aPrizeArray[prizeSelected].getPrizeName();
			randPrize[temp2] = aPrizeArray[prizeSelected].getPrizeValue();
			uniquePrize[temp2] = prizeSelected;
			temp2++;
			if(temp2 == 5)
				allSelected = true;
			else
				singleSelected = false;
			
		}
		for(int r=0; r<randPrize.length;r++)
			prizeTotal = prizeTotal + randPrize[r];
		for(int i=0; i<randPrizeName.length;i++)
			System.out.println("Item "+i+": " +randPrizeName[i]);
		return prizeTotal;
	}
	public static Prizes[] readPrizeFile(String fileName)
	{
		Prizes[] prizeList;
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			int lineCount = 0;
			while(fileScanner.hasNextLine())
			{
			fileScanner.nextLine();
			lineCount++;
			}
			if(lineCount <= 0)
			{
			System.out.println("ERROR FILE IS EMPTY. EXITING.");
			System.exit(0);
			}
			lineCount--;
			prizeList = new Prizes[lineCount];
			fileScanner = new Scanner(new File(fileName));
			int temp = 0;
			while(fileScanner.hasNextLine()) 
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 2)
				{
					String filePrizeName = splitLines[0];
					int filePrizeValue = Integer.parseInt(splitLines[1]);
					prizeList[temp] = new Prizes(filePrizeName, filePrizeValue);
					temp++;
				}
				
			}
			return prizeList;
		}
		catch(IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		prizeList = new Prizes[DEF_SIZE];
		return prizeList;
	}

}
