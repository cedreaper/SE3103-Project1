package model;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private enum Words {

        communication, science, programming, language, difficulty, artificial, intelligence, attempts, screenshot,
        baseball, windows, learning, electronics, beautiful, internet, database, organization, application, network,
        friendly, validation, attemps, statistics, physics, chemistry, engineering, school, industry, revolution,
        progress, characters, heavily, graphics
    }

    private int health;
    private String gameKey;
    private String guess = "";
    private ArrayList<Words> wordPool = new ArrayList<Words>();


    public Game() {

           gameKey = generateGameKey(); 
           health = 5;
           
           //special case for the guess keyfield add periods in place of same letter
           for(int i = 0; i < gameKey.length(); i++) {

            guess += ".";

            }
        
    }

    public Game(String gameKey, String guess) {

        this.gameKey = gameKey;
        this.guess = guess;
    }

    public String generateGameKey() {

        Random rand = new Random();

        for(var w : Words.values()) {
            
            wordPool.add(w);
        }

        return "" + wordPool.get(rand.nextInt(wordPool.size()-1));
        
    }
    
    public int getHealth() {

        return health;
    }

    public String getGameKey() {

        return gameKey;
    }

    public String getGuess() {

        return guess;
    }

    public void setHealth(int health) {

        this.health = health;
    }

    public boolean setGuess(char ch) {

        char[] tempKey = gameKey.toCharArray();
        char[] temp = guess.toCharArray();

        boolean flag = false;

        for(int i = 0; i < guess.length(); i++) {

            if(tempKey[i] == ch) {

                temp[i] = ch;

                flag = true;
            }
        }

        guess = new String(temp);

        return flag;
    }
}
