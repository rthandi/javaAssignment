package assignment2018;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;

import javax.swing.*;
import java.awt.*;

public class GraphicalDisplay extends JFrame implements Display {

    final int DISPLAY_SIZE = 800;

    private JButton[][] buttonArray = new JButton[8][8];

    public GraphicalDisplay(){
        setTitle("Chess");
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
            }
        }
        revalidate();
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
                image = new ImageIcon("assignment2018/img/WPawn.png");
                break;
            case 'n':
                image = new ImageIcon("assignment2018/img/WKnight.png");
                break;
            case 'b':
                image = new ImageIcon("assignment2018/img/WBishop.png");
                break;
            case 'r':
                image = new ImageIcon("assignment2018/img/WRook.png");
                break;
            case 'q':
                image = new ImageIcon("assignment2018/img/WQueen.png");
                break;
            case 'k':
                image = new ImageIcon("assignment2018/img/WKing.png");
                break;
            case 'P':
                image = new ImageIcon("assignment2018/img/BPawn.png");
                break;
            case 'N':
                image = new ImageIcon("assignment2018/img/BKnight.png");
                break;
            case 'B':
                image = new ImageIcon("assignment2018/img/BBishop.png");
                break;
            case 'R':
                image = new ImageIcon("assignment2018/img/BRook.png");
                break;
            case 'Q':
                image = new ImageIcon("assignment2018/img/BQueen.png");
                break;
            case 'K':
                image = new ImageIcon("assignment2018/img/BKing.png");
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
            if (buttonArray[currentPiece.getY()][currentPiece.getX()].getIcon() == null){
                ImageIcon image = getImageIcon(currentPiece.getChar());
                buttonArray[currentPiece.getY()][currentPiece.getX()].setIcon(image);
                //Find where it was moved from
                int j;
                for (i = 0; i < 8; i++){
                    for (j = 0; j < 8; j++){
                        if (buttonArray[i][j].getIcon().equals(image) && myPieces.getPiece(0).getBoard().occupied(j, i) && myPieces.getPiece(0).getBoard().getPiece(j, i) == null){
                            buttonArray[i][j].setIcon(null);
                        }
                    }
                }
            }
        }
        revalidate();
    }
}
