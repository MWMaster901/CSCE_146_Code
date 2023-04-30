/*
 * Christopher Schweninger
 */
public class VideoGame 
{
	private String gameName;
	private String gameConsole;
	public VideoGame()
	{
		this.gameName = "none";
		this.gameConsole = "none";
	}
	public VideoGame(String aName, String aConsole)
	{
		if(aName != null && aConsole != null)
		{
			this.setVideoGameName(aName);
			this.setVideoGameConsole(aConsole);
		}	
		else
		{
			this.gameName = "none";
			this.gameConsole = "none";
		}
	}
	public String getVideoGameName()
	{
		return this.gameName;
	}
	public String getVideoGameConsole()
	{
		return this.gameConsole;
	}
	public void setVideoGameName(String aName)
	{
		if(aName != null)
			this.gameName = aName;
		else
			return;
	}
	public void setVideoGameConsole(String aConsole)
	{
		if(aConsole != null)
			this.gameConsole = aConsole;
		else
			return;
	}
	public String toString()
	{
		return this.gameName+"\t"+this.gameConsole;
	}
	public boolean equals(VideoGame aVG)
	{
		return aVG != null && this.gameName.equalsIgnoreCase(aVG.getVideoGameName()) && this.gameConsole.equalsIgnoreCase(aVG.getVideoGameConsole());
	}
}
