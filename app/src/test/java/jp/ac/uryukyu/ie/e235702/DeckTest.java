package jp.ac.uryukyu.ie.e235702;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testDeckSize() {
        // デッキのサイズが52 + 1（ジョーカー）であることを確認
        assertEquals(53, deck.deck.size());
    }

    @Test
    public void testCardNumbers() {
        // デッキの各カードの数字が正しい範囲であることを確認
        for (Card card : deck.deck) {
            assertTrue(card.number >= 0 && card.number <= 13);
        }
    }

    @Test
    public void testCardSuits() {
        // デッキの各カードのスートが正しいものであることを確認
        String[] expectedSuits = {"Hearts", "Diamonds", "Clubs", "Spades", "joker"};
        for (Card card : deck.deck) {
            assertTrue(Arrays.asList(expectedSuits).contains(card.suit));
        }
    }

    @Test
    public void testShowDeck() {
        // showDeckメソッドがエラーなく実行されることを確認
        deck.showDeck();
    }
}
