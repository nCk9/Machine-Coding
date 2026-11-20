package org.cricketScoreBoard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int playerId;
    private int age;
    private int totalRunsScored;
    private int totalWicketsTaken;

    public Player(String name_){
        playerId = (int) (Math.random()*10);
        totalRunsScored = 0;
        totalWicketsTaken = 0;
        age = 24;
        name = name_;
    }

//    public Player getPlayer(int playerId_){
//        return
//    }
}
