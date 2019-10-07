package fr.atelierjava.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Integer> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void setCards(List<Integer> cards) {
        this.cards = cards;
    }

    public int getTotal(boolean higherAce) {
        int total = 0;
        for (int card : cards) {
            if (card == 1 && higherAce) {
                card = 11;
            }
            total += card;
        }
        return total;
    }

    public int getBestResult() {
        return this.getTotal(true) < 21 ? this.getTotal(true) : this.getTotal(false);
    }

    public String showHand() {
        String hand = "";
        for (int card : cards) {
            hand += card + " ";
        }
        return hand;
    }
}