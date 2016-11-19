//2-Player Tic Tac Toe Game
//Lacks Tie implementation
import java.util.Scanner;
public class TestTicTac {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Creates 3x3 grid using array named "x"
		String[][] x = new String[3][3];
		for(int row=0; row<3 ;row++) {
			for(int col = 0; col < 3;col++) {
				x[row][col] = "| |";
		}
	}
		//Prints grid and enters while loop to begin program
		printGrid(x);
	while(checkWin(x) == false) {
		//Moves continue until the game is won
		System.out.println("\nPlayer 1 - Enter Row");
		int row = input.nextInt();
		System.out.println("Player 1 - Enter Column");
		int col = input.nextInt();
		//If invalid X input, continues to reprompt user
		while(addX(x,row,col) == false) {
				System.out.println("\nPlayer 1 - Enter Row");
				int askAgain = input.nextInt();
				System.out.println("Player 1 - Enter Column");
				int askAgain2 = input.nextInt();
			if(addX(x,askAgain, askAgain2) == true) {
				break;
				}
			}
		checkWin(x);
		//Ends by checking if win conditions are met
		if (checkWin(x) == true) {
			break;
		}
		System.out.println("\nPlayer 2 - Enter Row");
		int ip2 = input.nextInt();
		System.out.println("Player 2 - Enter Column");
		int ip3 = input.nextInt();
		while(addO(x,ip2,ip3) == false) {
			System.out.println("\nPlayer 2 - Enter Row");
			int askRow = input.nextInt();
			System.out.println("Enter Column");
			int askCol = input.nextInt();
		if(addO(x,askRow, askCol) == true) {
			break;
			}
		}
		checkWin(x);
		if (checkWin(x) == true) {
			break;
		}
	}
	}	
	public static void printGrid(String[][] exampleArray) {
		for(int row=0; row<3 ;row++) {
			System.out.println("");
			for(int col = 0; col < 3;col++) {
			System.out.print(exampleArray[row][col] + "");
		}
	}
}
	public static boolean addX(String[][] x, int r, int c) {
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				if(i == r - 1 && j == c -1) {
				//Prevents user from adding X if an O or X is present at coordinate
					if(x[i][j].equals("|O|")){
						System.out.println("Cannot place there");
						return false;
					}
					else if(x[i][j].equals("|X|")){
						System.out.println("Cannot place there");
						return false;
					}
					//If no problems occur, adds an X and prints grid again
					x[r-1][c-1] = "|X|";
					printGrid(x);
					return true;
				}
			}
		}
		return false;
	}
	public static boolean addO(String[][] x, int r, int c) {
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				if(i == r - 1 && j == c -1) {
					if(x[i][j].equals("|X|")){
						System.out.println("Cannot place there");
						return false;
					}
					else if(x[i][j].equals("|O|")){
						System.out.println("Cannot place there");
						return false;
					}
					System.out.println("Added");
					x[r-1][c-1] = "|O|";
					printGrid(x);
					return true;
				}
			}
		}
		return false;
	}
	public static boolean checkWin(String[][] x) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j<3; j++) {
				//Loop to check if X's and O's are present in winning combination
				if(x[0][j].equals("|X|") && x[1][j].equals("|X|") && x[2][j].equals("|X|")) {
					System.out.println("X's won");
					return true;
				}
				else if(x[i][0].equals("|X|") && x[i][1].equals("|X|") && x[i][2].equals("|X|")) {
					System.out.println("X's won");
					return true;
				}
				else if(x[0][0].equals("|X|") && x[1][1].equals("|X|") && x[2][2].equals("|X|")) {
					System.out.println("X's won");
					return true;
				}
				else if(x[2][0].equals("|X|") && x[1][1].equals("|X|") && x[0][2].equals("|X|")) {
					System.out.println("X's won");
					return true;
				}
				else if(x[2][0].equals("|O|") && x[1][1].equals("|O|") && x[0][2].equals("|O|")) {
					System.out.println("O's won");
					return true;
				}
				else if(x[0][j].equals("|O|") && x[1][j].equals("|O|") && x[3][j].equals("|O|")) {
					System.out.println("O's won");		
					return true;
				}
				else if(x[i][0].equals("|O|") && x[i][1].equals("|O|") && x[i][2].equals("|O|")) {
					System.out.println("O's won");
					return true;
				}
				else {
				}
			}
		}
		return false;
	}
}
