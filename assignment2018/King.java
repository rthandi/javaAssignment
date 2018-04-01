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
        Move theMove;

        int i;
        int j;
        //Loop through x and y between -1 and 1
        for (i = -1; i <= 1; i++){
            for (j = -1; j <= 1; j++){
                //Check if target space is occupied
                if (getBoard().occupied(i, j)) {
                    //Check if it is the same colour
                    //Don't need to do a check to see if i and j are both 0 as the piece will have the same colour so a move will not be generated
                    if (!(getBoard().getPiece(i, j).getColour() == getColour())) {
                        theMove = new Move(this, x, y, i, j, true);
                        moves.add(theMove);
                    }
                } else {
                    theMove = new Move(this, x, y, i, j, false);
                    moves.add(theMove);
                }
            }
        }
        return moves;
    }
}
