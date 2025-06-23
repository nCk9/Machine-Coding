package org.cricketScoreBoard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerStats {
    private int runsScored;
    private int wicketsTaken;
    private int sixes;
    private int fours;
    private int ballsPlayed;

    public PlayerStats(){
        runsScored = 0;
        wicketsTaken = 0;
        fours = 0;
        sixes = 0;
        ballsPlayed = 0;
    }

    public void updateRunsScored(int runs){
        runsScored += runs;
    }

    public void updateFours(){
        fours++;
    }

    public void updateSixes(){
        sixes++;
    }

    public void updateBallsPlayed(){
        ballsPlayed++;
    }

}
