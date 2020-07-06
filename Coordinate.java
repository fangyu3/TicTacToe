package tictactoe;

public class Coordinate {
    private int x;
    private int y;
    private int rowIdx;
    private int colIdx;

    public Coordinate(int x,int y){
        this.x = x;
        this.y = y;
        coordinateToArrayIdx();
    }

    public void coordinateToArrayIdx(){
        if (y==1)
            rowIdx = 2;
        else if (y == 3)
            rowIdx = 0;
        else
            rowIdx = 1;

        colIdx = x-1;
    }

    public int getColIdx() {
        return colIdx;
    }

    public int getRowIdx() {
        return rowIdx;
    }
}
