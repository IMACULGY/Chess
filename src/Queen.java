import java.awt.Point;

public class Queen extends Piece{

	public Queen(boolean color, int x, int y) 
	{
		super(color, x, y);
		constructMovesList();
	}
	
	public String toString()
	{
		if (color)
			return ANSI_RED + "Q" + ANSI_RESET;
		else
			return ANSI_BLUE + "Q" + ANSI_RESET;
	}

	@Override
	void constructMovesList() {
		movesList.add(new Point(1,0));
		movesList.add(new Point(2,0));
		movesList.add(new Point(3,0));
		movesList.add(new Point(4,0));
		movesList.add(new Point(5,0));
		movesList.add(new Point(6,0));
		movesList.add(new Point(7,0));
		movesList.add(new Point(-1,0));
		movesList.add(new Point(-2,0));
		movesList.add(new Point(-3,0));
		movesList.add(new Point(-4,0));
		movesList.add(new Point(-5,0));
		movesList.add(new Point(-6,0));
		movesList.add(new Point(-7,0));
		movesList.add(new Point(0,1));
		movesList.add(new Point(0,2));
		movesList.add(new Point(0,3));
		movesList.add(new Point(0,4));
		movesList.add(new Point(0,5));
		movesList.add(new Point(0,6));
		movesList.add(new Point(0,7));
		movesList.add(new Point(0,-1));
		movesList.add(new Point(0,-2));
		movesList.add(new Point(0,-3));
		movesList.add(new Point(0,-4));
		movesList.add(new Point(0,-5));
		movesList.add(new Point(0,-6));
		movesList.add(new Point(0,-7));
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

