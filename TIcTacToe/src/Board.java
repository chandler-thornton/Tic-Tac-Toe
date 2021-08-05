import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class Board {
	
	private static char[][] board = {{' ',' ',' '},
								     {' ',' ',' '},
								     {' ',' ',' '}};
	private static boolean existsWinner = false;
	private static int winner;
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

	    if(player == 1) {
	    	switch(pos) {
	    		case 1:
	    			board[0][0] = 'X';
	    			break;
	    		case 2:
	    			board[0][1] = 'X';
	    			break;
	    		case 3:
	    			board[0][2] = 'X';
	    			break;
	    		case 4:
	    			board[1][0] = 'X';
	    			break;
	    		case 5:
	    			board[1][1] = 'X';
	    			break;
	    		case 6:
	    			board[1][2] = 'X';
	    			break;
	    		case 7:
	    			board[2][0] = 'X';
	    			break;
	    		case 8:
	    			board[2][1] = 'X';
	    			break;
	    		case 9 :
	    			board[2][2] = 'X';
	    			break;
	    	}
	    }
	    else if(player == 2) {
	    	switch(pos) {
	    		case 1:
	    			board[0][0] = 'O';
	    			break;
	    		case 2:
	    			board[0][1] = 'O';
	    			break;
	    		case 3:
	    			board[0][2] = 'O';
	    			break;
	    		case 4:
	    			board[1][0] = 'O';
	    			break;
	    		case 5:
	    			board[1][1] = 'O';
	    			break;
	    		case 6:
	    			board[1][2] = 'O';
	    			break;
	    		case 7:
	    			board[2][0] = 'O';
	    			break;
	    		case 8:
	    			board[2][1] = 'O';
	    			break;
	    		case 9 :
	    			board[2][2] = 'O';
	    			break;
	    	}
	    }
	}
	
	public static boolean checkExistsWinner() {
		return false;
	}

}

