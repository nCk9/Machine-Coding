package main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private Integer health;
    private Integer strength;
    private Integer attack;
    private Boolean isWinner;

    public Player(Integer health, Integer strength, Integer attack){
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.isWinner = false;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

}
