package assignment2018;

import assignment2018.codeprovided.Pieces;

public class Chess {

    public static void main(String[] args) {
        Board board = new Board();
        HumanPlayer player2;
        HumanPlayer player1 = new HumanPlayer("name", new Pieces(board, 1), board, null);
        player2 = new HumanPlayer("name", new Pieces(board, 0), board, player1);
        player1.setOpponent(player2);
//
//        TextDisplay display = new TextDisplay();
////        display.cleanBoard();
//        display.displayBoard(player1.getPieces());
//
//        while (true){
//            player1.makeMove();
//            display.displayBoard(player1.getPieces());
//            player2.makeMove();
//            display.displayBoard(player2.getPieces());
//        }


        GraphicalDisplay display = new GraphicalDisplay();
        display.setupBoard(player1.getPieces());
        display.setupBoard(player2.getPieces());

    }
}
