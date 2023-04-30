/*
 * By Christopher Schweninger
 */
public class gameBoard 
{
	public static final int boardLength = 12;
	public static final int boardHeight = 12;
	public static final int borderOffset = 1;//This means the border of the board has a thickness of 1
	private char boardGame[][];
	public gameBoard()
	{
		this.boardGame = new char[boardHeight][boardLength];
		for(int i=0;i<boardHeight;i++)
		{
			for(int j=0;j<boardLength;j++)
				boardGame[i][j] = '-';
		}
		/*	This sets up the board as follows:
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * 	------------
		 * While initially this may seem weird as the board is supposed to be size 10x10
		 * Having a border will help ensure the code doesn't error out if the robot goes of the board
		 * The actual board is the inner 10x10, but can be changed by altering the static values above
		 */ 
	}
	public void setBoardPiece(char aChar, int posX, int posY)
	{
		this.boardGame[posY+borderOffset][posX+borderOffset] = aChar;
	}
	public char getBoardPiece(int posX, int posY)
	{
		return this.boardGame[posY+borderOffset][posX+borderOffset];
	}
	public void printFullBoard()
	{
		for(int i=0;i<boardHeight;i++)
		{
			for(int j=0;j<boardLength;j++)
				System.out.print(this.boardGame[j][i]);
			System.out.println();
		}
	}
	public void printBorderlessBoard()
	{
		for(int i=borderOffset;i<(boardHeight-borderOffset);i++)
		{
			for(int j=borderOffset;j<(boardLength-borderOffset);j++)
			{
				System.out.print(this.boardGame[j][i]);
			}
			System.out.println();
		}
	}
	
}
