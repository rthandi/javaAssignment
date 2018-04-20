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
                ImageIcon image = new ImageIcon("img/WPawn");
                buttonArray[i][j] = new JButton(image);
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
            switch (currentPiece.getChar()){
                case 'p':
                    ImageIcon image = new ImageIcon("img/WPawn");
                    buttonArray[currentPiece.getX()][currentPiece.getY()] = new JButton(image);
            }
        }
    }

    @Override
    public void displayBoard(Pieces myPieces) {
        System.out.println("hbfha");
    }
}
