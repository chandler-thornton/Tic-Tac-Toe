import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;


import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Board {
	
	private static char[][] board = {{' ',' ',' '},
								     {' ',' ',' '},
								     {' ',' ',' '}};

	private static int[][] boardLayout = {{0,0,0},
								          {0,0,0},
		                                  {0,0,0}};
	
	private static int[] rowScore = {0,0,0};
	private static int[] columnScore = {0,0,0};
	private static int[] diagonalScore = {0,0};

	
	private static boolean existsWinner = false;
	private static int winner;
	private static int winnerNum = 0;
	private static int compType;
	
	//Start game
	public Board(int competitionType) {
		compType = competitionType;
		while(!existsWinner) {
			printBoard(board);
			if(!playerOneMove()) {
				playerTwoMove();
			}
		}
		System.out.println("Player " + winner + " wins!");
		TicTacToe.startMenu();
	}
	
	public static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}
	
	public static boolean playerOneMove() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Player 1, Enter position 1-9:");
		int move = scan.nextInt();
		setPlayerMove(move, 1);
		printBoard(board);
		System.out.println();
		return(checkExistsWinner());
	}
	
	public static void playerTwoMove() {
		int move;
		if(compType == 1) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Player 2, Enter position 1-9:");
			move = scan.nextInt();
		}
		else {
			Random rand = new Random();
			move = rand.nextInt(9);
		}
		setPlayerMove(move, 2);
		printBoard(board);
		System.out.println();
		checkExistsWinner();
	}
	
	public static void setPlayerMove(int pos, int player) {
	// 100 lines of code saved 
	    if(player == 1) {
	    	board[(pos - 1) / 3][(pos - 1) % 3] = 'X';
	    } else {
	    	board[(pos - 1) / 3][(pos - 1) % 3] = 'O';
	    }
	    
	}
	
	public static boolean checkExistsWinner() {
		char winner_ = ' ';
		
		for(int i = 0; i < 3; i++) {
			// checks winner of a row, sets winner_ equal to the either "X" or "O"
			if(board[i][0] == (board[i][1]) && board[i][0] == (board[i][2]) && (board[i][0] != ' ')){
				winner_ = board[i][0];
			}
			// checks winner of a column
			if(board[0][i] == (board[1][i]) && board[0][i] == (board[2][i]) && (board[i][0] != ' ')) {
				winner_ = board[0][i];
			}
			// checks winner of diagonals
			if(board[0][0] == (board[1][1]) && board[0][0] == (board[2][2]) && (board[i][0] != ' ')) {
				winner_ = board[1][1];
			}
			if(board[0][2] == (board[1][1]) && board[0][2] == (board[2][0]) && (board[i][0] != ' ')) {
				winner_ = board[1][1];
			}
		}
		// if winner_ is satisfied
		if(winner_ != ' ') {
			if(winner_ == 'X') {
				winner = 1;
			}else {
				winner = 2;
			}
			existsWinner = true;
			return true;
			
		}
		return false;
		}
	}