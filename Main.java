import javax.swing.JFrame;

import view.GamePanel;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(450, 100);
        
        var  gameView = new GamePanel(window);
        gameView.init();
        window.pack();
        window.setVisible(true);
    }
}