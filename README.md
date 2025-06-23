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

5. ChessGame: Task is to design a chess engine, which validates moves for each of the piece.
   While making a move, if it encounters another piece, it should displace it provided it belongs to the other clan.

6. ParkingLotSystem: 
   The parking lot should have multiple levels, each level with a certain number of parking spots.
   The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
   Each parking spot should be able to accommodate a specific type of vehicle.
   The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
   The system should track the availability of parking spots and provide real-time information to customers.
   The system should handle multiple entry and exit points and support concurrent access.

7. Design a cricket scorecard that will show the score for a team along with score of each player.

   You will be given the number of players in each team, the number of overs and their batting order as input. Then, we can input overs ball by ball with the runs scored on that ball (could be wide, no ball or a wicket as well). You are expected to print individual scores, number of balls faced, number of 4s, number of 6s for all the players from the batting side at the end of every over. You also need to print total score, total wickets. Essentially, you need to keep a track of all the players, strike changes (at the end of the over or after taking singles or 3s) and maintain their scores, also keep track of extra bowls that are being bowled (like wides or no balls). You also need to print which team won the match at the end. This is the bare minimum solution which is expected for the problem. You can add some more features once you are done with these, like maintaining a bowlers record (total overs bowled, runs conceded, wickets taken, maiden overs, dot balls, economy, etc.). Total team extras, batsman strike rates, etc. can be added too. But these are "good to have" features, please try to complete the bare minimum first.

   Make sure your code is readable and maintainable and preferably object oriented. It should be modular and extensible, to add new features if needed.

   Sample input and output: No. of players for each team: 5 No. of overs: 2 Batting Order for team 1: P1 P2 P3 P4 P5 
   Over 1: 1 1 1 1 1 2

   Scorecard for Team 1: Player Name Score 4s 6s Balls P1* 3 0 0 3 P2* 4 0 0 3 P3 0 0 0 0 P4 0 0 0 0 P5 0 0 0 0 Total: 7/0 Overs: 1

   Over 2: W 4 4 Wd W 1 6

   Scorecard for Team 1: Player Name Score 4s 6s Balls P1 3 0 0 4 P2* 10 0 1 4 P3 8 2 0 3 P4* 1 0 0 1 P5 0 0 0 0 Total: 23/2 Overs: 2

   Batting Order for team 2: P6 P7 P8 P9 P10

   Over 1: 4 6 W W 1 1

   Scorecard for Team 2: Player Name Score 4s 6s Balls P6 10 1 1 3 P7* 1 0 0 1 P8 0 0 0 1 P9* 1 0 0 1 P10 0 0 0 0 Total: 12/1 Overs: 1

   Over 2: 6 1 W W

   Scorecard for Team 2: Player Name Score 4s 6s Balls P6 10 1 1 2 P7* 8 0 1 3 P8 0 0 0 1 P9 1 0 0 2 P10 0 0 0 1 Total: 19/4 Overs: 1.4

   Result: Team 1 won the match by 4 runs