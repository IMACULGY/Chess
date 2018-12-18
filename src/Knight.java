import java.awt.Point;

public class Knight extends Piece
{

	public Knight(boolean color, int x, int y)
	{
		super(color, x, y);
		constructMovesList();
	}

	public String toString()
	{
		if (color)
			return ANSI_RED + "N" + ANSI_RESET;
		else
			return ANSI_BLUE + "N" + ANSI_RESET;
	}

	@Override
	void constructMovesList()
	{
		movesList.add(new Point(1, 2));
		movesList.add(new Point(1, -2));
		movesList.add(new Point(-1, 2));
		movesList.add(new Point(-1, -2));
		movesList.add(new Point(2, 1));
		movesList.add(new Point(2, -1));
		movesList.add(new Point(-2, 1));
		movesList.add(new Point(-2, -1));
	}

}
