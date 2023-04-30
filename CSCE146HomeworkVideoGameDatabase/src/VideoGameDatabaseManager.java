/*
 * Christopher Schweninger
 */
import java.util.Scanner;
import java.io.*;
public class VideoGameDatabaseManager 
{
	public static final String DELIM = "\t";
	public static final int BODY_FIELD_AMT = 2;
	private VideoGameDatabase<VideoGame> VideoGames;
	private VideoGameDatabase<VideoGame> SearchedGames;
	public VideoGameDatabaseManager()
	{
		VideoGames = new VideoGameDatabase<VideoGame>();
		SearchedGames = new VideoGameDatabase<VideoGame>();
	}
	public void addVideoGame(VideoGame aVG)
	{
		VideoGames.add(aVG);
	}
	public void addSearchedGame(VideoGame aVG)
	{
		SearchedGames.add(aVG);
	}
	public void clearSearchedGame()
	{
		SearchedGames.reset();
		while(SearchedGames.hasMore())
			SearchedGames.removeCurrent();
		System.out.println("Search cleared");
	}
	public void readVGFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length == BODY_FIELD_AMT)
				{
					String name = splitLines[0];
					String console = splitLines[1];
					VideoGame aVG = new VideoGame(name, console);
					this.addVideoGame(aVG);
				}
			}
			fileScanner.close();
			System.out.println("File read successfully.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void writeVGFile(String fileName, boolean append)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName, append));
			SearchedGames.reset();
			while(SearchedGames.hasMore())
			{
				VideoGame aVG = SearchedGames.getCurrent();
				fileWriter.println(aVG.getVideoGameName()+DELIM+aVG.getVideoGameConsole());
				SearchedGames.gotoNext();
			}
			fileWriter.close();
			System.out.println("File written successfully.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void searchVGDatabase(String aVGName, String aVGConsole)
	{
		if(aVGName.equals("*") && aVGConsole.equals("*"))//Full wildcard search (no search)
		{
			VideoGames.reset();
			while(VideoGames.hasMore())
			{
				this.addSearchedGame(VideoGames.getCurrent());
				VideoGames.gotoNext();
			}
		}
		else if(aVGConsole.equals("*"))//Searching for name but not console
		{
			VideoGames.reset();
			while(VideoGames.hasMore())
			{
				String temp1 = VideoGames.getCurrent().getVideoGameName().toLowerCase();
				String temp2 = aVGName.toLowerCase();
				int i = temp1.indexOf(temp2);
				if(i>=0)
					this.addSearchedGame(VideoGames.getCurrent());
				VideoGames.gotoNext();
			}
		}
		else if(aVGName.equals("*"))//Searching for console but not name
		{
			VideoGames.reset();
			while(VideoGames.hasMore())
			{
				String temp1 = VideoGames.getCurrent().getVideoGameConsole().toLowerCase();
				String temp2 = aVGConsole.toLowerCase();
				int i = temp1.indexOf(temp2);
				if(i>=0)
					this.addSearchedGame(VideoGames.getCurrent());
				VideoGames.gotoNext();
			}
		}
		else//Searching for both name and console
		{
			VideoGames.reset();
			while(VideoGames.hasMore())
			{
				String temp1 = VideoGames.getCurrent().getVideoGameName().toLowerCase();
				String temp2 = aVGName.toLowerCase();
				int i = temp1.indexOf(temp2);
				if(i>=0)
				{
					temp1 = VideoGames.getCurrent().getVideoGameConsole().toLowerCase();
					temp2 = aVGConsole.toLowerCase();
					i = temp1.indexOf(temp2);
					if(i>=0)
						this.addSearchedGame(VideoGames.getCurrent());
				}
				VideoGames.gotoNext();
			}
		}
	}
	public void printSearchResult()
	{
		SearchedGames.print();
	}
	public void printDatabase()
	{
		VideoGames.print();
	}
}
