package com.napolean.mainGame;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * This class will basically co-ordinate the one entire game
 *
 * Will have methods from createGame till declaring who wins
 *
 * This will be invoked by interactor maybe be rest based/console
 * based or anything else
 *
 */

public class Cordinator {

    int numberOfPeople;
    List<Player> playerList;
    CardDealer cardDealer;

    public Cordinator(int numberOfPeople, CardDealer cardDealer) {
        this.numberOfPeople=numberOfPeople;
        playerList = new ArrayList<>(numberOfPeople);
        this.cardDealer=cardDealer;
    }

    public void createGame() {

    }

}
