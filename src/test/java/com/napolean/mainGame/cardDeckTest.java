package com.napolean.mainGame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.napolean.mainGame.CardDeck.*;

public class cardDeckTest {

    CardDeck cardDeck;

    @Before
    public void setUp() {
        cardDeck = new CardDeck();
    }

    @After
    public void tearDown() {
        cardDeck = null;
    }

    @Test
    public void populateTotalDefaultDeckSizeTest() {
        Assert.assertEquals(52,cardDeck.populateTotalDefaultDeck(52).size());
    }

    @Test
    public void checkIfAllSuitPresent() {
        Set<Suit> allSuits = cardDeck.populateTotalDefaultDeck(52).stream().map(card -> card.getSuit()).collect(Collectors.toSet());
        Assert.assertEquals( 4, allSuits.size() );
    }

    @Test
    public void checkIfAllRankPresent() {
        Set<Rank> allRanks = cardDeck.populateTotalDefaultDeck(52).stream().map(card -> card.getRank()).collect(Collectors.toSet());
        Assert.assertEquals(13, allRanks.size());
    }

    @Test
    public void checkIfJokersAreProperlyPopulated() {
        List<Joker> listOfJokers = cardDeck.populateTotalDefaultDeck(54).stream().filter(card -> card.getJoker()!=null).map(card -> card.getJoker()).collect(Collectors.toList());
        Assert.assertEquals(2, listOfJokers.size() );
    }

}
