import java.awt.Point;

public class Bishop extends Piece {

	public Bishop(boolean color, int x, int y) 
	{
		super(color, x, y);
		constructMovesList();
	}
	
	public String toString()
	{
		if (color)
			return ANSI_RED + "B" + ANSI_RESET;
		else
			return ANSI_BLUE + "B" + ANSI_RESET;
	}

	@Override
	void constructMovesList() {
		movesList.add(new Point(1,1));
		movesList.add(new Point(2,2));
		movesList.add(new Point(3,3));
		movesList.add(new Point(4,4));
		movesList.add(new Point(5,5));
		movesList.add(new Point(6,6));
		movesList.add(new Point(7,7));
		movesList.add(new Point(-1,1));
		movesList.add(new Point(-2,2));
		movesList.add(new Point(-3,3));
		movesList.add(new Point(-4,4));
		movesList.add(new Point(-5,5));
		movesList.add(new Point(-6,6));
		movesList.add(new Point(-7,7));
		movesList.add(new Point(1,-1));
		movesList.add(new Point(2,-2));
		movesList.add(new Point(3,-3));
		movesList.add(new Point(4,-4));
		movesList.add(new Point(5,-5));
		movesList.add(new Point(6,-6));
		movesList.add(new Point(7,-7));
		movesList.add(new Point(-1,-1));
		movesList.add(new Point(-2,-2));
		movesList.add(new Point(-3,-3));
		movesList.add(new Point(-4,-4));
		movesList.add(new Point(-5,-5));
		movesList.add(new Point(-6,-6));
		movesList.add(new Point(-7,-7));
	}

	@Override
	void justMoved() 
	{
		firstMove = false;
	}
}

