
public class TicTacToeGame {

	private static char board[] = new char[10];

	private static void createBoard() {
		for (int i = 1; i < board.length; i++)
			board[i] = ' ';
	}

	public static void main(String args) {
		createBoard();
	}
}
