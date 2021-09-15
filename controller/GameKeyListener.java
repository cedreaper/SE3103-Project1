package controller;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Game;
import view.GamePanel;
import view.GamePanel.GameState;

import java.awt.event.ActionEvent;

public class GameKeyListener implements ActionListener {

    private GamePanel panel;
    private int clicks = 0;

    public GameKeyListener(GamePanel panel) {

        this.panel = panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton) e.getSource();

        if(button == panel.getNewButton()) {

            //if we click the new button  NEW game begins

            var game = new Game();
            panel.setGame(game);
           

            //first I will enable all the buttons and set the gamestate to playing

            for(var b: panel.getAlphaButtons()) {

                b.setEnabled(true);
            }

            panel.setGameState(GameState.PLAYING);
            
            panel.getGameKeyField().setText(panel.getGame().getGameKey());
            
            panel.getGuessField().setText(panel.getGame().getGuess());

        } else {
            //alphabet button pressed.. then we can accumulate and solve

            //first check for if we lose or are still playing

            if(panel.getGame().getHealth() > 0) {

                //health is left still then we are still playing the game.. but did we win?

                if(panel.getGameKeyField().getText() != null) {

                    if(panel.getGame().getGuess().equals(panel.getGame().getGameKey())) {
                        
                        //if they're the same then we found a winner!
                        panel.setGameState(GameState.WIN);
                        panel.getCanvas().repaint();

                            
                    } else {

                        //ok maybe we didn't yet win, ..so we need to modify somethings now and disable the button
                        
                        button.setEnabled(false);
                        
                        // does the button chose match any character in the game key?
                        
                        char ch = button.getText().charAt(0);

                        //no? Well then 1 health is being taken away.
                        if(!panel.getGame().setGuess(ch)) {

                            panel.getGame().setHealth(panel.getGame().getHealth() - 1);

                            //if health is now 0 then set game over
                            if(panel.getGame().getHealth() == 0) {
                                
                                panel.setGameState(GameState.LOSE);
                            }
                          
                            
                        }

                        panel.getGuessField().setText(panel.getGame().getGuess());

                        panel.getCanvas().repaint();
  
                    }
                }
            }
            else if(panel.getGame().getHealth() == 0) {

                //out of health, then game over

                panel.setGameState(GameState.LOSE);
            }

        }

        
    }
    
}
