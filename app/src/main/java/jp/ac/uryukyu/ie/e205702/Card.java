package jp.ac.uryukyu.ie.e205702;

public class Card {
    String suit;
    int number;
    int count;

    public Card(String _suit,int _number){
        this.suit = _suit;
        this.number = _number;
        this.count = 0;
    }

    public String display(){
        return this.suit + this.number;
    }

    public void set() {
        this.count = 100;
    }
}

