package com.napolean.mainGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * This class represents one deck of cards
 *
 */

public class CardDeck {

    private final int defaultTotalCards = 52;

    public enum Suit {
        SPADE,FLOWER,HEART,DIAMOND;
    }

    public enum Rank {
        TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE;
    }

    public enum Joker {
        JOKER;
    }

    /**
     * Creates a default deck of cards and return the deck of cards.
     *
     * @param totalNumberOfCards indicates the total number cards that needs to be created
     *                           By Default it creates 52 cards and adds JOKERS to make the
     *                           sum to this parameter.
     *
     */

    public List<Card> populateTotalDefaultDeck(int totalNumberOfCards) {
        List<Card> listOfCards = new ArrayList<>();
        Arrays.asList(Suit.values()).forEach(suit -> Arrays.asList(Rank.values()).forEach(rank -> listOfCards.add(new Card(suit,rank))));
        IntStream.rangeClosed(1, (totalNumberOfCards-defaultTotalCards)).forEach(val -> listOfCards.add(new Card(Joker.JOKER)));
        return listOfCards;
    }

}
