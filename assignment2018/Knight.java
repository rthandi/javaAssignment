package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(int ix, int iy, int c, Board b) {
        super(PieceCode.KNIGHT, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        ArrayList<Move> moves = new ArrayList<>();

        //Up up left
        addMoves(x - 1, y - 2, moves);
        //Up left left
        addMoves(x - 2, y - 1, moves);
        //Up up right
        addMoves(x + 1, y - 2, moves);
        //Up right right
        addMoves(x + 2, y - 1, moves);
        //Down down left
        addMoves(x - 1, y + 2, moves);
        //Down left left
        addMoves(x - 2, y + 1, moves);
        //Down down right
        addMoves(x + 1, y + 2, moves);
        //Down right right
        addMoves(x + 2, y + 1, moves);

        return moves;
    }

    private void addMoves(int x, int y, ArrayList<Move> moves) {
        //Check target space is in bounds
        if (!(getBoard().outOfRange(x, y))) {
            //Check if target space is occupied
            if (getBoard().occupied(x, y)) {
                //Check if it is the same colour
                if (!(getBoard().getPiece(x, y).getColour() == getColour())) {
                    Move theMove = new Move(this, getX(), getY(), x, y, true);
                    moves.add(theMove);
                }
            } else {
                Move theMove = new Move(this, getX(), getY(), x, y, false);
                moves.add(theMove);
            }
        }
    }
}
