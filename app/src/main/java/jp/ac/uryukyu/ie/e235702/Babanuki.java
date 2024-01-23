package jp.ac.uryukyu.ie.e235702;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Babanuki{
    Deck deck1 = new Deck();
    public Player players[] = new Player[2];

    //手札の配布
    public void deliver(){
        for(int i = 0;i < 26;i++){
            for (Player player : players) {
                Random random = new Random();
                int rn = random.nextInt(deck1.deck.size());
                player.playerHands.add(deck1.deck.get(rn));
                deck1.deck.remove(rn);
            }
        }
        Random random = new Random();
        int rd = random.nextInt(2);
        players[rd].playerHands.add(deck1.deck.get(0));

    }

    //プレイヤーの手札を確認するメソッド
    public void showTehuda1(){
        ArrayList <String> myCard;
        myCard = new ArrayList<String>();
        for(Card c: players[0].playerHands){
            myCard.add(c.display());
        }
        System.out.println(myCard);
    }

        public void tehudaCard(Card i){
        System.out.println(i.display());
        }

    public void beEqual1(){
        for(int i = 0; i < players[0].playerHands.size();i++){
                for(int j = i + 1; j < players[0].playerHands.size();j++){
                    if(players[0].playerHands.get(i).count != 100){
                        if(players[0].playerHands.get(i).number == players[0].playerHands.get(j).number){
                            players[0].playerHands.get(i).set();
                            players[0].playerHands.get(j).set();
                        }
                    }
                }
            }
        ArrayList<Card> set = new ArrayList<Card>(); 
        for(int i = 0; i <players[0].playerHands.size(); i++){
            if(players[0].playerHands.get(i).count == 100){
            set.add(players[0].playerHands.get(i));
            }
        }
        players[0].playerHands.removeAll(set);
    }

    public void beEqual2(){
        for(int i = 0; i < players[1].playerHands.size();i++){
            for(int j = i + 1; j < players[1].playerHands.size();j++){
                if(players[1].playerHands.get(i).count != 100){
                    if(players[1].playerHands.get(i).number == players[1].playerHands.get(j).number){
                        players[1].playerHands.get(i).set();
                        players[1].playerHands.get(j).set();
                    }
                }
            }
        }
        ArrayList<Card> set = new ArrayList<Card>(); 
        for(int i = 0; i <players[1].playerHands.size(); i++){
            if(players[1].playerHands.get(i).count == 100){
            set.add(players[1].playerHands.get(i));
            }
        }
        players[1].playerHands.removeAll(set);
    }

    //ゲームを行っている人がカードを引くメソッド
    public void draw1(){
        Scanner card1 = new Scanner(System.in);
        System.out.printf("コンピューターはカードを%d枚持っています。何番目のカードを引きますか,指定できる番号は0番から%d番までです。",players[1].playerHands.size(),players[1].playerHands.size()-1);
        System.out.println("引きたいカードはコンピューターが持っている何番目のカードか入力してください");
        int n = card1.nextInt();
        System.out.println("引いたカードはこちらです");
        enter();
        tehudaCard(players[1].playerHands.get(n));//引いたカードを見るための文
        players[0].playerHands.add(players[1].playerHands.get(n));
        players[1].playerHands.remove(n);
        enter();
        System.out.println("自分の手札を確認してください");
        enter();
    }

    //コンピューターがカードを引くメソッド
    public void draw2(){
        Random card2 = new Random();
        int s = card2.nextInt(players[0].playerHands.size());
        if(s == players[0].playerHands.size() ){
            s -= 1;
        }
        players[1].playerHands.add(players[0].playerHands.get(s));
        System.out.println("コンピューターが引いたカードはこちらです");
        enter();
        tehudaCard(players[0].playerHands.get(s));
        players[0].playerHands.remove(s);
        enter();
        System.out.println("コンピューターが引いた後の自分の手札を確認します");
        showTehuda1();
    }

    //Enterを押すと次に進むメソッド
    //何度か使いたいため、メソッド化しました
    public void enter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        String c = sc.nextLine();
    }

    public void finish(){
        System.out.println("ゲーム終了");
    }

    public void winner(){
        if(players[0].playerHands.size() == 0){
            System.out.println("勝者はプレイヤー1です。");
        }else{
            System.out.println("勝者はコンピューターです。");
        }
    }

    public void repetition(){
        Scanner sc = new Scanner(System.in);
        String yes = "はい";
        System.out.println("”はい”と入力していただければコンピューターが同じ番号のカードを選んで捨ててくれます");
        while (true) {
            if(sc.hasNextLine()){
                String c = sc.nextLine();
                if(c.equals(yes)){
                    break;
                }else{
                    System.out.println("申し訳ございませんが同じ番号のカードがあなたの手札の中に存在しているので、”はい”と入力してください");
                }
            }
        }
    }

    //ゲームの初めは必ずプレイヤーから引くところからゲームスタートとする
    //コンピューターは初めは引かれる
    public  void game(){
        System.out.println("ゲームスタートです");
        System.out.println("あなたの名前は" + players[0].playerName + "です");
        System.out.println("まず初めにカードを配ります");
        Scanner s = new Scanner(System.in);
        System.out.println("Enterを押すと次に進みます。");
        System.out.println("次からゲームが止まった時はEnterを押すと続きます");
        String cs = s.nextLine();
        deliver();
        System.out.println("自分の手札を確認してください");
        showTehuda1();
        enter();
        System.out.println("同じカードがあったら捨てますがよろしいですか");
        repetition();
        beEqual1();
        beEqual2();
        System.out.println("捨てた後の手札がこちらです");
        enter();
        showTehuda1();
        enter();
        System.out.println("ここからババ抜きを始めたいと思います");
        while (players[0].playerHands.size() > 0 || players[1].playerHands.size() > 0) {
            System.out.println(players[0].playerName + "が引く番です");
            draw1();
            for(int i = 0;i < players[0].playerHands.size()-1;i++){
                if(players[0].playerHands.get(i).number == players[0].playerHands.get(players[0].playerHands.size()-1).number){
                    System.out.println("同じ番号のカードがありました。捨ててもよろしいですか");
                    break;
                }
            }
            repetition();
            beEqual1();if(players[0].playerHands.size() == 0 || players[1].playerHands.size() == 0){
                break;
            }
            showTehuda1();
            System.out.println("コンピューターが引く番です");
            draw2();
            beEqual2();
            if(players[0].playerHands.size() == 0 || players[1].playerHands.size() == 0){
                break;
            }
        }
        finish();
        winner();
    }
}
    

