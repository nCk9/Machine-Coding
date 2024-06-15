package main.utils;

import main.Player;

public class ValidateInput {

    public static boolean isInvalidInput(Player player) {
        boolean attributeValidation = (player.isAlive() && player.getAttack() > 0 && player.getStrength() > 0);
        if(!attributeValidation) System.out.println("Initial health, strength and attack must be positive integers.");
        return !attributeValidation;
    }
}
