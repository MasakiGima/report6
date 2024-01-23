package jp.ac.uryukyu.ie.e235702;

import java.util.ArrayList;

public class Player {
    
    String playerName;
    public ArrayList <Card> playerHands;

    public Player(String playerName){
        this.playerName = playerName;
        playerHands = new ArrayList<Card>();
    }
}
