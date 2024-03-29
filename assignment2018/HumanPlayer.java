package assignment2018;

import assignment2018.codeprovided.Piece;
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
        Scanner input = new Scanner(System.in);

        boolean flag = false;

        while (!flag) {
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

            if (MakeMove.makeMove(this, fromX, fromY,toX, toY)){
                flag = true;
            }
            else{
                System.out.println("Invalid move. Try again");
            }
        }
        return true;
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
