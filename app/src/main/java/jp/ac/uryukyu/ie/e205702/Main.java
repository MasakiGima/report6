package jp.ac.uryukyu.ie.e205702;

public class Main {
    public static void main(String[] arags){
        Babanuki babanuki = new Babanuki(); 
        babanuki.players[0] = new Player("player1");
        babanuki.players[1] = new Player("player2");
        babanuki.game();
        // babanuki.deliver();
        // babanuki.showTehuda1();
        // babanuki.beEqual1();
        // babanuki.showTehuda1();
    }
}
