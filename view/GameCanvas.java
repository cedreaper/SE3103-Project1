package view;

import java.awt.Dimension;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JPanel;

public class GameCanvas extends JPanel{
    
    public static int HEIGHT = 500;
    public static int WIDTH = 500;

    private GamePanel panel;

    public GameCanvas(GamePanel panel) {

        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;

        GamePanel.GameState state = panel.getGameState();

        if(state == GamePanel.GameState.READY) {

            g2.setColor(Color.green);
            g2.setFont(new Font("Courier", Font.BOLD, 30));

            g2.drawString("Click <New> to begin game", 40, 150);
          
        }
        else {

            if(state == GamePanel.GameState.LOSE) {
                
                g2.setColor(Color.red);
                g2.setFont(new Font("Courier", Font.BOLD, 30));
                g2.drawString("You Lose", 40, 100);

                g2.setColor(Color.green);
                g2.setFont(new Font("Courier", Font.BOLD, 30));

                g2.drawString("Click <New> to begin game", 40, 150);
                
            } 
            else if(state == GamePanel.GameState.WIN) {

                g2.setColor(Color.blue);
                g2.setFont(new Font("Courier", Font.BOLD, 30));
                g2.drawString("You Win", 40, 100);

                g2.setColor(Color.green);
                g2.setFont(new Font("Courier", Font.BOLD, 30));

                g2.drawString("Click <New> to begin game", 40, 150);

            } 
            else {

                //game is playing then draw what we need

                g2.setColor(Color.blue);
                g2.setFont(new Font("courier", Font.BOLD, 30));
                g2.drawString("Health: ", 50, 120);
                
                for(int i = 0; i < panel.getGame().getHealth(); i++){

                    g2.fillRect( 50 + (40 * i), 140, 30, 30);

                }

            }


            
        }
    }
}
