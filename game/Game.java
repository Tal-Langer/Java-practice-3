package game;

import java.util.Scanner;

public class Game extends Board {

	protected Player[] players;
	protected Scanner s = new Scanner(System.in);

	public Game(int n, int m, Player p1, Player p2) {
		super(n, m);
		players = new Player[2];
		players[0] = p1;
		players[1] = p2;

	}

	protected boolean doesWin(int i, int j) {
		if (!isEmpty(0, 0))
			return true;// (0,0) was taken
		return false;
	}

	protected boolean onePlay(Player p) {
		System.out.println(p.toString() + ", please enter x and y:");
		int x = s.nextInt(), y = s.nextInt();
		while (!set(x, y, p))// make the move if possible
		{
			System.out.println("(" + x + "," + y + ")" + " is already taken please try another move");
			x = s.nextInt();
			y = s.nextInt();
		}
		System.out.println(toString());// print board
		if (doesWin(x, y))
			return true;// player p has won the game
		return false;// player p made a move but did not win the game yet
	}// onePlay

	public Player play() {
		while (!(isFull())) {
			if (onePlay(players[0]))// p1 will play his move
			{
				System.out.println("The winner is " + players[0].toString());
				return players[0];// p1 won the game
			}
			if (onePlay(players[1]))// p2 will play his move
			{
				System.out.println("The winner is " + players[1].toString());
				return players[1];// p2 won the game
			}
		} // while
		return null;// no winner , the board is full
	}// play

}// class
