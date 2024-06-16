package org.Game;

import static java.lang.Math.max;

public class MagicalArena {

    public void gamePlay(Player playerA, Player playerB) throws Exception {
        // Determine initial attacker based on health
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        // Progress the game until one player is defeated
        while (attacker.isAlive() && defender.isAlive()) {
            simulateAttack(attacker, defender);

            // Swap roles after each attack
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Declare the winner
        if (attacker.isAlive()) {
            attacker.setIsWinner(true);
        } else {
            defender.setIsWinner(true);
        }

        //publish results
        if (playerB.getIsWinner())
            System.out.println("org.Game.Player B is the winner of the Game!");
        else
            System.out.println("org.Game.Player A is the winner of the Game!");
    }

    private void simulateAttack(Player attacker, Player defender) throws Exception {
        Dice dice = new Dice();
        try {
            int attackingPower = attacker.getAttack() * dice.rollDice();
            int defendingStrength = defender.getStrength() * dice.rollDice();
            if(attackingPower < 0  || defendingStrength < 0) throw new Exception("Integer Overflow!");
            Integer damageCaused = max(0, attackingPower - defendingStrength);
            defender.setHealth(defender.getHealth() - damageCaused);
        }catch(Exception e){
            System.out.println("Exception thrown in simulating the attack.");
            throw e;
        }
    }
}
