package test;

import main.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player playerA;

    @Before
    public void playerTest(){
        playerA = new Player(2, 20, 90);
    }

    @Test
    public void getIsAliveTest(){
        boolean playerAlive = playerA.getHealth() > 0;
        assertEquals("The player is alive!", playerAlive, playerA.isAlive());
    }
}
