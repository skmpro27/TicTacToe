import java.util.*;

public class TicTacToeGame {

	static Scanner sc = new Scanner(System.in);

	private static char board[] = new char[10];
	private static char computer;
	private static char player;

	//UC1
	private static void createBoard() {
		for (int i = 1; i < board.length; i++)
			board[i] = ' ';
	}

	//UC2
	private static void choose() {
		System.out.print("Choose X or O: ");
		player = sc.next().toUpperCase().charAt(0);
		if (player == 'X')
			computer = 'O';
		else if (player == 'O')
			computer = 'X';
		else {
			System.out.println("Invalid input enter again");
			choose();
		}
	}

	public static void main(String args[]) {
		createBoard();
		choose();
		System.out.println("Computer " + computer);
		System.out.println("Player " + player);
	}
}
