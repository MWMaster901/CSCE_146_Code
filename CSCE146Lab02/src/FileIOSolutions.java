/*
 * By: Christopher Schweninger
 */
import java.util.*;
import java.io.*;
public class FileIOSolutions {
	public static final String DELIM = "\t";
	public static final double PI = 3.1415;
	public static void pastTense(String fileInput, String fileOutput)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileInput));
			int wordCount = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.next();
				wordCount++;
			}
			if(wordCount <= 0)
			{
				System.out.println("ERROR FILE NOT FOUND EXITING.");
				System.exit(0);
			}
			String [] tempArr = new String[wordCount];
			fileScanner = new Scanner(new File(fileInput));
			for(int i=0;i<tempArr.length;i++)
			{
				if(!fileScanner.hasNext())
					break;
				tempArr[i] = fileScanner.next();
			}
			for(int i=0; i<tempArr.length; i++)
			{
				if(tempArr[i].equalsIgnoreCase("Is"))
					tempArr[i] = "was";
			}
			PrintWriter fileWriter = new PrintWriter(fileOutput);
			for(int i=0; i<tempArr.length;i++)
			{
				System.out.println(tempArr[i]);
				fileWriter.println(tempArr[i]);
			}
			fileWriter.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static double totalTubeVolume(String tubeFileInput)
	{
		double tubeVolume = 0.0;
		double Volume = 0.0;
		try
		{
			Scanner fileScanner = new Scanner(new File(tubeFileInput));
			while(fileScanner.hasNextLine())
			{
				
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == 3)
				{
					double radius = Double.parseDouble(splitLines[1]);
					double height = Double.parseDouble(splitLines[2]);
					Volume = (radius * radius) * PI * height;
				}
				else
					Volume = 0.0;
				tubeVolume = tubeVolume + Volume;
			}
			return tubeVolume;
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return tubeVolume;
	}
}
