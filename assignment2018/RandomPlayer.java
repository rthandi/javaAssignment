package assignment2018;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

import java.util.ArrayList;

public class RandomPlayer extends Player {
    public RandomPlayer(String n, Pieces p, Board b, Player o) {
        super(n, p, b, o);
    }

    @Override
    public boolean makeMove() {
        //Loop through all pieces to find an available move
        ArrayList<Move> possibleMoves = new ArrayList<>();
        int i;
        for (i = 0; i < getPieces().getNumPieces(); i++) {
            System.out.println(i);
//            while (possibleMoves.isEmpty()) {
                ArrayList<Move> availableMoves;
                availableMoves = getPieces().getPiece(i).availableMoves();
                if (availableMoves != null) {
                    possibleMoves.addAll(availableMoves);
                    System.out.println(possibleMoves);
                }
//            }
        }
        int randomMove = (int) (Math.random() * possibleMoves.size() - 1);
        Move theMove = possibleMoves.get(randomMove);
        MakeMove.makeMove(this, theMove.getCurrentX(), theMove.getCurrentY(), theMove.getTargetX(), theMove.getTargetY());
        return true;
    }
}
