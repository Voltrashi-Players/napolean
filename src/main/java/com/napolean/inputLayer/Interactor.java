package com.napolean.inputLayer;


/**
*
*   This class will be the entity interacting with
*   the outside world.
*
*   This is an external stub and will have no test cases.
*
*   This entire class needs to be mocked for testing the logic
*
 */

import java.util.Scanner;

public class Interactor {

    Scanner input;

    public Interactor() {
        input = new Scanner(System.in);
    }

    public void getInput() {

    }

    public int getNumberOfPlayers() {
        System.out.println("Please enter the number of players playing the game");
        int numberOfPlayers = input.nextInt();
        return numberOfPlayers;
    }
}
