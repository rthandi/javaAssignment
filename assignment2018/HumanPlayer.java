package assignment2018;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String n, Pieces p, Board b, Player o) {
        super(n, p, b, o);
    }

    @Override
    public boolean makeMove() {

        //Loop through all pieces to find an available move
        ArrayList<Move> possibleMoves = new ArrayList<>();
        int i;
        for (i = 0; i <= getPieces().getNumPieces() - 1; i++) {
            while (possibleMoves.isEmpty()){
                possibleMoves.addAll(getPieces().getPiece(i).availableMoves());
            }
        }

        //Check if there are possible moves
        if (possibleMoves.isEmpty()) {
            return false;
        } else {
            Move inputMove;
            Scanner input = new Scanner(System.in);

            while (true) {
                //Get move from the user
                System.out.println("What position is the piece you'd like to move in?");
                String moveFrom = input.next();
                System.out.println("Where would you like to move this piece?");
                String moveTo = input.next();

                //Convert inputs into ints
                int fromX = getLetterAsNumber(moveFrom);
                int fromY = getNumber(moveFrom);
                int toX = getLetterAsNumber(moveTo);
                int toY = getNumber(moveTo);

                //Validate inputs
                if (!(fromX == -1 && fromY == -1 && toX == -1 && toY == -1)) {
                    inputMove = new Move(getBoard().getPiece(fromX, fromY), fromX, fromY, toX, toY, getBoard().occupied(toX, toY));
                    //Check if move is possible
                    if (getBoard().getPiece(fromX, fromY).availableMoves().contains(inputMove)) {
                        if (getBoard().occupied(toX, toY)) {
                            //Delete piece from the opponent's piece collection
                            getOpponent().deletePiece(getBoard().getPiece(toX, toY));
                            //As it is a valid move we know that the piece can be taken if it occupied
                            getBoard().removePiece(toX, toY);
                        }
                        //Move piece to the position
                        getBoard().setPosition(toX, toY, getBoard().getPiece(fromX, fromY));
                        //Remove piece from old position
                        getBoard().removePiece(fromX, fromY);
                        //Change the piece's position on the piece's object
                        getBoard().getPiece(toX, toY).setPosition(toX, toY);
                        return true;
                    }
                }
                System.out.println("Invalid move. Try again");
            }
        }
    }

    public int getLetterAsNumber(String input) {
        String inputLetter = input.substring(0, 1);
        inputLetter = inputLetter.toLowerCase();

        //Starts at 0 so it can be used in array
        int letterAsNumber;
        switch (inputLetter) {
            case "a":
                letterAsNumber = 0;
                break;
            case "b":
                letterAsNumber = 1;
                break;

            case "c":
                letterAsNumber = 2;
                break;
            case "d":
                letterAsNumber = 3;
                break;
            case "e":
                letterAsNumber = 4;
                break;
            case "f":
                letterAsNumber = 5;
                break;
            case "g":
                letterAsNumber = 6;
                break;
            case "h":
                letterAsNumber = 7;
                break;
            default:
                //-1 used for validation
                letterAsNumber = -1;
                break;
        }

        return letterAsNumber;
    }

    public int getNumber(String input) {
        String numberAsString = input.substring(1, 2);
        int number = Integer.parseInt(numberAsString);
        //Adjust so it can be used in array
        number--;
        //Need to flip values due to Array coordinates starting in top and chess coordinates starting from the bottom
        int flippedNumber;
        switch (number) {
            case 0:
                flippedNumber = 7;
                break;
            case 1:
                flippedNumber = 6;
                break;
            case 2:
                flippedNumber = 5;
                break;
            case 3:
                flippedNumber = 4;
                break;
            case 4:
                flippedNumber = 3;
                break;
            case 5:
                flippedNumber = 2;
                break;
            case 6:
                flippedNumber = 1;
                break;
            case 7:
                flippedNumber = 0;
                break;
            default:
                //-1 used for validation
                flippedNumber = -1;
        }
        return flippedNumber;
    }
}
