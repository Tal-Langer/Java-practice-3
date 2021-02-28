package game;

public class TicTacToe extends Game {

	public TicTacToe(String player1, String player2) {
		super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
	}

	@Override
	protected boolean doesWin(int i, int j) {
		if (maxLineContaining(i, j) == 3)
			return true;
		return false;
	}

}
