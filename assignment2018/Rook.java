package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

import java.util.ArrayList;

public class Rook extends Piece {
    @Override
    public ArrayList<Move> availableMoves() {
        if (getColour() == PieceCode.WHITE)
            return whiteRook();
        else
            return blackRook();
    }

    private ArrayList<Move> whiteRook(){

    }
}
