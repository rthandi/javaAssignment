package assignment2018;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Pieces;

public class TextDisplay implements Display {

    private Board board;

    @Override
    public void displayBoard(Pieces myPieces) {
        int x;
        int y;
        for (x = 0; x <= 7; x++){
            for (y = 0; y <= 7; y++){
                System.out.print();
            }
        }
    }
}
