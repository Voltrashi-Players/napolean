package com.napolean.mainGame;

import com.napolean.mainGame.CardDeck.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.mockito.Matchers.anyInt;

public class cardDealerTest {

    List<Card> cards;
    CardDeck cardDeck;
    CardDealer cardDealer;

    @Before
    public void setUp() {
        cards = populateHardCodedCardsList();
        cardDeck = Mockito.mock(CardDeck.class);
        cardDealer = new CardDealer(cardDeck);
    }

    @After
    public void tearDown() {
        cards = null;
    }

    @Test
    public void clearAndCreateNewListTest() {
        addJokers(cards,1);
        List<Card> kittyCards = cardDealer.clearAndCreateNewList(cards,3);
        Assert.assertEquals(3, kittyCards.size());
        Assert.assertEquals(50, cards.size());
    }

    @Test
    public void dealCardsToPlayerTest() {
        addJokers(cards,1);
        cardDealer.clearAndCreateNewList(cards,3);
        Assert.assertEquals(50, cards.size());
        List<List<Card>> playerCards = cardDealer.dealCardsToPlayer(cards,5);
        Assert.assertEquals(10, playerCards.get(0).size());
        Assert.assertEquals(10, playerCards.get(1).size());
        Assert.assertEquals(10, playerCards.get(2).size());
        Assert.assertEquals(10,playerCards.get(3).size());
        Assert.assertEquals(10,playerCards.get(4).size());
    }

    @Test
    public void dealCards() {
        Mockito.when(cardDeck.populateTotalDefaultDeck(anyInt())).thenReturn(cards);
        addJokers(cards,1);
        List<List<Card>> allCardsAFterDealing = cardDealer.dealCards(5,3);
        Assert.assertEquals(10, allCardsAFterDealing.get(0).size());
        Assert.assertEquals(10, allCardsAFterDealing.get(1).size());
        Assert.assertEquals(10, allCardsAFterDealing.get(2).size());
        Assert.assertEquals(10,allCardsAFterDealing.get(3).size());
        Assert.assertEquals(10,allCardsAFterDealing.get(4).size());
        Assert.assertEquals(3,allCardsAFterDealing.get(5).size());
    }

    private List<Card> populateHardCodedCardsList() {
        List<Card> listOfCards = new ArrayList<>();

        List<Suit> suits = new ArrayList<>();
        suits.add(Suit.SPADE);
        suits.add(Suit.DIAMOND);
        suits.add(Suit.FLOWER);
        suits.add(Suit.HEART);

        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.ACE);
        ranks.add(Rank.KING);
        ranks.add(Rank.QUEEN);
        ranks.add(Rank.JACK);
        ranks.add(Rank.TEN);
        ranks.add(Rank.NINE);
        ranks.add(Rank.EIGHT);
        ranks.add(Rank.SEVEN);
        ranks.add(Rank.SIX);
        ranks.add(Rank.FIVE);
        ranks.add(Rank.FOUR);
        ranks.add(Rank.THREE);
        ranks.add(Rank.TWO);

        Arrays.asList(Suit.values()).forEach(suit -> Arrays.asList(Rank.values()).forEach(rank -> listOfCards.add(new Card(suit,rank))));

        return listOfCards;
    }

    private void addJokers(List<Card> cards, int numberOfJokers) {
        IntStream.rangeClosed(1,numberOfJokers).forEach(num -> cards.add(new Card(Joker.JOKER)));
    }

}
