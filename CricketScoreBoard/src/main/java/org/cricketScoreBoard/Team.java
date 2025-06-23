package org.cricketScoreBoard;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Team {
    private int teamId;
    private String teamName;
    private Map<Player, PlayerStats> players; //playerId, playerStats (for that match)
    private String owner;
    private int numberOfPlayers;
    private PlayerFactory playerFactory;
    private List<String> battingOrder;

    public Team(String teamName_, int numberOfPlayers_){
        teamName = teamName_;
        numberOfPlayers = numberOfPlayers_;
        teamId = (int) (Math.random() * 10);
        for(int i=0; i<numberOfPlayers_; i++){
            Player player = playerFactory.getPlayer(i);
            players.put(player, new PlayerStats());
        }
    }

    public Player getPlayer(String name){
        for (Player player: players.keySet())
            if(player.getName().equalsIgnoreCase(name))
                return player;
        return null;
    }

}
