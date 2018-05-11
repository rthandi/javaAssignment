package assignment2018;

import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.ArrayList;

public class King extends Piece {
    public King(int ix, int iy, int c, Board b) {
        super(PieceCode.KING, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        ArrayList<Move> moves = new ArrayList<>();

        //Move up one
        addMoves(x, y - 1, moves);

        //Move down one
        addMoves(x, y + 1, moves);

        //Move left one
        addMoves(x - 1, y, moves);

        //Move right one
        addMoves(x + 1, y, moves);

        //Move up left one
        addMoves(x - 1, y - 1, moves);

        //Move up right one
        addMoves(x + 1, y - 1, moves);

        //Move down left one
        addMoves(x - 1, y + 1, moves);

        //Move down right one
        addMoves(x + 1, y + 1, moves);

        return moves;
    }

    private ArrayList<Move> addMoves(int x, int y, ArrayList<Move> moves) {
        //check within range
        if (x >= 0 && x < getBoard().getBOARD_SIZE() && y >= 0 && y< getBoard().getBOARD_SIZE()) {
            //Check if it is occupied
            if (getBoard().occupied(x, y)) {
                //Check the colour is the same
                if (!(getColour() == getBoard().getPiece(x, y).getColour())) {
                    //same colour so add to the array as valid move
                    Move theMove = new Move(this, getX(), getY(), x, y, true);
                    moves.add(theMove);
                }
                //Can't go through a piece so return moves
                return moves;
            }
            //Not going through a piece and not out of bounds so valid move
            Move theMove = new Move(this, getX(), getY(), x, y, false);
            moves.add(theMove);
        }
        return moves;
    }
}
