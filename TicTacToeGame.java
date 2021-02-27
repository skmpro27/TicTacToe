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

	//UC3
	public static void printBoard() {
        	for (int i = 1; i < board.length; i++) {
                	if (i%3 == 0 ) {
                        	System.out.println("  " + board[i]);
                                System.out.println((i < board.length - 1) ? "-----+-----+------" : "");
                        }
                        else
                                System.out.print("  " + board[i] + "  |");
                }
        }

	//main
	public static void main(String args[]) {
		createBoard();
		choose();
		System.out.println("You letter is " + player);
		System.out.println("Computer letter is  " + computer);
		printBoard();
	}
}
