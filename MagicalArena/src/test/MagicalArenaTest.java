package test;

import main.MagicalArena;
import main.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MagicalArenaTest {

    private Player A;
    private Player B;
    private MagicalArena magicalArena;

    @Before
    public void setUp(){
        A = new Player(50, 5, 10);
        B = new Player(100, 10, 5);
        magicalArena = new MagicalArena();
    }

    @Test
    public void testGameFunctionality() throws Exception {
        magicalArena.gamePlay(A, B);
        //once the gameplay is done, it should declare the winner
        assertTrue("one of the players should be the winner", A.isAlive() || B.isAlive());
        assertFalse("only one of them should be the winner", A.isAlive() && B.isAlive());

        //the loosing player should have final health <= 0
        if(A.getIsWinner()){
            assertTrue("A wins the game and B's health is <= 0", B.getHealth() <= 0);
        }else{
            assertTrue("B wins the game and A's health is <= 0",A.getHealth() <= 0);
        }
    }

    @Test
    public void testSimulateAttackThrowsException(){
        A.setAttack(Integer.MAX_VALUE);
        B.setStrength(Integer.MAX_VALUE);
        try {
            magicalArena.gamePlay(A, B);
        }catch (Exception e){
            assertEquals(Exception.class, e.getClass());
        }
    }


}
