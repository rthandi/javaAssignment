package assignment2018;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GraphicalDisplay extends JFrame implements Display {

    final int DISPLAY_SIZE = 800;

    private Boolean moveToFlag = false;
    private int moveFromX;
    private int moveFromY;
    private Player activePlayer;
    private Player player1;
    private Player player2;

    private JButton[][] buttonArray = new JButton[8][8];

    public GraphicalDisplay(Player player1Input, Player player2Input){
        player1 = player1Input;
        player2 = player2Input;

        activePlayer = player1;

        setTitle("Chess - Robbie Thandi");
        setSize(DISPLAY_SIZE, DISPLAY_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8,8));

        //Create grid of buttons
        int i;
        int j;
        Color myPink = new Color(255,20,147);
        for (i = 0; i < 8 ; i++){
            for (j = 0; j < 8; j++){
                buttonArray[i][j] = new JButton();
                if (j % 2 == 0){
                    if (i % 2 == 0){
                        //White
                        buttonArray[i][j].setBackground(myPink);
                    }
                    else {
                        //Black
                        buttonArray[i][j].setBackground(Color.YELLOW);
                    }
                }
                else{
                    if (i % 2 == 0){
                        //Black
                        buttonArray[i][j].setBackground(Color.YELLOW);
                    }
                    else{
                        //White
                        buttonArray[i][j].setBackground(myPink);
                    }
                }
                contentPane.add(buttonArray[i][j]);
                int finalI = i;
                int finalJ = j;
                buttonArray[i][j].addActionListener(e -> {
                    if (!moveToFlag){
                        moveFromX = finalJ;
                        moveFromY = finalI;
                        moveToFlag = true;
                    }
                    else {
                        if(activePlayer.getPieces().getPiece(0).getColour() != activePlayer.getBoard().getPiece(moveFromX, moveFromY).getColour() || !MakeMove.makeMove(activePlayer, moveFromX, moveFromY, finalJ, finalI)){
                            System.out.println("Invalid move");
                        }
                        else {
                            if (activePlayer == player1){
                                displayBoard(player1.getPieces());
                                activePlayer = player2;
                            }
                            else{
                                displayBoard(player2.getPieces());
                                activePlayer = player1;
                            }
                        }
                        moveToFlag = false;
                    }
                });
            }
        }
        revalidate();
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(Player activePlayer) {
        this.activePlayer = activePlayer;
    }

    public void setupBoard(Pieces myPieces){
        int i;
        for (i = 0; i < myPieces.getNumPieces(); i++){
            Piece currentPiece = myPieces.getPiece(i);
            ImageIcon image = getImageIcon(currentPiece.getChar());
            if (image != null){
                buttonArray[currentPiece.getY()][currentPiece.getX()].setIcon(image);
                revalidate();
            }
        }
    }

    public ImageIcon getImageIcon(char pieceChar){
        ImageIcon image = null;
        switch (pieceChar){
            case 'p':
                image = new ImageIcon("assignment2018/img/WPawn.png", "wPawn");
                break;
            case 'n':
                image = new ImageIcon("assignment2018/img/WKnight.png", "wKnight");
                break;
            case 'b':
                image = new ImageIcon("assignment2018/img/WBishop.png", "wBishop");
                break;
            case 'r':
                image = new ImageIcon("assignment2018/img/WRook.png", "wRook");
                break;
            case 'q':
                image = new ImageIcon("assignment2018/img/WQueen.png", "wQueen");
                break;
            case 'k':
                image = new ImageIcon("assignment2018/img/WKing.png", "wKing");
                break;
            case 'P':
                image = new ImageIcon("assignment2018/img/BPawn.png", "bPawn");
                break;
            case 'N':
                image = new ImageIcon("assignment2018/img/BKnight.png", "bKnight");
                break;
            case 'B':
                image = new ImageIcon("assignment2018/img/BBishop.png", "bBishop");
                break;
            case 'R':
                image = new ImageIcon("assignment2018/img/BRook.png", "bRook");
                break;
            case 'Q':
                image = new ImageIcon("assignment2018/img/BQueen.png", "bQueen");
                break;
            case 'K':
                image = new ImageIcon("assignment2018/img/BKing.png", "bKing");
                break;
        }
        return image;
    }

    @Override
    public void displayBoard(Pieces myPieces) {
        //Find difference
        int i;
        for (i = 0; i < myPieces.getNumPieces(); i++){
            Piece currentPiece = myPieces.getPiece(i);
            if (buttonArray[currentPiece.getY()][currentPiece.getX()].getIcon() == null || !Objects.equals(((ImageIcon) buttonArray[currentPiece.getY()][currentPiece.getX()].getIcon()).getDescription().substring(0, 1), Character.toString(myPieces.getPiece(0).getColourChar()))){
                ImageIcon image = getImageIcon(currentPiece.getChar());
                buttonArray[currentPiece.getY()][currentPiece.getX()].setIcon(image);
                //Find where it was moved from
                int j;
                for (i = 0; i < 8; i++){
                    for (j = 0; j < 8; j++){
                        if (buttonArray[j][i].getIcon() != null && Objects.equals(image.getDescription(), ((ImageIcon) buttonArray[j][i].getIcon()).getDescription()) && !myPieces.getPiece(0).getBoard().occupied(i, j)){
                            System.out.println(i + " " + j);
                            buttonArray[j][i].setIcon(null);
                            revalidate();
                        }
                    }
                }
            }
        }
        revalidate();
    }
}
