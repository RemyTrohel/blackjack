package fr.atelierjava.blackjack;

import java.util.List;

public class Play {

    public static void main(String[] args) {

    List<Integer> cards = Deck.createDeck();
    Player playerOne = new Player("Fufu");

    // TO DO Piocher 1 carte / supprimer une carte dans la liste
    int getCard = 0;
    
    for(int i =0; i <cards.size(); i++) {
      getCard = cards.get(i);
    }

    playerOne.getHand().add(getCard);
    cards.remove(getCard);
    System.out.println("Voici votre main "+playerOne.getHand());
    System.out.println("Cartes réstante dans le paquet : "+cards);
    }

}