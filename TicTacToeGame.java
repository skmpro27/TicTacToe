import java.util.*;

public class TicTacToeGame {

	private static Scanner sc = new Scanner(System.in);

	private static char board[] = new char[10];
	private static char computer;
	private static char player;
        private static int playerChance;

	//UC1
	private static void createBoard() {
		for (int i = 1; i < board.length; i++)
			board[i] = ' ';
	}

	//UC2
	private static void choose() {
		System.out.print("\nChoose your letter X or O: ");
		player = sc.next().toUpperCase().charAt(0);
		if (player == 'X')
			computer = 'O';
		else if (player == 'O')
			computer = 'X';
		else {
			System.out.println("\nInvalid input enter again");
			choose();
		}
	}

	//UC3
	public static void printBoard() {
        	for (int i = 1; i < board.length; i++) {
                	if (i%3 == 0 ) {
                        	System.out.println("  " + board[i]);
                                System.out.println((i < board.length - 1) ? "-----+-----+-----" : "");
                        }
                        else
                                System.out.print("  " + board[i] + "  |");
                }
        }

        //UC4 and UC5
        public static void playerTurn() {
                System.out.print("Select a position to play(1-9): ");
                int position = sc.nextInt();
                if (board[position] != ' ') {
                        System.out.println("Position occupied select another");
                	playerTurn();
		}
		else
			board[position] = player;
        }

	//UC6
        public static void toss() {

                playerChance = (int) (Math.random() * 2);
                System.out.println((playerChance == 0) ? "Your Turn" : "Comuter Turn");
        }

	//main
	public static void main(String args[]) {

		System.out.println("Welcome to Tic Tac Toe Game");
		createBoard();
		choose();
		System.out.println("Computer letter is  " + computer);
		printBoard();
		toss();
		playerTurn();
		printBoard();
	}
}
