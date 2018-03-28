package assignment2018;


import assignment2018.codeprovided.Pawn;
import assignment2018.codeprovided.Piece;


public class Board{

    private final int BOARD_SIZE = 8;

    private Piece[][] boardArray = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board(){ }

    public boolean outOfRange(int x, int y) {
        return x < 0 || x > BOARD_SIZE - 1 || y < 0 || y > BOARD_SIZE - 1;
    }

    public boolean occupied(int x, int y){
        return boardArray[x][y] == null;
    }

    public Piece getPiece (int x, int y){
        //Whenever this method is called checkIfValidLocation should be called before it to make sure no errors occur
        //TODO: add exception here to make sure that there is no possibilities of errors
        return boardArray[x][y];
    }

    public Piece[][] getBoard(){
        return boardArray;
    }

    //TODO: Method to insert of remove a piece

}
