package org.Game;

public class Dice {

    //returns integers between 1 to 6

    public Integer rollDice(){
        return (int)(Math.random() * 6) + 1;
    }
}