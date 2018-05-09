package assignment2018;

import assignment2018.codeprovided.Piece;


public class Board {

    private final int BOARD_SIZE = 8;

    private Piece[][] boardArray = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board() {
    }

    public int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    public boolean outOfRange(int x, int y) {
        return x < 0 || x > BOARD_SIZE - 1 || y < 0 || y > BOARD_SIZE - 1;
    }

    public boolean occupied(int x, int y) {
        return boardArray[x][y] != null;
    }

    public Piece getPiece(int x, int y) {
        //Whenever this method is called checkIfValidLocation should be called before it to make sure no errors occur
        return boardArray[x][y];
    }

    public Piece[][] getBoard() {
        return boardArray;
    }

    public void setPosition(int x, int y, Piece piece) {
        //Whenever this method is called checkIfValidLocation should be called before it to make sure no errors occur
        boardArray[x][y] = piece;
    }

    public void removePiece(int x, int y){
        boardArray[x][y] = null;
    }
}
