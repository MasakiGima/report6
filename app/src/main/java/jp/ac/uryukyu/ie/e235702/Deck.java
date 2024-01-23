package jp.ac.uryukyu.ie.e235702;

import java.util.ArrayList;

public class Deck {
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    int[] number = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    public ArrayList <Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        for (String suit : suits) {
            for (int number : number) {
                deck.add(new Card(suit, number));
            } 
        }
        deck.add(new Card("joker",0));
    }

    

    public void showDeck(){
        for(Card c: deck){
            System.out.println(c.number);
            System.out.println(c.suit);
        }
    }
}
