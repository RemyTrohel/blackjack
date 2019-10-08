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
        this.welcomeMessage();
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

    public void showScores() {
        System.out.println("\nYour score : " + this.getOpponents()[1].getBestResult());
        System.out.println("Dealer score : " + this.getOpponents()[0].getBestResult());
    }

    public void showHands(boolean hiddenCard) {
        System.out.println("\nYour current cards : " + this.opponents[1].showHand());
        System.out.println("Dealer current cards : " + this.opponents[0].showHand() + (hiddenCard ? "#" : ""));
    }

    public void showWinner(Player winner) {
        System.out.println("\n*********************************************************");            
        if (winner.getName().equals("Player")) {
            System.out.println("\t\t\tYOU WIN !");
        } else {
            System.out.println("\t\t\tYOU LOSE !");
        }
        System.out.println("*********************************************************");
    }

    public boolean replay() {
        System.out.println("\nDo you wish to try again ? Yes : 'Y' / No : 'N'");
        String choice = "";
        while (!choice.toUpperCase().equals("Y") && !choice.toUpperCase().equals("N")) {
            choice = scanner.next();
        }
        return choice.toUpperCase().equals("Y");
    }

    public void welcomeMessage() {
        System.out.println("*********************************************************");
        System.out.println("*                                                       *");
        System.out.println("*                                                       *");
        System.out.println("*                                                       *");
        System.out.println("*********************************************************");
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

        // The dealer gives one card face up and one card face down to himself.
        card = cards.get(0);
        dealer.getCards().add(card);
        cards.remove(0);
        int hiddenCard = cards.get(0);
        cards.remove(0);

        // The player must decide whether to ask for another card in an attempt to get closer to 21, or to stop
        while (player.getTotal(false) < 21 && player.getTotal(true) != 21 && playing) {
            this.showHands(true);
            System.out.print("\nDo you wish to get another card ? Yes : 'Y' / No : 'N' \n> ");
            String choice = "";
            while (!choice.toUpperCase().equals("Y") && !choice.toUpperCase().equals("N")) {
                choice = scanner.next();
            }
            if (choice.toUpperCase().equals("Y")) {
                card = cards.get(0);
                player.getCards().add(card);
                cards.remove(0);
            } else {
                playing = false;
            }
            System.out.println("\n\t\tYou picked the card : " + card);
        }
        
        // The dealer will turn up his face-down card :
        dealer.getCards().add(hiddenCard);
        System.out.println("\n\t\tThe dealer reveals his card : " + hiddenCard);
        this.showHands(false);

        // If the player score is over 21, the dealer wins and the play stops.
        this.showScores();
        if (player.getTotal(true) == 21 || player.getTotal(false) == 21) {
            return player;
        } else if (player.getTotal(false) > 21) {
            return dealer;
        }

        // if the total is 17 or more, he must stop.
        // if the total is 16 or under, he must take a new card.
        // if the dealer has an ace, and counting it as 11 would bring the total to 17 or more (but not over 21),
        // the dealer must count the ace as 11 and stop.
        while (dealer.getTotal(false) < 17 && dealer.getTotal(true) <= 21) {
            card = cards.get(0);
            dealer.getCards().add(card);
            System.out.println("\n\t\tThe dealer pick anoter card : " + card);
            cards.remove(0);
        }

        this.showHands(false);
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
            play.showWinner(winner);
            playing = play.replay();
        }
        System.out.println("\n\t\tTHANK YOU FOR PLAYING !");
    }
}