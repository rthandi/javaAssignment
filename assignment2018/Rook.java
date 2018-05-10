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

        System.out.println("asdasdasdasd");

        int i;
        //Up
        for (i = 1; i <= y; i++) {
            while(!(getBoard().occupied(x, y - i))){
                addMoves(x, y - i, moves);
                System.out.println("asdasd");
                System.out.println(moves.get(0));
            }
        }
//
//        //Down
//        for (i = y + 1; i < getBoard().getBOARD_SIZE() - 1 - y; i++) {
//            while(!(getBoard().occupied(x, y + i))) {
//                addMoves(x, y + i, moves);
//            }
//        }
//
//        //Left
//        for (i = 1; i <= x; i++) {
//            while(!(getBoard().occupied(x, y))) {
//                addMoves(x - i, y, moves);
//            }
//        }
//
//        //Right
//        for (i = x + 1; i < getBoard().getBOARD_SIZE() - 1 - y; i++) {
//            while(!(getBoard().occupied(x, y))) {
//                addMoves(x + i, y, moves);
//            }
//        }

        return moves;
    }

    private ArrayList<Move> addMoves(int x, int y, ArrayList<Move> moves) {
        //Check that the target space is not out of range
        while (!(getBoard().outOfRange(x, y))) {
            //Check if it is occupied
            if (getBoard().occupied(x, y)) {
                //Check the colour is the same
                if (!(getColour() == getBoard().getPiece(x, y).getColour())) {
                    //same colour so add to the array as valid move
                    Move theMove = new Move(this, getX(), getY(), x, y, true);
                    moves.add(theMove);
                }
                //Can't go through a piece so break out of loop
                break;
            }
            //Not going through a piece and not out of bounds so valid move
            Move theMove = new Move(this, getX(), getY(), x, y, false);
            moves.add(theMove);
        }
        return moves;
    }
}
