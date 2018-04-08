package assignment2018;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;

import java.util.ArrayList;

public class TextDisplay implements Display {

    @Override
    public void displayBoard(Pieces myPieces) {

        Board board = myPieces.getPiece(0).getBoard();

        int i;
        int j;
        //Print board to screen
        for(i = 0; i <= 7; i++) {
            System.out.println("");
            for (j = 0; j <= 7; j++) {
                //Check if square is empty
                if (board.occupied(j, i)){
                    System.out.print(" " + board.getBoard()[j][i].getChar() + " ");
                }
                else{
                    System.out.print(" * ");
                }
            }
            System.out.print(" " +  (8-i) );
        }
        System.out.println("");
        System.out.println(" a  b  c  d  e  f  g  h");
        System.out.println("");
    }
}

