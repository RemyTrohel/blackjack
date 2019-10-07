# Blackjack

## Todo :

Develop a Blackjack game in Java, with at least a `Play.java` class with a `main` method.

The game will request input to the player (ex : take a card) and show him the result in the terminal (ex : your score is 17).

After one play, the game will ask to leave or to restart.

**Do not forget to store your game on GitHub.**

## Object of the game :
The player attempts to beat the dealer by getting a count as close to 21 as possible, without going over 21.

## Card values :
* an ace is worth 1 or 11, at player choice.
* face cards are worth 10.
* any other card (2 to 10) worth its corresponding value.

## The play :

* The dealer gives twos cards face up to the player.
* The dealer gives one card face up and one card face down to himself.
* The player must decide whether to ask for another card in an attempt to get closer to 21, or to stop 
* Until the player score is 21 or under, he can decide to ask for additional cards, one at a time.

If the player score is over 21, the dealer wins and the play stops.

## The dealer's play :

The dealer will turn up his face-down card :

* if the total is 17 or more, he must stop.
* if the total is 16 or under, he must take a new card.
* if the dealer has an ace, and counting it as 11 would bring the total to 17 or more (but not over 21), the dealer must count the ace as 11 and stop.

If the dealer score is over 21, the player wins.

## Winner :

If neither the player nor the dealer has over 21, the one with the biggest score wins.