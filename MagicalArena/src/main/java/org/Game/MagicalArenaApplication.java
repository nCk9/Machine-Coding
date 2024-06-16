package org.Game;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.Game.utils.ValidateInput.isInvalidInput;

public class MagicalArenaApplication {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to the Magical Arena game!");
        //taking inputs from the user
        Player playerA, playerB;
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.print("Enter org.Game.Player A's health, strength and attack respectively: ");
                Integer aHealth = scanner.nextInt();
                Integer aStrength = scanner.nextInt();
                Integer aAttack = scanner.nextInt();
                playerA = new Player(aHealth, aStrength, aAttack);
            } while (isInvalidInput(playerA));

            do {
                System.out.print("Enter org.Game.Player B's health, strength and attack respectively: ");
                Integer bHealth = scanner.nextInt();
                Integer bStrength = scanner.nextInt();
                Integer bAttack = scanner.nextInt();
                playerB = new Player(bHealth, bStrength, bAttack);
            } while (isInvalidInput(playerB));

            MagicalArena magicalArena = new MagicalArena();
            //let the game begin
            magicalArena.gamePlay(playerA, playerB);
        }catch (InputMismatchException e){
            System.out.println("InputMismatchException thrown: All inputs must be positive integers within integer range.");
        }catch (Exception e){
            System.out.println("Exception Occurred!");
        }
    }
}