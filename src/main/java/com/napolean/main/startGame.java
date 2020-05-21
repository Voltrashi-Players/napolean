package com.napolean.main;

import com.napolean.inputLayer.Interactor;

import java.util.Scanner;


/**
 *
 * This is temporary class which will boot the game
 * for now
 *
 * Later this needs to be replaced to bring the server
 * up for rest interface
 *
 */
public class startGame {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Interactor userInteractor = new Interactor();

        int numberOfPlayers = userInteractor.getNumberOfPlayers();

    }
}
