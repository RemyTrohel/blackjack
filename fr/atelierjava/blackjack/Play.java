package fr.atelierjava.blackjack;

import java.util.List;
import java.util.Scanner;

public class Play {
    private Deck deck;
    private Player[] opponents;

    static Scanner scanner = new Scanner(System.in);

    public Play() {
        this.deck = new Deck();
        Player dealer = new Player("Dealer");
        Player player = new Player("Player");
        Player[] opponents = {dealer, player};
        this.opponents = opponents;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Player[] getOpponents() {
        return opponents;
    }

    public void setOpponents(Player[] opponents) {
        this.opponents = opponents;
    }

    public String getScores() {
        return "Your score : " + this.getOpponents()[1].getBestResult() + "\nDealer score : " + this.getOpponents()[0].getBestResult();
    }

    public Player game() {
        // The dealer gives twos cards face up to the player.
        List<Integer> cards = this.getDeck().getCards();
        Player dealer = this.getOpponents()[0];
        Player player = this.getOpponents()[1];
        boolean playing = true;
        int card;
        for (int i = 1; i <= 2; i++) {
            card = cards.get(0);
            player.getCards().add(card);
            cards.remove(0);
        }
        System.out.println("** Your current cards : " + player.showHand() + "**");

        // The dealer gives one card face up and one card face down to himself.
        card = cards.get(0);
        dealer.getCards().add(card);
        cards.remove(0);
        int hiddenCard = cards.get(0);
        cards.remove(0);
        System.out.println("** Dealer current cards : " + dealer.showHand() + "## **");

        System.out.println("\n" + this.getScores() + "\n");
        // The player must decide whether to ask for another card in an attempt to get closer to 21, or to stop
        while (player.getTotal(false) < 21 && player.getTotal(true) != 21 && playing) {
            System.out.println("Do you wish to get another card ? Yes : 1 / No : 2");
            int choice = 0;
            while (choice != 1 && choice != 2) {
                choice = scanner.nextInt();
            }
            if (choice == 1) {
                card = cards.get(0);
                player.getCards().add(card);
                cards.remove(0);
            } else {
                playing = false;
            }
            System.out.println("You picked the card : " + card);
            System.out.println("\n** Your current cards : " + player.showHand() + "**");
        }

        // If the player score is over 21, the dealer wins and the play stops.
        System.out.println("\n" + this.getScores() + "\n");
        if (player.getTotal(true) == 21 || player.getTotal(false) == 21) {
            return player;
        } else if (player.getTotal(false) > 21) {
            return dealer;
        }

        // The dealer will turn up his face-down card :
        dealer.getCards().add(hiddenCard);
        System.out.println("The dealer reveals his card : " + hiddenCard);

        // if the total is 17 or more, he must stop.
        // if the total is 16 or under, he must take a new card.
        // if the dealer has an ace, and counting it as 11 would bring the total to 17 or more (but not over 21),
        // the dealer must count the ace as 11 and stop.
        while (dealer.getTotal(false) < 17 && dealer.getTotal(true) <= 21) {
            card = cards.get(0);
            dealer.getCards().add(card);
            cards.remove(0);
        }

        System.out.println("\n" + this.getScores() + "\n");
        // If the dealer score is over 21, the player wins.
        if (dealer.getTotal(false) > 21) {
            return player;
        }

        // If neither the player nor the dealer has over 21, the one with the biggest score wins.
        int playerTotal = player.getBestResult();
        int dealerTotal = dealer.getBestResult();

        return playerTotal > dealerTotal ? player : dealer;
    }

    public static void main(String[] args) {
        boolean playing = true;
        while (playing) {
            Play play = new Play();
            Player winner = play.game();
            System.out.println("\tThe winner is " + winner.getName());
            System.out.println("**********************************************");
            // Ask the player for a replay
            System.out.println("\nDo you wish to try again ? Yes : 1 / No : 2");
            int choice = 0;
            while (choice != 1 && choice != 2) {
                choice = scanner.nextInt();
            }
            
        }
    }
}