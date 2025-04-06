package org.GameEngine;

import java.util.Scanner;

public class GameOfChess {
    public static void main(String[] args) {
        System.out.println("Welcome to the game of Chess!");

        Scanner inputScanner = new Scanner(System.in);
        ChessEngine chessEngine = new ChessEngine();
        for(int i=0; i<2; i++) {
            System.out.println("Enter player" + (i+1) + " details (name of the player and choice of colour):");
            String name = inputScanner.next();
            String colour  = inputScanner.next();
            chessEngine.createPlayer(name, colour, i);
        }
        System.out.println("Initializing the chess board!");
        chessEngine.getBoardStatus();
    }
}