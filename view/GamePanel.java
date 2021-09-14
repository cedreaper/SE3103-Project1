package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Game;

public class GamePanel {

    public enum GameState {

        READY, PLAYING, GAMEOVER
    }
    private JFrame window;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private ArrayList<JButton> alphaButtons = new ArrayList<JButton>();
    private JButton newButton = new JButton("New");
    private GameState gameState = GameState.READY;
    private Game game;
    
    

    public GamePanel(JFrame window) {

        this.window = window;
    }

    public void init() {

        Container cp = window.getContentPane();
        window.setTitle("Project1: Word Guessing Game");

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));

        gameKeyField.setEditable(false);
        guessField.setEditable(false);

        northPanel.add(gameKeyField);
        northPanel.add(guessField);
        
        cp.add(BorderLayout.NORTH, northPanel);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        for(int i = 0; i < 26; i++) {

            var temp = (char)(65 + i);
            var temp2 = Character.toLowerCase(temp);
            alphaButtons.add(new JButton( temp2 + ""));
            System.out.println(alphaButtons.get(i).getText());

            alphaButtons.get(i).setEnabled(false);

            southPanel.add(alphaButtons.get(i));


        }

        southPanel.add(newButton);

        cp.add(BorderLayout.SOUTH, southPanel);



        

    }

    
}
