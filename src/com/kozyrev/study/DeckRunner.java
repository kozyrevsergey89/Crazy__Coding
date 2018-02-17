package com.kozyrev.study;

/**
 * Created by skozyrev on 2/17/18.
 */
public class DeckRunner {
    public static void main(String [] args){
        System.out.println("foo");
        Deck deck = new Deck();
        deck.CreateDeck();
        while (true) {
            deck.doingAll();
        }
    }
}
