package game;

public class Board {

	protected Player[][] board;
	protected int n, m;

	public Board(int n, int m) {
		this.n = n;
		this.m = m;
		board = new Player[n][m];
	}

	protected boolean set(int i, int j, Player p) {
		if (isEmpty(i, j)) {
			board[i][j] = p;// player p took the free space
			return true;
		}
		return false;// board[i][j] is already taken
	}

	public boolean isEmpty(int i, int j) {
		if (board[i][j] == null)// null its empty
			return true;
		return false;
	}

	public Player get(int i, int j) {
		return board[i][j];
	}

	public boolean isFull() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (board[i][j] == null)
					return false; // the board is not full
		return true;// the board is full

	}

	public String toString() {
		String to_string = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEmpty(i, j))
					to_string += ".";
				else
					to_string += board[i][j].getMark();
			}
			to_string += "\n";
		}
		return to_string;
	}

//n = row , m = col				 	row    col
	protected int maxLineContaining(int i, int j) {
		int max_raw = 1, max_col = 1, max_diagonal_right = 1, max_diagonal_left = 1;
		int col, row;
		/*up=row-- , down = row++ , left = col-- , right = col++ */
		
		/* calc max_row */
		// check right
		for (col = j + 1; col < m; col++)// check for sequence
			if (board[i][col] == board[i][j])
				max_raw++;
			else
				break;// no sequence

		// check left
		for (col = j - 1; col > -1; col--)// check for sequence
			if (board[i][col] == board[i][j])
				max_raw++;
			else
				break;// no sequence

		/* calc max_col */
		//check up
		for (row = i - 1; row > -1; row--)// check for sequence
			if (board[row][j] == board[i][j])
				max_col++;
			else
				break;// no sequence
		//check down 
		for (row = i + 1; row < n; row++)// check for sequence
			if (board[row][j] == board[i][j])
				max_col++;
			else
				break;// no sequence
		
		/*check diagonal_right (right to left)*/
		//up and left
		for (row =i-1,col = j - 1 ; row > -1 && col > -1 ;row--,col--  )// check for sequence
			if (board[row][col] == board[i][j])
				max_diagonal_right++;
			else
				break;// no sequence
		//down and right
		for (row = i + 1,col = j + 1 ; row < n && col < m ;row++,col++  )// check for sequence
			if (board[row][col] == board[i][j])
				max_diagonal_right++;
			else
				break;// no sequence
		
		/*check diagonal_left (left to right )*/
		//up and right
		for (row =i-1,col = j + 1 ; row > -1 && col < m ;row--,col++  )// check for sequence
			if (board[row][col] == board[i][j])
				max_diagonal_left++;
			else
				break;// no sequence
		//down and left
		for (row = i + 1,col = j - 1 ; row < n && col > -1 ;row++,col--  )// check for sequence
			if (board[row][col] == board[i][j])
				max_diagonal_left++;
			else
				break;// no sequence
		

		/* return the longest line */
		return Math.max(Math.max(max_raw, max_col), Math.max(max_diagonal_right, max_diagonal_left));
	}



	

}// class
