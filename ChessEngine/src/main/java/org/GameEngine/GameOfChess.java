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
        System.out.println("Initializing the chess board!\n");
        chessEngine.getBoardStatus();
        int i=0;
        Character prevClan = '.';

        while(true){
            String player = "player"+(i+1);
            System.out.println(player +"'s turn (enter the piece and desired final location): ");
            String pieceName = inputScanner.next();
            Integer x = inputScanner.nextInt();
            Integer y = inputScanner.nextInt();
            if(prevClan == pieceName.charAt(0)){
                System.out.println("Turn can't be from the same clan as previous one. Pls make a valid move from the other clan.");
                continue;
            }
            prevClan = pieceName.charAt(0);
            if(!chessEngine.makeMoveIfValid(pieceName, x, y)){
                System.out.println("Invalid move for this piece. Pls make a valid move to proceed.");
            }
        }

    }
}