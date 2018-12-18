
//Added plugin which reads ANSI color codes.
import java.awt.Point;
import java.util.*;

public class Chess
{
	static Scanner scan = new Scanner(System.in);
	static String srcInput, destInput;

	public static void main(String[] args)
	{
		final String ANSI_RED = "\u001b[31m";
		final String ANSI_BLUE = "\u001b[34m";
		final String ANSI_RESET = "\u001b[0m";

		boolean playAgain = true;
		String won = null;
		Board board = new Board();

		boolean validMove = false;

		while (playAgain)
		{
			System.out.println("Chess!");

			while (won == null)
			{
				// Red's Turn
				System.out.println(ANSI_RED + "RED'S TURN" + ANSI_RESET);
				System.out.println(board);
				readInput();
				
				board.move(srcInput, destInput);
				
				while(board.getPlayerTurn())
				{
					readInput();
					board.move(srcInput, destInput);
				}

				// ...

				// Blue's Turn
				System.out.println(ANSI_BLUE + "BLUE'S TURN" + ANSI_RESET);
				System.out.println(board);
				readInput();
				
				board.move(srcInput, destInput);
				
				while(!board.getPlayerTurn())
				{
					readInput();
					board.move(srcInput, destInput);
				}

				// ...
			}
		}

	}

	/*
	 * Check the input to make sure it is entered in the format "[a-h][1-8]"
	 * Will prompt the user to enter another value if it does not match.
	 */
	private static String checkInput(String input)
	{
		while (!(input.length() == 2 && input.matches("[a-hA-h][1-8]")))
		{
			System.out.print("Bad input, please try again (Example input: a4) ");
			input = scan.next();
		}

		return input;
	}
	
	private static void readInput()
	{
		System.out.println("\nEnter the piece you would like to move.");
		srcInput = scan.next();
		srcInput = checkInput(srcInput);

		System.out.println("Enter the location you would like to move it to.");
		destInput = scan.next();
		destInput = checkInput(destInput);
	}

}
