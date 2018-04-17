package assignment2018;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Pieces;

import javax.swing.*;
import java.awt.*;

public class GraphicalDisplay extends JFrame implements Display {

    final int DISPLAY_SIZE = 800;

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
                JButton button = new JButton();
                if (j % 2 == 0){
                    if (i % 2 == 0){
                        //White
                        button.setBackground(myPink);
                    }
                    else {
                        //Black
                        button.setBackground(Color.YELLOW);
                    }
                }
                else{
                    if (i % 2 == 0){
                        //Black
                        button.setBackground(Color.YELLOW);
                    }
                    else{
                        //White
                        button.setBackground(myPink);
                    }

                }
                contentPane.add(button);
            }
        }
        revalidate();
    }

    public void setupBoard(Pieces myPieces){
        int i;
        int j;


        for (i = 0; i <= 8; i++){
            for (j = 0; j <= 8; j++){

            }
        }

    }

    @Override
    public void displayBoard(Pieces myPieces) {

    }
}
