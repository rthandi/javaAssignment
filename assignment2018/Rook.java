package assignment2018;

import assignment2018.codeprovided.Piece;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(int i, int ix, int iy, int c, Board b) {
        super(i, ix, iy, c, b);
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
            //Check that the space in front is not out of range
            while (!(getBoard().outOfRange(x, y - i))){
                //Check if it is occupied
                if (getBoard().occupied(x, y - i)){
                    //Check the colour is the same
                    if (!(getColour() == getBoard().getPiece(x, y - i).getColour())){
                        //same colour so add to the array as valid move. Then break
                        theMove = new Move (this, x, y, x, y - i, true);
                        moves.add(theMove);
                    }
                    //Can't go through a piece so break out of loop
                    break;
                }
                //Not going through a piece and not out of bounds so valid move
                theMove = new Move (this, x, y, x, y - i, false);
                moves.add(theMove);
            }
        }

        //Down
        for (i = y; i < getBoard().getBOARD_SIZE() - 1; i++){
            //Check that the space in front is not out of range
            while (!(getBoard().outOfRange(x, y + i))){
                //Check if it is occupied
                if (getBoard().occupied(x, y + i)){
                    //Check the colour is the same
                    if (!(getColour() == getBoard().getPiece(x, y + i).getColour())){
                        //same colour so add to the array as valid move. Then break
                        theMove = new Move (this, x, y, x, y + i, true);
                        moves.add(theMove);
                    }
                    //Can't go through a piece so break out of loop
                    break;
                }
                //Not going through a piece and not out of bounds so valid move
                theMove = new Move (this, x, y, x, y + i, false);
                moves.add(theMove);
            }
        }

        //Left
        for (i = 0; i >= x; i++){
            //Check that the space in front is not out of range
            while (!(getBoard().outOfRange(x - i, y))){
                //Check if it is occupied
                if (getBoard().occupied(x - i, y)){
                    //Check the colour is the same
                    if (!(getColour() == getBoard().getPiece(x - i, y).getColour())){
                        //same colour so add to the array as valid move. Then break
                        theMove = new Move (this, x, y, x - i, y, true);
                        moves.add(theMove);
                    }
                    //Can't go through a piece so break out of loop
                    break;
                }
                //Not going through a piece and not out of bounds so valid move
                theMove = new Move (this, x, y, x - i , y, false);
                moves.add(theMove);
            }
        }

        //Right
        for (i = x; i < getBoard().getBOARD_SIZE() - 1; i++){
            //Check that the space in front is not out of range
            while (!(getBoard().outOfRange(x + i, y))){
                //Check if it is occupied
                if (getBoard().occupied(x + i, y)){
                    //Check the colour is the same
                    if (!(getColour() == getBoard().getPiece(x + i, y).getColour())){
                        //same colour so add to the array as valid move. Then break
                        theMove = new Move (this, x, y, x + i, y, true);
                        moves.add(theMove);
                    }
                    //Can't go through a piece so break out of loop
                    break;
                }
                //Not going through a piece and not out of bounds so valid move
                theMove = new Move (this, x, y, x + i, y, false);
                moves.add(theMove);
            }
        }
        return moves;
    }
}
