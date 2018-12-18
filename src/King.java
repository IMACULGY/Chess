import java.awt.Point;

public class King extends Piece
{
	public King(boolean color, int x, int y) 
	{
		super(color, x, y);
		constructMovesList();
	}
	
	public String toString()
	{
		if (color)
			return ANSI_RED + "K" + ANSI_RESET;
		else
			return ANSI_BLUE + "K" + ANSI_RESET;
	}

	@Override
	void constructMovesList() {
		movesList.add(new Point(1,0));
		movesList.add(new Point(1,1));
		movesList.add(new Point(0,1));
		movesList.add(new Point(-1,1));
		movesList.add(new Point(-1,0));
		movesList.add(new Point(-1,-1));
		movesList.add(new Point(0,-1));
		movesList.add(new Point(1,-1));
	}

	@Override
	void justMoved() 
	{
		firstMove = false;
	}

}

