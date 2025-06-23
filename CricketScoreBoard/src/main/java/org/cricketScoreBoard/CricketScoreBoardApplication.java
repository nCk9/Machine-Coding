package org.cricketScoreBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CricketScoreBoardApplication {
    public static void main(String[] args) {
        System.out.println("Hello! and welcome to nCk's scoreboard!");
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Input the number of players from each team: ");
        int numPlayers = inputScanner.nextInt();
        System.out.print("Input the number of overs for each team: ");
        int numOvers = inputScanner.nextInt();
        System.out.print("Input the batting order for team1: ");
        CricketScoreBoard cricketScoreBoard = CricketScoreBoard.getInstance();
        Team team1 = cricketScoreBoard.constructTeam("RCB", numPlayers);
        List<String> battingOrder = new ArrayList<>(numPlayers);
        for(int i=0; i<numPlayers; i++)
            battingOrder.add(i, inputScanner.next());

        Team team2 = cricketScoreBoard.constructTeam("KKR", numPlayers);
        Match match = cricketScoreBoard.addMatch(team1, team2, "India", "IPL", numOvers);
        match.setBattingOrder(battingOrder, team1);
        for(int i=0; i<numOvers; i++) {
            System.out.print("Input Over "+ (i+1) + " : ");
            List<String> over = new ArrayList<>();
            while (inputScanner.hasNext()) {
                over.add(inputScanner.next());
            }
            cricketScoreBoard.processOver(over, team1);
            cricketScoreBoard.getScoreBoard(team1);
        }
        //first innings done, starting second now!
        List<String> battingOrder2 = new ArrayList<>(numPlayers);
        System.out.print("Input batting order for team 2: ");
        for(int i=0; i<numPlayers; i++)
            battingOrder2.add(i, inputScanner.next());
        match.setBattingOrder(battingOrder2, team2);
        for(int i=0; i<numOvers; i++) {
            System.out.print("Input Over "+ (i+1) + " : ");
            List<String> over = new ArrayList<>();
            while (inputScanner.hasNext()) {
                over.add(inputScanner.next());
            }
            cricketScoreBoard.processOver(over, team2);
            cricketScoreBoard.getScoreBoard(team2);
        }
    }
}