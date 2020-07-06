package tictactoe;

public class Board {
    private final int ROW;
    private final int COL;
    private char[][] board;

    public Board(){
        ROW = 3;
        COL = 3;
        board = new char[ROW][COL];
        initBoard();
    }

    public int getROW() {
        return ROW;
    }

    public int getCOL() {
        return COL;
    }

    public char[][] getBoard() {
        return board;
    }

    public void initBoard() {
        for (int row=0; row<ROW; row++){
            for (int col=0; col<COL; col++)
                board[row][col] = ' ';
        }
    }

    public void printBoard() {
        System.out.println("---------");

        for (int row=0; row<ROW; row++){
            for (int col=0; col<COL; col++){
                if(col==0)
                    System.out.print("| ");

                System.out.print(board[row][col] + " ");

                if(col==2)
                    System.out.println("|");
            }
        }

        System.out.println("---------");
    }

    public boolean addToBoard(char symbol, int row, int col) {

        if (board[row][col] != ' ')
            return false;

        board[row][col] = symbol;

        return true;
    }

    public boolean isFull(){
        for (int row=0; row<ROW; row++){
            for (int col=0; col<COL; col++)
                if(board[row][col] == ' ')
                    return false;
        }

        return true;
    }
}
