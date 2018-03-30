package assignment2018;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;

public class Chess {
    public static void main(String[] args) {
        Board board = new Board();
        Pieces pieces = new Pieces(board, 1);
        System.out.println(pieces);
    }
}
