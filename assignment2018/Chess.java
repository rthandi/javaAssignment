package assignment2018;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

import java.util.Objects;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {

        Scanner readIn = new Scanner(System.in);

        System.out.println("What kind of player is player 1?");
        System.out.println("Type 1 for human. 2 for aggressive, or 3 for random");
        int player1Choice = readIn.nextInt();

        System.out.println("What kind of player is player 2?");
        System.out.println("Type 1 for human. 2 for aggressive, or 3 for random");
        int player2Choice = readIn.nextInt();


        Board board = new Board();
        Player player1;
        Player player2;
        if (player1Choice == 1){
            player1 = new HumanPlayer("name", new Pieces(board, 0), board, null);
        }
//        else if (Objects.equals(player1, "random")){
//            player1 = new RandomPlayer("name", new Pieces(board, 0), board, null);
//        }
        else {
            player1 = new RandomPlayer("name", new Pieces(board, 0), board, null);
        }
        if (player2Choice == 1){
            player2 = new HumanPlayer("name", new Pieces(board, 1), board, player1);
        }
        else {
            player2 = new RandomPlayer("name", new Pieces(board, 1), board, player1);
        }
        player1.setOpponent(player2);

        GraphicalDisplay display = new GraphicalDisplay(player1, player2);
        display.setVisible(true);
        display.setupBoard(player1.getPieces());
        display.setupBoard(player2.getPieces());
        display.revalidate();

        while (true) {
            if (display.getActivePlayer() == player1) {
                player1.makeMove();
                display.displayBoard(player1.getPieces());
                display.setActivePlayer(player2);
            } else {
                player2.makeMove();
                display.displayBoard(player2.getPieces());
                display.setActivePlayer(player1);
            }
        }
    }
}
