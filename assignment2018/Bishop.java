package assignment2018;

import assignment2018.codeprovided.Piece;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(int i, int ix, int iy, int c, Board b) {
        super(i, ix, iy, c, b);
    }

    @Override
    public ArrayList<Move> availableMoves() {
        // obtain current co-ordinates
        int x = this.getX();
        int y = this.getY();

        Move theMove;
        ArrayList<Move> moves = new ArrayList<>();
    }
}
