/*
 * By Christohper Schweninger
 */
import java.io.*;
import java.util.Scanner;
public class gameBoardManager 
{
	private gameBoard robotBoard;
	private int robotPosX;
	private int robotPosY;
	public static final int boardSizeLength = 10;
	public static final char emptyPiece = '_';
	public static final char robotPiece = 'R';
	public gameBoardManager()
	{
		this.robotBoard = new gameBoard();//Remember 0,0 is at the top left. Pos X goes -> Pos Y goes \/.
		this.robotPosX = 0;
		this.robotPosY = 0;
	}
	public void readBoardFile(String aName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(aName));
			int boardPosY = 0;
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				for(int i=0;i<boardSizeLength;i++)
					this.robotBoard.setBoardPiece(fileLine.charAt(i), boardPosY, i);
				boardPosY++;
			}
			this.robotBoard.setBoardPiece('R', 0, 0);
			fileScanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean moveRobot(String aCommand)//Remember Robot starts at 0,0 which is top left of board. PosX -> PosY \/
	{
		if(aCommand.equals("Move Up"))//Command move up
		{
			if(emptyPiece != robotBoard.getBoardPiece(robotPosY-1, robotPosX))//Either robot hits border or obstacle
			{
				robotBoard.setBoardPiece('!', robotPosY-1, robotPosX);
				return false;
			}
			else
			{
				robotBoard.setBoardPiece(emptyPiece, robotPosY, robotPosX);//Sets current robot position to blank
				robotBoard.setBoardPiece(robotPiece, robotPosY-1, robotPosX);//Sets new robot position to R
				robotPosY--;//Updates robot position (only one robot coordinate needs to be updated as the movement is one space in one direction
				return true;
			}
		}
		else if(aCommand.equals("Move Left"))//Command move left
		{
			if(emptyPiece != robotBoard.getBoardPiece(robotPosY, robotPosX-1))
			{
				robotBoard.setBoardPiece('!', robotPosY, robotPosX-1);
				return false;
			}
			else
			{
				robotBoard.setBoardPiece(emptyPiece, robotPosY, robotPosX);
				robotBoard.setBoardPiece(robotPiece, robotPosY, robotPosX-1);
				robotPosX--;
				return true;
			}
		}
		else if(aCommand.equals("Move Right"))//Command move right
		{
			if(emptyPiece != robotBoard.getBoardPiece(robotPosY, robotPosX+1))
			{
				robotBoard.setBoardPiece('!', robotPosY, robotPosX+1);
				return false;
			}
			else
			{
				robotBoard.setBoardPiece(emptyPiece, robotPosY, robotPosX);
				robotBoard.setBoardPiece(robotPiece, robotPosY, robotPosX+1);
				robotPosX++;
				return true;
			}
		}
		else if(aCommand.equals("Move Down"))//Command move down
		{
			if(emptyPiece != robotBoard.getBoardPiece(robotPosY+1, robotPosX))
			{
				robotBoard.setBoardPiece('!', robotPosY+1, robotPosX);
				return false;
			}
			else
			{
				robotBoard.setBoardPiece(emptyPiece, robotPosY, robotPosX);
				robotBoard.setBoardPiece(robotPiece, robotPosY+1, robotPosX);
				robotPosY++;
				return true;
			}
		}
		else
			return false;
	}
	public void printRobotBoard()
	{
		this.robotBoard.printBorderlessBoard();
		System.out.println();
		System.out.println("Robot PosX: "+robotPosX+" Robot PosY: "+robotPosY);
	}
	public void resetBoard()
	{
		robotPosX = robotPosY = 0;
	}
	
	
}
