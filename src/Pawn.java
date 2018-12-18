import java.awt.Point;

public class Pawn extends Piece
{
	public Pawn(boolean color, int x, int y) 
	{
		super(color, x, y);
		constructMovesList();
		
	}
	
	public String toString()
	{
		if (color)
			return ANSI_RED + "P" + ANSI_RESET;
		else
			return ANSI_BLUE + "P" + ANSI_RESET;
	}

	@Override
	void constructMovesList() {
		if (!color)
		{
			movesList.add(new Point(0,2));
			movesList.add(new Point(0,1));
		}
		else
		{
			movesList.add(new Point(0,-2));
			movesList.add(new Point(0,-1));
		}
	}
	
	void justMoved()
	{
		firstMove = false;
		movesList.remove(0);
	}

}

