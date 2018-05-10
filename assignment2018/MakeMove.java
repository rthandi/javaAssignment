package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Player;

import java.util.ArrayList;

public class MakeMove {
    public static boolean makeMove(Player player, int fromX, int fromY, int toX, int toY){
        //Loop through all pieces to find an available move
        ArrayList<Move> possibleMoves = new ArrayList<>();
        int i;
        for (i = 0; i < player.getPieces().getNumPieces(); i++) {
            while (possibleMoves.isEmpty()){
                ArrayList<Move> availableMoves;
                availableMoves = player.getPieces().getPiece(i).availableMoves();
                if(!(availableMoves.get(0) == null)){
                    possibleMoves.addAll(availableMoves);
                }
            }
        }
        //Validate inputs
        if (!(fromX == -1 || fromY == -1 || toX == -1 || toY == -1)) {
            Move inputMove = new Move(player.getBoard().getPiece(fromX, fromY), fromX, fromY, toX, toY, player.getBoard().occupied(toX, toY));
            //Check if move is possible
            if (player.getBoard().occupied(fromX, fromY) && player.getBoard().getPiece(fromX, fromY).availableMoves().contains(inputMove)) {
                if (player.getBoard().occupied(toX, toY)) {
                    //Delete piece from the opponent's piece collection
                    for (i = 0; i < player.getPieces().getNumPieces(); i++){
                        Piece currentPiece = player.getOpponent().getPieces().getPiece(i);
                        Piece pieceToDelete = null;
                        if (currentPiece.getX() == toX && currentPiece.getY() == toY){
                            pieceToDelete = currentPiece;
                        }
                        if (pieceToDelete != null){
                            player.getOpponent().deletePiece(pieceToDelete);
                            break;
                        }
                    }
                    //As it is a valid move we know that the piece can be taken if it is occupied
                    player.getBoard().removePiece(toX, toY);
                }
                //Move piece to the position
                player.getBoard().setPosition(toX, toY, player.getBoard().getPiece(fromX, fromY));
                //Remove piece from old position
                player.getBoard().removePiece(fromX, fromY);
                //Change the piece's position on the piece's object
                player.getBoard().getPiece(toX, toY).setPosition(toX, toY);
                return true;
            }
        }
        return false;
    }
}
