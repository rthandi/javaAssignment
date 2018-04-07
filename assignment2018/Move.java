package assignment2018;

import assignment2018.codeprovided.Piece;

public class Move {

    private int currentX;
    private int currentY;
    private int targetX;
    private int targetY;
    private boolean occupied;
    private Piece piece;

    public Move(Piece inputPiece, int inputCurrentX, int inputCurrentY, int inputTargetX, int inputTargetY, boolean inputOccupied) {
        piece = inputPiece;
        currentX = inputCurrentX;
        currentY = inputCurrentY;
        targetX = inputTargetX;
        targetY = inputTargetY;
        occupied = inputOccupied;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public boolean equals(Object otherObj){

        boolean same = false;

        if(otherObj != null && otherObj instanceof Move){
            same = (this.currentX == ((Move) otherObj).getCurrentX()) && (this.currentY == ((Move) otherObj).getCurrentY()) && (this.targetX == ((Move) otherObj).getTargetX()) && (this.targetY == ((Move) otherObj).getTargetY()) && (this.occupied == ((Move) otherObj).isOccupied());
        }
        return same;
    }
}
