package com.napolean.mainGame;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *  This is the class which deals the deck of cards.
 *
 *  It will have all the methods necessary for dealing the cards.
 *
 */

public class CardDealer {

    private CardDeck cardDeck;

    public CardDealer(CardDeck cardDeck) {
        this.cardDeck=cardDeck;
    }

    public List<List<Card>> dealCards(int numberOfPlayers, int numberOfKittyCards) {
        List<Card> deckOfCards = cardDeck.populateTotalDefaultDeck(numberOfPlayers);
        List<Card> shuffledCards = shuffleAllCards(deckOfCards);
        List<Card> kittyCards = clearAndCreateNewList(shuffledCards, numberOfKittyCards);
        List<List<Card>> allPlayerCards = dealCardsToPlayer(shuffledCards,numberOfPlayers);
        allPlayerCards.add(kittyCards);
        return allPlayerCards;
    }

    /**
     *
     * Takes a list of shuffled cards and deals deals it to all the players.
     *
     * NOTE : IT CURRENTLY SUPPORTS ONLY IF SIZE OF SHUFFLEDCARDS IS DIVISIBLE BY NUMBEROFPLAYER,
     *        ELSE THERE WILL BE ANOMALIES
     *
     * @param shuffledCards     -   A list of shuffled cards
     * @param numberOfPlayers   -   Number of players that the cards needs to be distributed to
     * @return                  -   Returns player number of lists of cards.
     *                              Caution - in case of uneven distribution it pads with null value
     */

    public List<List<Card>> dealCardsToPlayer(List<Card> shuffledCards, int numberOfPlayers) {
        return  Lists.newArrayList(Iterators.partition(shuffledCards.iterator(),(shuffledCards.size()/numberOfPlayers)));
    }



    /**
     *
     * Uses a small variant of FISHER-YATES shuffle algorithm
     * it basically starts from backwards :P
     *
     * @param deckOfCards   -   List of cards to be shuffled
     * @return              -   Returns the list post shuffling
     */

    public List<Card> shuffleAllCards(List<Card> deckOfCards) {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }


    /**
     *
     * Takes a list of shuffled cards and removes
     * kitty cards from the end.
     *
     *
     * @param shuffledCards         - Actual deck of shuffled cards. Kitty cards will be deleted in place
     * @param numberOfKittyCards    - Number of cards in the end that needs to be deleted in shuffled cards.
     * @return                      - Returns the deleted kitty card list from the shuffled cards.
     */

    public List<Card> clearAndCreateNewList(List<Card> shuffledCards, int numberOfKittyCards ) {
        List<Card> subList = shuffledCards.subList(shuffledCards.size()-numberOfKittyCards, shuffledCards.size());
        List<Card> newList = new ArrayList<>(subList);
        subList.clear();
        return newList;
    }
}
