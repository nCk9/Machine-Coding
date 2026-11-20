package org.cricketScoreBoard;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Match {
    private int matchId;
    private Team team1;
    private Team team2;
    private String location;
    private String dateTime;
    private String tournamentName;
    private int numOvers;

    Match(Team team1_, Team team2_, String location_, String tournamentName_, int numOvers_){
        matchId = (int)(Math.random() * 100);
        team1 = team1_;
        team2 = team2_;
        location = location_;
        tournamentName = tournamentName_;
        numOvers = numOvers_;
    }

    public void setBattingOrder(List<String> battingOrder, Team team){
        team.setBattingOrder(battingOrder);
    }
}
