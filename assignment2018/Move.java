package assignment2018;

import assignment2018.codeprovided.Piece;

public class Move {

    private int currentX;
    private int currentY;
    private int targetX;
    private int targetY;
    private boolean occupied;
    private Piece piece;

    public Move(Piece inputPiece, int inputCurrentX, int inputCurrentY, int inputTargetX, int inputTargetY, boolean inputOccupied){
        piece = inputPiece;
        currentX = inputCurrentX;
        currentY = inputCurrentY;
        targetX = inputTargetX;
        targetY = inputTargetY;
        occupied = inputOccupied;
    }
}
