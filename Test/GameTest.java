package Test;

import model.Game;

public class GameTest {

    public static void main(String[] args) {

        //test game key random generation

        String gameKey;

        for(int i = 0; i < 10; i++) {

            Game g = new Game();
            gameKey = g.getGameKey();

            System.out.println(gameKey);

        }

        //test setting guesses to swap characters

        Game g = new Game("reel", "....");
        g.setGuess('e');

    }
    
}
