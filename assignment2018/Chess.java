package assignment2018;

import assignment2018.codeprovided.Pieces;

public class Chess {
    public static void main(String[] args) {
        Board board = new Board();
        HumanPlayer player2;
        HumanPlayer player1 = new HumanPlayer("name", new Pieces(board, 0), board, null);
        player2 = new HumanPlayer("name", new Pieces(board, 0), board, player1);
        player1.setOpponent(player2);

        player1.makeMove();
    }
}
