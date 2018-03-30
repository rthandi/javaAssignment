package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(int ix, int iy, int c, Board b) {
        super(PieceCode.ROOK, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves(){
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        Move theMove;
        ArrayList<Move> moves = new ArrayList<>();

        int i;
        //Up
        for (i = 0; i >= y; i++){
            addMoves(x, y - i, moves);
        }

        //Down
        for (i = y; i < getBoard().getBOARD_SIZE() - 1 - y; i++){
            addMoves(x, y + i, moves);
        }

        //Left
        for (i = 0; i >= x; i++){
            addMoves(x - i, y, moves);
        }

        //Right
        for (i = x; i < getBoard().getBOARD_SIZE() - 1 - y; i++){
            addMoves(x + i, y, moves);
        }

        return moves;
    }

    private void addMoves(int x, int y, ArrayList<Move> moves){
        //Check that the target space is not out of range
        while (!(getBoard().outOfRange(x, y))){
            //Check if it is occupied
            if (getBoard().occupied(x, y)){
                //Check the colour is the same
                if (!(getColour() == getBoard().getPiece(x, y).getColour())){
                    //same colour so add to the array as valid move
                    Move theMove = new Move (this, getX(), getY(), x, y, true);
                    moves.add(theMove);
                }
                //Can't go through a piece so break out of loop
                break;
            }
            //Not going through a piece and not out of bounds so valid move
            Move theMove = new Move (this, getX(), getY(), x, y, false);
            moves.add(theMove);
        }
    }
}
