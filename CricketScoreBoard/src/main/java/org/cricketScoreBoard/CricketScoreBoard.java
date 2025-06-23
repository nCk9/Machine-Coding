package org.cricketScoreBoard;

import java.util.ArrayList;
import java.util.List;

public class CricketScoreBoard {
    private static CricketScoreBoard cricketScoreBoardInstance;
    private TeamFactory teamFactory;
    private int totalWicketsDown;
    private int totalRunsScored;
    private CricketScoreBoard(){
        totalRunsScored = 0;
        totalWicketsDown = 0;
    }

    public static CricketScoreBoard getInstance(){
        if(cricketScoreBoardInstance == null)
            cricketScoreBoardInstance = new CricketScoreBoard();
        return cricketScoreBoardInstance;
    }

    public Team constructTeam(String name, int numPlayers){
        return teamFactory.getTeam(name, numPlayers);
    }

    public Match addMatch(Team team1, Team team2, String location, String tournamentName, int numOvers){
        return new Match(team1, team2, location, tournamentName, numOvers);
    }

    private void swapPlayers(Player currBatsMan, Player currOtherBatsMan){
        Player temp = currBatsMan;
        currBatsMan = currOtherBatsMan;
        currOtherBatsMan = temp;
    }

    public void processOver(List<String> over, Team team){
        int size = over.size();
        List<String> batOrder = team.getBattingOrder();
        if(totalWicketsDown == batOrder.size()-1) {
            System.out.print("All out!");
            return;
        }
        int currBatsmanIdx = totalWicketsDown;
        Player currBatsMan = team.getPlayer(batOrder.get(currBatsmanIdx));
        Player currOtherBatsMan = team.getPlayer(batOrder.get(currBatsmanIdx+1));
        for(int i=0; i<size; i++){
            if(over.get(i).equalsIgnoreCase("1") || over.get(i).equalsIgnoreCase("3")){
                team.getPlayers().get(currBatsMan).updateRunsScored(Integer.parseInt(over.get(i)));
                team.getPlayers().get(currBatsMan).updateBallsPlayed();
                swapPlayers(currBatsMan, currOtherBatsMan);
                totalRunsScored += Integer.parseInt(over.get(i));
            }else if(over.get(i).equalsIgnoreCase("w")){
                totalWicketsDown++;
                team.getPlayers().get(currBatsMan).updateBallsPlayed();
                if(totalWicketsDown == batOrder.size()-1) {
                    System.out.print("All out!");
                    return;
                }
                currBatsMan = team.getPlayer(batOrder.get(totalWicketsDown+1));
            }else if(over.get(i).equalsIgnoreCase("wd") || over.get(i).equalsIgnoreCase("nb")){
                team.getPlayers().get(currBatsMan).updateBallsPlayed();
                totalRunsScored += 1;
            }else{
                team.getPlayers().get(currBatsMan).updateRunsScored(Integer.parseInt(over.get(i)));
                totalRunsScored += Integer.parseInt(over.get(i));
                if(Integer.parseInt(over.get(i)) == 4) team.getPlayers().get(currBatsMan).updateFours();
                if(Integer.parseInt(over.get(i)) == 6) team.getPlayers().get(currBatsMan).updateSixes();
                team.getPlayers().get(currBatsMan).updateBallsPlayed();
            }
        }
        swapPlayers(currBatsMan, currOtherBatsMan); //since its an over end!
    }

    public void getScoreBoard(Team team){
        for(int i=0; i<team.getNumberOfPlayers(); i++){
            System.out.println("Name of player, Score, 4s, 6s, Balls ");
            for(Player player: team.getPlayers().keySet()){
                PlayerStats stats = team.getPlayers().get(player);
                System.out.print(player.getName() + ", " + stats.getRunsScored() + ", " + stats.getFours()
                + ", " + stats.getSixes() + ", " + stats.getBallsPlayed());
            }
        }
    }

}
