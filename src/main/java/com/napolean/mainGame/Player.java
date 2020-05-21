package com.napolean.mainGame;


import java.util.List;

/**
 *
 * This represents a player who is playing the game
 *
 */

public class Player {

    String handle;
    List<Card> cards;

    public Player(String handle) {
        this.handle = handle;
    }


    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
