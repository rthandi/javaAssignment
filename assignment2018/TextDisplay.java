package assignment2018;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;

public class TextDisplay implements Display {

    public char[][] board = new char[8][8];

    @Override
    public void displayBoard(Pieces myPieces) {
        int i;
        int j;
        //Go through array and delete the piece if it is the colour of myPieces
        for(i = 0; i <= 7; i++){
            for(j=0; j <= 7; j++){
                //If white and colour of myPieces is white then replace with *
                if ((int)board[i][j] >= 97 || (int)board[i][j] <= 122 && myPieces.getPiece(0).getColour() == 1){
                    board[i][j] = '*';
                }
                //If black and colour of myPieces is black then replace with *
                else if ((int)board[i][j] >= 65 || (int)board[i][j] <= 90 && myPieces.getPiece(0).getColour() == 0){
                    board[i][j] = '*';
                }
            }
        }

        //Go through each piece and add the char to array
        for (i = 0; i < myPieces.getNumPieces(); i++){
            Piece currentPiece = myPieces.getPiece(i);
            //Add piececode to array
            board[currentPiece.getX()][currentPiece.getY()] = currentPiece.getChar();
        }

        //Print array to screen
        for(i = 0; i <= 7; i++) {
            System.out.println(i);
            for (j = 0; j <= 7; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
        }
    }

    public void cleanBoard() {
        int i;
        int j;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                board[i][j] = '*';
            }
        }
    }
}

