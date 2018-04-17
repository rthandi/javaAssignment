package assignment2018;

import javax.swing.*;
import java.awt.*;

public class GraphicalDisplay extends JFrame {

    final int DISPLAY_SIZE = 800;

    public GraphicalDisplay(){
        setTitle("Chess");
        setSize(DISPLAY_SIZE, DISPLAY_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8,8));

        //Create grid of buttons
        int i;
        for (i = 0; i <= 64; i++){
            contentPane.add(new JButton());
        }
        revalidate();
    }
}
