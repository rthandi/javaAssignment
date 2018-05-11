package assignment2018;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PlayerSelector extends JFrame{

    private final int DISPLAY_SIZE = 400;

    private String[] playersArray = new String[2];

    public PlayerSelector(){
        setTitle("Player Selector - Robbie Thandi");
        setSize(DISPLAY_SIZE, DISPLAY_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Container contentPane = getContentPane();

        JButton human = new JButton("Human");
        JButton random = new JButton("Random");
        JButton aggressive = new JButton("Aggressive");

        contentPane.add(human);
        contentPane.add(random);
        contentPane.add(aggressive);

        human.setBounds(100, 100, 100, 50);

        human.addActionListener(e -> {
            if (playersArray[0] == null){
                playersArray[0] = "human";
            }
            else{
                playersArray[1] = "human";
                dispose();
            }
        });

        random.setBounds(200, 100, 100, 50);
        random.addActionListener(e -> {
            if (playersArray[0] == null){
                playersArray[0] = "random";
            }
            else{
                playersArray[1] = "random";
                dispose();
            }
        });
        aggressive.setBounds(300, 100, 100, 50);
    }

    public String[] getPlayersChoice(){
        return playersArray;
    }
}
