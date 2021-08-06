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

	    if(player == 1) {
	    	switch(pos) {
	    		case 1:
	    			board[0][0] = 'X';
	    			columnScore[0] += 1;
	    			rowScore[0] += 1;
	    			diagonalScore[0] += 1;
	    			break;
	    		case 2:
	    			board[0][1] = 'X';
	    			columnScore[1] += 1;
	    			rowScore[0] += 1;
	    			break;
	    		case 3:
	    			board[0][2] = 'X';
	    			columnScore[2] += 1;
	    			rowScore[0] += 1;
	    			diagonalScore[1] += 1;
	    			break;
	    		case 4:
	    			board[1][0] = 'X';
	    			columnScore[0] += 1;
	    			rowScore[1] += 1;
	    			break;
	    		case 5:
	    			board[1][1] = 'X';
	    			columnScore[1] += 1;
	    			rowScore[1] += 1;
	    			diagonalScore[0] += 1;
	    			diagonalScore[1] += 1;
	    			break;
	    		case 6:
	    			board[1][2] = 'X';
	    			columnScore[2] += 1;
	    			rowScore[1] += 1;
	    			break;
	    		case 7:
	    			board[2][0] = 'X';
	    			columnScore[0] += 1;
	    			rowScore[2] += 1;
	    			diagonalScore[1] += 1;
	    			break;
	    		case 8:
	    			board[2][1] = 'X';
	    			columnScore[1] += 1;
	    			rowScore[2] += 1;
	    			break;
	    		case 9 :
	    			board[2][2] = 'X';
	    			columnScore[2] += 1;
	    			rowScore[2] += 1;
	    			diagonalScore[0] += 1;
	    			break;
	    	}
	    }
	    else if(player == 2) {
	    	switch(pos) {
	    		case 1:
	    			board[0][0] = 'O';
	    			columnScore[0] -= 1;
	    			rowScore[0] -= 1;
	    			diagonalScore[0] -= 1;
	    			break;
	    		case 2:
	    			board[0][1] = 'O';
	    			columnScore[1] -= 1;
	    			rowScore[0] -= 1;
	    			break;
	    		case 3:
	    			board[0][2] = 'O';
	    			columnScore[2] -= 1;
	    			rowScore[0] -= 1;
	    			diagonalScore[1] -= 1;
	    			break;
	    		case 4:
	    			board[1][0] = 'O';
	    			columnScore[0] -= 1;
	    			rowScore[1] -= 1;
	    			break;
	    		case 5:
	    			board[1][1] = 'O';
	    			columnScore[1] -= 1;
	    			rowScore[1] -= 1;
	    			diagonalScore[0] -= 1;
	    			diagonalScore[1] -= 1;
	    			break;
	    		case 6:
	    			board[1][2] = 'O';
	    			columnScore[2] -= 1;
	    			rowScore[1] -= 1;
	    			break;
	    		case 7:
	    			board[2][0] = 'O';
	    			columnScore[0] -= 1;
	    			rowScore[2] -= 1;
	    			diagonalScore[1] -= 1;
	    			break;
	    		case 8:
	    			board[2][1] = 'O';
	    			columnScore[1] -= 1;
	    			rowScore[2] -= 1;
	    			break;
	    		case 9 :
	    			board[2][2] = 'O';
	    			columnScore[2] -= 1;
	    			rowScore[2] -= 1;
	    			diagonalScore[0] -= 1;
	    			break;
	    	}
	    }
	}
	
	public static boolean checkExistsWinner() {
		for(int r = 0; r < 2; r++) {
			if(rowScore[r] == 3 || rowScore[r] == -3) {
				winnerNum = rowScore[r];
			}
		}
		for(int c = 0; c < 2; c++) {
			if(columnScore[c] == 3 || columnScore[c] == -3) {
				winnerNum = columnScore[c];
			}
		}
		for(int d = 0; d < 1; d++) {
			if(diagonalScore[d] == 3 || diagonalScore[d] == -3) {
				winnerNum = diagonalScore[d];
			}
		}
		if(winnerNum == 3) {
			winner = 1;
			existsWinner = true;
			return true;
		}
		else if(winnerNum == -3) {
			winner = 2;
			existsWinner = true;
			return true;
		}
		else {
			return false;
		}
	}

}

