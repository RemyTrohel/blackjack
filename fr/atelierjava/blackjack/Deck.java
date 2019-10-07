package fr.atelierjava.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Integer> cards;

    public Deck() {
    cards = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            cards.add(i);
            cards.add(i);
            cards.add(i);
            cards.add(i);
        }
        for (int i = 1; i <= 4; i++) {
            cards.add(10);
            cards.add(10);
            cards.add(10);
            cards.add(10);
        }
        Collections.shuffle(cards);
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void setCards(List<Integer> cards) {
        this.cards = cards;
    }
}