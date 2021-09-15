package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.GameKeyListener;
import model.Game;

public class GamePanel {

    public enum GameState {

        READY, PLAYING, WIN, LOSE
    }

    private JFrame window;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();
    private ArrayList<JButton> alphaButtons = new ArrayList<JButton>();
    private JButton newButton = new JButton("New");
    private GameState gameState = GameState.PLAYING;
    private Game game = new Game();
    private GameCanvas canvas = new GameCanvas(this);
    
    

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

        gameKeyField.setFont(new Font("courier", Font.BOLD, 25));
        gameKeyField.setForeground(Color.red);
        guessField.setFont(new Font("courier", Font.BOLD, 25));
        guessField.setForeground(Color.black);

        northPanel.add(gameKeyField);
        northPanel.add(guessField);
        
        cp.add(BorderLayout.NORTH, northPanel);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        GameKeyListener keyListener = new GameKeyListener(this);

        for(int i = 0; i < 26; i++) {

            var temp = (char)(65 + i);
            var temp2 = Character.toLowerCase(temp);
            alphaButtons.add(new JButton( temp2 + ""));
            alphaButtons.get(i).setEnabled(false);
            
            //add key listener
            alphaButtons.get(i).addActionListener(keyListener);

            southPanel.add(alphaButtons.get(i));


        }


        //add new button last & keylistener
        newButton.addActionListener(keyListener);
        southPanel.add(newButton);

        cp.add(BorderLayout.SOUTH, southPanel);

        cp.add(BorderLayout.CENTER, canvas);     

    }

    public GameState getGameState() {

        return gameState;
    }

    public Game getGame() {

        return game;
    }
    
    public void setGame(Game game) {

        this.game = game;
    }

    public JTextField getGuessField() {

        return guessField;
    }

    public JTextField getGameKeyField() {

        return gameKeyField;
    }

    public ArrayList<JButton> getAlphaButtons() {

        return alphaButtons;
    }

    public JButton getNewButton(){

        return newButton;
    }

    public void setGameState(GameState state) {

        this.gameState = state;
    }

    public GameCanvas getCanvas() {
         
        return canvas;
    }

    
}
