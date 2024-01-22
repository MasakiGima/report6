package jp.ac.uryukyu.ie.e205702;

import java.util.ArrayList;

public class Player {
    
    String playerName;
    public ArrayList <Card> playerHands;

    Player(String playerName){
        this.playerName = playerName;
        playerHands = new ArrayList<Card>();
    }
}
