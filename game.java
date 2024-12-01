package sumofnaturalnumbers;
import java.util.*;
// Create a TicTacToe Game Class
class TicTacToe
{
	// create an Object with Two dimensional Char Array for Board Object
	// Static which is used to we can acess the method from class
	// so Declare as a Static 
	static char[][] board;
	
	// create a constructor with same name of the class name nd constructor doesn't have return type
	public TicTacToe()
	{
		// Board Reference from the top of Object
		board =new char[3][3];
		
		// Intilaze the board 
		initBoard();
		
	}
	// Create a Board Method
	void initBoard()
	{
		// Board length
		for(int i=0;i<board.length;i++)
		{
			// board[i] length it gives numbers of columns
			for(int j=0;j<board[i].length;j++)
			{
				// Every cell in Board Intilaze with Empty space ' ' 
				board[i][j] = ' ';
			}
		}
	}
	
	// Create dispBoard Method
	// Declare as a static we can axcess this method at anywhere bcz we declare as a static 
	static void dispBoard()
	{
		// Create Top of the Board Space
		System.out.println("-------------");
		
		// Length of the Board
		for(int i=0;i<board.length;i++)
		{
			// Print The Pipe
			System.out.print("| ");
		
			// board[i] length it gives numbers of columns
			for(int j=0;j<board[i].length;j++)
			{
				//it will print space pipe as well follow same instruction
				System.out.print(board[i][j] + " | ");	
			}
			// At the End of Column Curser Will come to the Next Row
			System.out.println();
			//create a space bar
			System.out.println("-------------");
			
		}
	}
	// Create a placeMark Method
	//Tt has Col-->Int, Row--> Int, Mark-->Char
	// static uses this method can acess in different class
	static void placeMark(int row,int col,char mark)
	{
		// check the Cond row && col 
		if(row>=0 && row<=2 && col>=0 && col<=2) {
			// If Cond is True 
			//Take the Mark place into the Row & Col
			board[row][col]=mark;
		}
		else {
			// Cond false print this
			System.out.println("Invalid Position");
		}
		
	}
	// Create checkColWin Method
	// static uses we can call the method
	static boolean checkColWin()
	{
		// loop for Col Traversal
		for(int j=0;j<=2;j++)
		{
			// check condition first char is not equal to empty char 
			//after && operation will work 
			if(board[0][j] != ' ' && board[0][j]==board[1][j] &&
			board[1][j]==board[2][j])
			{
				return true;
			}
		}
		return false;
	}
	
	// Create checkrowWin Method
	// static uses we can call the method
	static boolean checkRowWin()
	{
		// loop for Row Travesal
		for(int i=0;i<=2;i++)
		{
			if(board[i][0] != ' ' && board[i][0]==board[i][1] &&
					board[i][1]==board[i][2])
			{
				return true;
			}
		}
		return false;
	}
	// Create checkDiagnoalWin Method
	// static uses we can call the method
	static boolean checkDiagnoalWin()
	{
		if(board[0][0] != ' ' && board[0][0]==board[1][1]
				&& board[1][1]==board[2][2]
		|| board[0][2] != ' ' && board[0][2]==board[1][1]
			&& board[1][1]==board[2][0])
		{
			return true;
		}
		else 
		 {
			return false;
		}
	}
	// Create checkDraw Method
	// static uses we can call method from class to below method
	static boolean checkDraw()
	{
		// starting from row
		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				if(board[i][j]== ' ')
				{
					return false;
				}
			}
		}
		return true;
	}
}
	// Create a HumanPlayer Class
	class HumanPlayer
	{
		// Intiliaze the Instance variables
		String name;
		char mark;
		
		// create a parameterized Constructor
		// Local variable is must same to Instance variables
		HumanPlayer(String name, char mark)
		{
			// To avoid Showding Problem 
			// We use this KeyWord
			this.name=name;
			this.mark=mark;
		}
		// Create makeMove Method
		void makeMove()
		{
			// Take Scanner for User
			Scanner scan = new Scanner(System.in);
			// Note: We cant use Int below. Bcz in do while int and string not supported
			// So That's why we declare in the scanner Below
			int row;
			int col;
			// Do as Well as Condtion True
			// So we use the do While Loop
			// For ex: If user enter mark already mark is available we have to give another chance to user
			// so this do while loop  is useful
			do {
				// Enter the Row nd Col
				System.out.println("Enter the Row and Col");
				// Integer format will be Scanning the row and Col
				// Note: We cant use Int below. Bcz in do while int and string not supported
				// so That's why we declare in the scanner Below
				row = scan.nextInt();
				col = scan.nextInt();
				// As long as validmove is Invalid
			} while (!isValidMove(row,col));
			
			// Acessing the placeMark method by using TicTaeToe class
			TicTacToe.placeMark(row,col,mark);
			
		}
		
		// Create a isValidMove Method 
		boolean isValidMove(int row, int col)
		{
			// check the condtion the row and col are present are Not
			if(row>=0 && row<=2 &&
					col>=0 && col<=2)
			{
				// Acessing the Board Method By Using Class 
				// In the Above Class of Tic Tac Toe we made it as Static
				// so that's why we acessing the board from class
				// Check the Condtion which has a Space
				if(TicTacToe.board[row][col] ==' ')
				{
					return true;
				}
			}
			return false;
		}
	}
// Create a Class LaunchGame
public class LaunchGame {
// Program Will Executed From The Main Method
	public static void main(String[] args) {	
		// Create an Object of Tic Tac Toe Class and Constructor will Call
		TicTacToe t = new TicTacToe();
		// Create Object and Constructor will store the values
		HumanPlayer p1 = new HumanPlayer("Person..1",'X');
		HumanPlayer p2 = new HumanPlayer("Person..2", 'O');
		// Create a current Player cp
		HumanPlayer cp;
		// p1 is cp
		cp=p1;
		//As Long As True
		while(true)
		{
			System.out.println(cp.name +  " Turn");
			// Current Player Move
			cp.makeMove();
			TicTacToe.dispBoard();
			// In the Above Class of Tic Tac Toe we made it as Static
			// so that's why we acessing the checkColwin, checkRowWin,CheckDiagnoalWin from class
			// Note--> Check If P1 or P2 will Be Win 
			// It will be Executed
			if(TicTacToe.checkColWin() || TicTacToe.checkRowWin()
					|| TicTacToe.checkDiagnoalWin())
			{
				System.out.println(cp.name + " Has Won Congratulations");
				//if somebody Wins break the statement
				break;
			}
			// If Match will be Draw 
			else if(TicTacToe.checkDraw())
			{
				System.out.println("Game is Draw");
				break;
			}
			else
			{
				// if it is player1 we do it has player2
				// if it is player2 we do it has player1
				if(cp==p1)
				{
					cp=p2;
				}
				else
				{
					cp=p1;
				}
			}		
		}
	}
}
