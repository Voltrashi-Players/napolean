package com.napolean.mainGame;

import com.napolean.mainGame.CardDeck.*;

/**
 *
 * This represents a single card in the game
 *
 * It will have suit and a rank, or it will be an joker
 *
 */

public class Card {

    Suit suit;
    Rank rank;
    Joker joker;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(Joker joker) {
        this.joker=joker;
    }


    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Joker getJoker() {
        return joker;
    }
}
