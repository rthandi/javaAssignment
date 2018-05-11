package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(int ix, int iy, int c, Board b) {
        super(PieceCode.QUEEN, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        ArrayList<Move> moves = new ArrayList<>();

        int i;
        int j;

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


        //Down right
        j = x;
        for (i = y; i < getBoard().getBOARD_SIZE(); i++) {
            if(j < getBoard().getBOARD_SIZE()){
                addMoves(j, i, moves);
                j++;
            }
        }

        //Up left
        j = 1;
        for (i = 1; i <= y; i++) {
            if (j <= x){
                addMoves(x - j, y - i, moves);
                j++;
            }
        }

        //Down left
        j = 1;
        for (i = y; i < getBoard().getBOARD_SIZE(); i++) {
            if (j <= x){
                addMoves(x - j + 1, i, moves);
                j++;
            }
        }

        //Up right
        j = x;
        for (i = 1; i <= y; i++) {
            if(j < getBoard().getBOARD_SIZE()) {
                addMoves(j, y - i + 1, moves);
                j++;
            }
        }

        return moves;
    }

    private ArrayList<Move> addMoves(int x, int y, ArrayList<Move> moves) {
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
        return moves;
    }
}
