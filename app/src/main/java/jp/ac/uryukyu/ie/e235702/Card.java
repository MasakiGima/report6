package jp.ac.uryukyu.ie.e235702;

public class Card {
    String suit;
    int number;
    int count;

    public Card(String _suit,int _number){
        this.suit = _suit;
        this.number = _number;
        this.count = 0;
    }

    /**
     * カードクラスで作られるカードを表示する時に一つの文字列にするためのメソッド
     * @return
     */
    public String display(){
        return this.suit + this.number;
    }

    /**
     * countを100に変えるためのメソッド
     * countは手札を捨てる時のために使うフィールド
     */
    public void set() {
        this.count = 100;
    }
}

