package fr.atelierjava.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Integer> hand;

    public String playe() {
        
        return "Hello Player";
    }
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

    public Player() {
    }


}