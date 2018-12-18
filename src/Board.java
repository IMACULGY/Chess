import java.awt.Point;
import java.util.Arrays;

public class Board 
{
	final String ANSI_RESET = "\u001B[0m"; 
	final String ANSI_RED = "\u001B[31m";
	final String ANSI_BLUE = "\u001B[34m";
	private String[][] board = new String[10][10];
	private Piece[][] pieces = new Piece[8][8];
	private String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

	private static boolean red = false;
	private static boolean playerRedTurn = true;
	private static boolean inPlay = true;

	public Board()
	{
		for (int column = 0; column < 8; column++) //Creates an array of Pieces that correspond with the board
		{
			pieces[1][column] = new Pawn(false, 1, column);
			pieces[6][column] = new Pawn(true, 6, column);
		}
		pieces[0][0] = new Rook(false, 0, 0);
		pieces[0][7] = new Rook(false, 0, 7);
		pieces[7][0] = new Rook(true, 7, 0);
		pieces[7][7] = new Rook(true, 7, 7);
		pieces[0][1] = new Knight(false, 0, 1);
		pieces[0][6] = new Knight(false, 0, 6);
		pieces[7][1] = new Knight(true, 7, 1);
		pieces[7][6] = new Knight(true, 7, 6);
		pieces[0][2] = new Bishop(false, 0, 2);
		pieces[0][5] = new Bishop(false, 0, 5);
		pieces[7][2] = new Bishop(true, 7, 2);
		pieces[7][5] = new Bishop(true, 7, 5);
		pieces[0][3] = new Queen(false, 0, 3);
		pieces[0][4] = new King(false, 0, 4);
		pieces[7][3] = new Queen(true, 7, 3);
		pieces[7][4] = new King(true, 7, 4);

		for(int i = 2; i < 10; i++) // Creates the board to be printed out
		{
			board[i][0] = "" + (i-1);
		}
		for(int i = 1; i < 9; i++)
		{
			board[0][i] = alphabet[i-1];
		}
		for(int i = 2; i < 10; i++)
		{
			board[i][1] = "|";
			board[1][i] = "―";
		}
		for(int i = 2; i < 10; i++)
		{
			for(int j = 2; j < 4; j ++)
			{
				board[j][i] = "" + pieces[j-2][i-2];
			}
		}
		for(int i = 7; i > 3; i-=2)
		{
			for(int j = 3; j < 10; j +=2)
			{
				board[i][j] = "░";
				board[i-1][j-1] = "░";
			}
		}

		for(int i = 7; i > 3; i-=2)
		{
			for(int j = 2; j < 10; j +=2)
			{
				board[i][j] = "■";
				board[i-1][j+1] = "■";
			}
		}

		for (int i = 2; i < 10; i++)
		{
			for (int j = 8; j < 10; j++)
			{
				board[j][i] = "" + pieces[j-2][i-2];
			}
		}
		board[1][1] = "┍";
		board[0][0] = "     ";
		board[1][0] = " ";
		board[0][9] = "";
	}

	public void move(String startPosition, String endPosition)
	{	
		if (isLegalMove(startPosition, endPosition))
		{
			int startLetter = 0;
			int endLetter = 0;
			int endNumber = Integer.parseInt(endPosition.substring(1))-1;
			int startNumber = Integer.parseInt(startPosition.substring(1))-1;
			for(int i = 0; i < 8; i++)
			{
				if(startPosition.indexOf(alphabet[i]) != -1)
					startLetter = i;
				if(endPosition.indexOf(alphabet[i]) != -1)
					endLetter = i;
			}

			pieces[endNumber][endLetter] = pieces[startNumber][startLetter];
			pieces[startNumber][startLetter] = null;
			board[endNumber + 2][endLetter + 2] = board[startNumber + 2][startLetter + 2];
			if ((startNumber + startLetter) % 2 == 0)
				board[startNumber + 2][startLetter + 2] = "░";
			else
				board[startNumber + 2][startLetter + 2] = "■";
			if (pieces[endNumber][endLetter].wasFirstMove() == true)
				(pieces[endNumber][endLetter]).justMoved();
			playerRedTurn = !playerRedTurn;
		}
	}

	public boolean isLegalMove(String startPosition, String endPosition)
	{
		int startLetter = 0;
		int endLetter = 0;
		int endNumber = Integer.parseInt(endPosition.substring(1))-1;
		int startNumber = Integer.parseInt(startPosition.substring(1))-1;
		for(int i = 0; i < 8; i++)
		{
			if(startPosition.indexOf(alphabet[i]) != -1)
				startLetter = i;
			if(endPosition.indexOf(alphabet[i]) != -1)
				endLetter = i;
		}
		int letterDifference = endLetter - startLetter;
		int numberDifference = endNumber - startNumber;
		if (pieces[startNumber][startLetter] != null)
		{
			if (playerRedTurn)	

			{
				if (pieces[startNumber][startLetter].getColor() == true)
				{
					for (Point point : pieces[startNumber][startLetter].getMovesList())
					{
						if (letterDifference == point.getX() && numberDifference == point.getY())
						{
							return true;
						}
					}
				}
			}
			else if (pieces[startNumber][startLetter].getColor() == false)
			{
				for (Point point : pieces[startNumber][startLetter].getMovesList())
				{
					if (letterDifference == point.getX() && numberDifference == point.getY())
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean notObstructed(String startPosition, String endPosition)
	{
		int startLetter = 0;
		int endLetter = 0;
		int endNumber = Integer.parseInt(endPosition.substring(1))-1;
		int startNumber = Integer.parseInt(startPosition.substring(1))-1;
		int checkLetter = startLetter;
		int checkNumber = startNumber;
		for(int i = 0; i < 8; i++)
		{
			if(startPosition.indexOf(alphabet[i]) != -1)
				startLetter = i;
			if(endPosition.indexOf(alphabet[i]) != -1)
				endLetter = i;
		}
		
		if (pieces[startNumber][startLetter].getClass() == Bishop.class)
		{
			while (checkNumber != endNumber && checkLetter != endLetter)
			{
				if (checkNumber < endNumber)
				{
					checkNumber++;
				}
				else
					checkNumber--;
				
				if (checkLetter < endLetter)
				{
					checkLetter++;
				}
				else
					checkLetter--;
				
				if (pieces[checkNumber][checkLetter] != null)
					return false;
			}
		}
		
		return true;
	}

	public boolean getPlayerTurn()
	{
		return playerRedTurn;
	}
	
	public String toString()
	{
		return Arrays.deepToString(board).replaceAll("],", "]" + System.getProperty("line.separator")).replaceAll("]]","]").replace("[", "").replaceAll(","," ").replace("]", "").replace("34", "[34").replace("0m", "[0m").replace("31","[31");
	}
}



