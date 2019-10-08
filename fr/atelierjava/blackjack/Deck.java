package fr.atelierjava.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {

    public static List<Integer> createDeck() {

        List<Integer> cards = new ArrayList<Integer>();

        for(int i =0; i< 4; i++) {
            for(int j = 1; j < 14; j++)
            {
                cards.add(i,j);
            }
        }
        Collections.shuffle(cards);
        return cards;
    }
    
 }