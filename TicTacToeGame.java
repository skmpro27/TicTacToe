
import java.util.*;

public class TicTacToeGame {

	private static Scanner sc = new Scanner(System.in);

        private static char board[] = new char[10];
        private static char computer;
        private static char player;
        private static int playerChance;
        private static int turn = 0;
        private static int index;

        private static final int WINNING_CONDITION = 3;

        private static ArrayList<int[]> condition = new ArrayList<>();


        private static void defaultConditions() {
                int[] arr0 = {1, 2, 3};
                int[] arr1 = {4, 5, 6};
                int[] arr2 = {7, 8, 9};
                int[] arr3 = {1, 4, 7};
                int[] arr4 = {2, 5, 8};
                int[] arr5 = {3, 6, 9};
                int[] arr6 = {1, 5, 9};
                int[] arr7 = {3, 5, 7};

                condition.add(arr0);
                condition.add(arr1);
                condition.add(arr2);
                condition.add(arr3);
                condition.add(arr4);
                condition.add(arr5);
                condition.add(arr6);
                condition.add(arr7);
        }


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
		System.out.println();
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

	//UC7
	//check winning condition
        private static char winning() {

                for (index = 0; index < condition.size(); index++) {
                        int sumX = 0;
                        int sumO = 0;
                        for (int j = 0; j < condition.get(index).length; j++) {
                                if (board[condition.get(index)[j]] == 'X') {
                                        sumX = sumX + 1;
                                        if (sumX == WINNING_CONDITION)
                                                return 'X';
                                }
                                else if (board[condition.get(index)[j]] == 'O') {
                                        sumO = sumO + 1;
                                        if (sumO == WINNING_CONDITION)
                                                return 'O';
                                }
                        }
                }
                return ' ';
        }

	//check tie condition
        private static boolean tie() {
                for (int k = 1; k < board.length; k++) {
                        if (board[k] == ' ')
                                return false;
                }
                return true;
        }

	//to change turn
        private static void turnChange() {
                while (true) {
                        if (winning() == 'X' || winning() == 'O') {
                                System.out.println((player == winning()) ? "You Win" : "Computer Wins");
                                break;
                        }
                        else if (tie()) {
                                System.out.println("It's a tie");
                                break;
                        }
                        else {
                                if (turn%2 == playerChance) {
                                        System.out.println("Your Turn");
                                        playerTurn();
                                        printBoard();
                                }
				/*
                                else {
                                        System.out.println("Computer Turn");
                                        computerTurn();
                                        printBoard();
                                }
				*/
                                turn++;
                        }
                }
        }

	//main
	public static void main(String args[]) {

		System.out.println("Welcome to Tic Tac Toe Game");
		defaultConditions();
		createBoard();
		choose();
		System.out.println("Computer letter is  " + computer);
		printBoard();
		toss();
		turnChange();
	}
}
