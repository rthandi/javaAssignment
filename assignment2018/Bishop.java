package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(int ix, int iy, int c, Board b) {
        super(PieceCode.BISHOP, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        ArrayList<Move> moves = new ArrayList<>();

        int i;
        int j;

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


