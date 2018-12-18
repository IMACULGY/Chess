import java.awt.Point;
import java.util.ArrayList;

public abstract class Piece 
{
	boolean color;
	boolean firstMove = true;
	int x;
	int y;
	
	
	final String ANSI_RED = "\u001b[31m";
	final String ANSI_BLUE = "\u001b[34m";
	final String ANSI_RESET = "\u001b[0m";
	
	ArrayList<Point> movesList = new ArrayList<Point>();
	
	
	public Piece(boolean color, int x, int y)
	{
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public boolean getColor()
	{
		return color;
	}
	
	public ArrayList<Point> getMovesList()
	{
		return movesList;
	}
	
	public boolean wasFirstMove()
	{
		return firstMove;
	}
	
	abstract void constructMovesList();
	
	abstract void justMoved();
	
	
}


