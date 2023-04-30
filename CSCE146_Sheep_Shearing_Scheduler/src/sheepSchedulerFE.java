/*
 * By Christopher Schweninger
 */
import java.util.*;
import java.io.*;
public class sheepSchedulerFE {
	public static final String DEC = "|-=======================================-|";
	public static final String DELIM = "\t";
	public static final Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args) {
		sheepScheduler sS = new sheepScheduler();
		System.out.println(DEC+"\nWelcome to the Sheep Scheduler Program.\n"+DEC);
		boolean complete = true;
		while(complete)
		{
			System.out.println("Please enter the filename: ");
			String input = keyboard.nextLine();
			sheep[] Sheeps = readFile(input);
			Sheeps = sortSheepsByArrival(Sheeps);
			System.out.println(DEC+"\nStarting Simulation\n"+DEC);
			int time = 0;
			while(true)
			{
				if(time < Sheeps.length)
					for(int i=0;i<Sheeps.length;i++)
					{
						if(Sheeps[i].getArrivalTime() == time)
							sS.addSheep(Sheeps[i]);
					}
				if(sS.isDone())
				{
					System.out.println("|-========Simulation Complete========-|");
					break;
				}
				sS.advanceOneTimeUnit();
				time++;
			}
			System.out.println(DEC+"\nWould you like to run another simulation?"
									+ "\nYes or No?\n"+DEC);
			input = keyboard.nextLine();
			if(input.equalsIgnoreCase("no"))
			{
				complete = false;
				System.out.println("Have A Nice Day!");
			}
			else if(input.equalsIgnoreCase("yes"))
				continue;
			else
			{
				System.out.println("ERROR: NOT RECOGNIZED INPUT, ASSUMING ANSWER IS NO");
				complete = false;
				System.out.println("Have A Nice Day!");
			}
		}
	}
	public static sheep[] readFile(String FileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(FileName));
			int sheepCount = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				sheepCount++;
			}
			if(sheepCount <= 0)
			{
				System.out.println("ERROR: NO SHEEP DETECTED EXITING");
				System.exit(0);
			}
			sheep[] tempSheep = new sheep[sheepCount];
			fileScanner = new Scanner(new File(FileName));
			int count = 0;
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 3)
				{
					String aName = splitLines[0];
					int aSheerTime = Integer.parseInt(splitLines[1]);
					int aArrivalTime = Integer.parseInt(splitLines[2]);
					sheep aSheep = new sheep(aName, aSheerTime, aArrivalTime);
					tempSheep[count] = aSheep;
					count++;
				}
			}
			fileScanner.close();
			System.out.println("File read successfully");
			return tempSheep;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static sheep[] sortSheepsByArrival(sheep[] sheepArray)
	{
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i=0; i<sheepArray.length-1; i++)
			{
				if(sheepArray[i].compareArrivalTime(sheepArray[i+1]) < 0)
				{
					sheep tempSheep = sheepArray[i];
					sheepArray[i] = sheepArray[i+1];
					sheepArray[i+1] = tempSheep;
					hasSwapped = true;
				}
			}
		}
		return sheepArray;
	}
}
