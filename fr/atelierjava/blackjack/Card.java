package fr.atelierjava.blackjack;

class Card {

    private int number;


    public String card() {
        return"Hello card";
    }
    public Card(int number) {
        this.number = number;
    }
    public Card() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}