package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(int ix, int iy, int c, Board b) {
        super(PieceCode.ROOK, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        ArrayList<Move> moves = new ArrayList<>();

        int i;
        //Up
        for (i = 1; i <= y; i++) {
            addMoves(x, y - i, moves);
        }

        //Down
        for (i = y; i < getBoard().getBOARD_SIZE(); i++) {
            addMoves(x, i, moves);
        }

        //Left
        for (i = 1; i <= x; i++) {
            addMoves(x - i, y, moves);
        }

        //Right
        for (i = x; i < getBoard().getBOARD_SIZE(); i++) {
            addMoves(i, y, moves);
        }

        return moves;
    }

    private ArrayList<Move> addMoves(int x, int y, ArrayList<Move> moves) {
        System.out.println("1");
            //Check if it is occupied
            if (getBoard().occupied(x, y)) {
                System.out.println("2");
                //Check the colour is the same
                if (!(getColour() == getBoard().getPiece(x, y).getColour())) {
                    System.out.println("3");
                    //same colour so add to the array as valid move
                    Move theMove = new Move(this, getX(), getY(), x, y, true);
                    moves.add(theMove);
                }
                //Can't go through a piece so return moves
                System.out.println("4");
                return moves;
            }
        //Not going through a piece and not out of bounds so valid move
        System.out.println("5");
        Move theMove = new Move(this, getX(), getY(), x, y, false);
        moves.add(theMove);
        return moves;
    }
}
