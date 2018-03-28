package assignment2018;


import assignment2018.codeprovided.Pawn;
import assignment2018.codeprovided.Piece;


public class Board{

    private final int BOARD_SIZE = 8;

    private Piece[][] boardArray = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board(){ }

    public void initialiseBoard() {
        int x;
        int y;
        int colour;

        for (x = 0; x < BOARD_SIZE; x++) {
            for (y = 0; y < BOARD_SIZE; y++) {
                if (!(y > 1 && y < 6)) {
                    if (y < 2) {
                        //set colour to black
                        colour = 0;
                    } else {
                        //set colour to white
                        colour = 1;
                    }
                    if (y == 1 || y == 6) {
                        //Pawn
                        boardArray[x][y] = new Pawn(x, y, colour, this);
                    } else {
                        if (x == 0 || x == 7) {
                            //Rook
                            boardArray[x][y] = new Rook(x, y, colour, this);
                        } else if (x == 1 || x == 6) {
                            //Knight
                            boardArray[x][y] = new Knight(x, y, colour, this);
                        } else if (x == 2 || x == 5) {
                            //Bishop
                            boardArray[x][y] = new Bishop(x, y, colour, this);
                        } else if (x == 3) {
                            //Queen
                            boardArray[x][y] = new Queen(x, y, colour, this);
                        } else {
                            //King
                            boardArray[x][y] = new King(x, y, colour, this);
                        }

                    }
                }
            }
        }
    }

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

    public static void main(String[] args) {
        //TEST
        Board board = new Board();
        board.initialiseBoard();
        System.out.println(board.boardArray);
    }
}
