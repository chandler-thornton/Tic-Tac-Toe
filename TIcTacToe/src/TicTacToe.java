import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		startMenu();
	}
	
	//Menu
	public static void startMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Tic-Tac-Toe\n\n1)Player vs Player\n2)Player vs Computer\n\nQ)Quit");
		String menuInput = scan.nextLine();
		
		switch(menuInput){
			case "1":
				new Board(1);
				break;
			case "2":
				new Board(2);
				break;
			case "Q":
				System.out.println("Thanks for playing!");
				break;
			default:
				System.out.println("ERROR: Invalid Input, Press \"Q\" to quit");
				startMenu();
		}
	}

}
