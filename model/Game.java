package model;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    public enum Words {

        communication, science, programming, language, difficulty, artificial, intelligence, attempts, screenshot,
        baseball, windows, learning, electronics, beautiful, internet, database, organization, application, network,
        friendly, validation, attemps, statistics, physics, chemistry, engineering, school, industry, revolution,
        progress, characters, heavily, graphics
    }

    private int health;
    private String gameKey;
    private ArrayList<Words> wordPool = new ArrayList<Words>();


    public Game() {

           gameKey = generateGameKey(); 
        
    }

    public String generateGameKey() {

        Random rand = new Random();

        for(var w : Words.values()) {
            
            wordPool.add(w);
        }

        return "" + wordPool.get(rand.nextInt(wordPool.size()));
        
    }
    
}
