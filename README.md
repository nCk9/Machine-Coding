# Machine-Coding
various machine coding problems

1. Magical Arena Description:
    Design a Magical Arena. Every org.Game.Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute     touches 0. Any two player can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The         “attack” value multiplied by the outcome of the  attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending         dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender.         Game ends when any players health reaches 0
    
    org.Game.Player with lower health attacks first at the start of a match. 
    
    Assume two players . org.Game.Player A 50 health 5 strength 10 attack org.Game.Player B 100 health 10 stregnth and 5 attack . Attacking die and Defending die are both 6 sided die with values ranging         from 1- 6
    
    org.Game.Player A attacks and rolls die. Die roll : 5 . org.Game.Player B defends and rolls die. Die roll 2
    
    Attack damage is 5 * 10 = 50 ; Defending strength = 10 * 2 = 20 ; org.Game.Player B health reduced by 30 to 70
    
    org.Game.Player B attacks and rolls die. Die roll : 4. org.Game.Player A defends and rolls die. Die Roll 3
    
    Attack damage is 4 * 5 = 20 ; Defending strength = 5 * 3 = 15 ; org.Game.Player A health reduced by 5 to 45
    
    And so on.
2. Stock Exchange Service - 
   follow this link: https://docs.google.com/document/d/17eGMMAcot_xca9oGl-wnD9SGnxnxPFea5Lm9B2Qk3ZU/edit?tab=t.0

3. ATM: The ATM system should support basic operations such as balance inquiry, cash withdrawal, and cash deposit.
   Users should be able to authenticate themselves using a card and a PIN (Personal Identification Number).
   The system should interact with a bank's backend system to validate user accounts and perform transactions.
   The ATM should have a cash dispenser to dispense cash to users.
   The system should handle concurrent access and ensure data consistency.
   The ATM should have a user-friendly interface for users to interact with.

4. CoffeeVendingMachine:The coffee vending machine should support different types of coffee, such as espresso, cappuccino, and latte.
   Each type of coffee should have a specific price and recipe (ingredients and their quantities).
   The machine should have a menu to display the available coffee options and their prices.
   Users should be able to select a coffee type and make a payment.
   The machine should dispense the selected coffee and provide change if necessary.
   The machine should track the inventory of ingredients and notify when they are running low.
   The machine should handle multiple user requests concurrently and ensure thread safety.