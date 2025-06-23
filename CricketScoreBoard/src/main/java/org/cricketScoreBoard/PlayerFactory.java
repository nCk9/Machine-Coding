package org.cricketScoreBoard;

public class PlayerFactory {

    public Player getPlayer(int idx){
        return new Player("P"+idx);
    }
}
