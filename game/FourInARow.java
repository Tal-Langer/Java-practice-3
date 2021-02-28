package game;

import java.util.Scanner;

public class FourInARow extends Game {
	private static final int ROWS = 7;
	private static final int COLS = 7;
	// protected final int ROWS = 6, COLS = 7;

	public FourInARow(String player1, String player2) {
		super(ROWS, COLS, new Player(player1, 'W'), new Player(player2, 'B'));
	}

	@Override
	protected boolean doesWin(int i, int j) {
		if (maxLineContaining(i, j) >= 4) {
			// System.out.println(maxLineContaining(i,j));
			return true;
		}

		return false;
	}

	@Override
	protected boolean onePlay(Player p) {

		System.out.println(p.toString() + ", please enter col:");
		int col = s.nextInt(), row;
		row = free_space(col);
		while (row == -1)// col is full
		{
			System.out.println("column (" + col + ")" + " is full  please try another move");
			col = s.nextInt();
			row = free_space(col);
		}

		if (set(row, col, p))// make the move if possible
		{
			System.out.println(toString());// print board
			if (doesWin(row, col))
				return true;// player p has won the game
		}

		return false;// player p made a move but did not win the game yet
	}// onePlay

	private int free_space(int col) {
		if (isEmpty(0, col)) {// check if col is full (if full matrix[0][col] is taken)
			/* find empty space (starting from bottom) */
			for (int i = ROWS - 1; i > -1; i--)
				if (isEmpty(i, col)) {// true = [i][col] is the next free space in the col
					return i;
				}
		}
		return -1;// the col is full
	}// free_space

}// class
