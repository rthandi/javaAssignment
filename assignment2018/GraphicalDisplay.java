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


        contentPane.removeAll();
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
            ImageIcon image = null;
            switch (currentPiece.getChar()){
                case 'p':
                    image = new ImageIcon("assignment2018/img/WPawn");
                    break;
                case 'n':
                    image = new ImageIcon("assignment2018/img/WKnight");
                    break;
                case 'b':
                    image = new ImageIcon("assignment2018/img/WBishop");
                    break;
                case 'r':
                    image = new ImageIcon("assignment2018/img/WRook");
                    break;
                case 'q':
                    image = new ImageIcon("assignment2018/img/WQueen");
                    break;
                case 'k':
                    image = new ImageIcon("assignment2018/img/WKing");
                    break;
                case 'P':
                    image = new ImageIcon("assignment2018/img/BPawn");
                    break;
                case 'N':
                    image = new ImageIcon("assignment2018/img/BKnight");
                    break;
                case 'B':
                    image = new ImageIcon("assignment2018/img/BBishop");
                    break;
                case 'R':
                    image = new ImageIcon("assignment2018/img/BRook");
                    break;
                case 'Q':
                    image = new ImageIcon("assignment2018/img/BQueen");
                    break;
                case 'K':
                    image = new ImageIcon("assignment2018/img/BKing");
                    break;
            }
            if (image != null){
                buttonArray[currentPiece.getX()][currentPiece.getY()] = new JButton(image);

            }
        }
    }

    @Override
    public void displayBoard(Pieces myPieces) {
        System.out.println("hbfha");
    }
}
