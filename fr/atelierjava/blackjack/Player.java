package fr.atelierjava.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Integer> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getHand() {
        return hand;
    }

    public void setHand(List<Integer> hand) {
        this.hand = hand;
    }

    public int getTotal(boolean higherAce) {
        int total = 0;
        for (int card : hand) {
            if (card == 1 && higherAce) {
                card = 11;
            }
            total += card;
        }
        return total;
    }

    public int getBestResult() {
        return this.getTotal(true) <= 21 ? this.getTotal(true) : this.getTotal(false);
    }

    public String showHand() {
        String result = "";
        for (int card : hand) {
            result += card + " ";
        }
        return result;
    }
}