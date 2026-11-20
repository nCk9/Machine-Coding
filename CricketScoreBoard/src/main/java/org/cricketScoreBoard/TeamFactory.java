package org.cricketScoreBoard;

public class TeamFactory {

    public Team getTeam(String name, int numPlayers){
        return new Team(name, numPlayers);
    }
}
