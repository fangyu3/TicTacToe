package tictactoe;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Board gameBoard = new Board();
        gameBoard.printBoard();
        playGame(gameBoard);
    }

    public static void playGame(Board gameBoard){
        boolean playerXTurn = true;
        char symbol = 'X';

        while(!checkGameFinished(gameBoard)){
            if(playerXTurn){
                symbol = 'X';
                playerXTurn = false;
            }
            else{
                symbol = 'O';
                playerXTurn = true;
            }
            playerTurn(gameBoard,symbol);
            gameBoard.printBoard();
        }
    }

    public static void playerTurn(Board gameBoard, char symbol){
        int x=0;
        int y=0;
        boolean turnEnd = false;

        do{
            System.out.print("Enter the coordinates: ");

            if(!scanner.hasNextInt()){
                System.out.println("You should enter numbers!");
                continue;
            }
            else
                x = scanner.nextInt();

            if(!scanner.hasNextInt()){
                System.out.println("You should enter numbers!");
                continue;
            }
            else
                y = scanner.nextInt();

            if (x<1 || x>3 || y<1 || y>3){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            Coordinate coordinate = new Coordinate(x,y);

            if(gameBoard.addToBoard(symbol,coordinate.getRowIdx(),coordinate.getColIdx()))
                turnEnd = true;
            else
                System.out.println("This cell is occupied! Choose another one!");

        }while(!turnEnd);
    }

    public static boolean checkGameFinished(Board gameBoard){

        char [][] board = gameBoard.getBoard();

        // CHECK ROW
        for (int row=0; row<gameBoard.getROW(); row++){
            if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != ' ') {
                System.out.println(board[row][0] + " wins");
                return true;
            }
        }

        // CHECK COLUMN
        for (int col=0; col<gameBoard.getCOL(); col++){
            if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != ' ') {
                System.out.println(board[0][col] + " wins");
                return true;
            }
        }

        // CHECK DIAGONAL
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            System.out.println(board[0][0] + " wins");
            return true;
        }
        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            System.out.println(board[0][2] + " wins");
            return true;
        }

        // CHECK TIE
        if(gameBoard.isFull()){
            System.out.println("Draw");
            return true;
        }

        return false;
    }
}
