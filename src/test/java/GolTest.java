import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GolTest {
    Gol game;

    @BeforeEach void setup(){
        game = new Gol(11, 11, 0);
    }

    @Test void a_testSetAlive(){
        game.setLifeAlive(5,5);
        game.printBoard();
        assertEquals(1,game.board[5][5]);
    }

    @Test void b_testSetDead(){
        game.setLifeAlive(5,5);
        game.printBoard();
        game.setLifeDead(5,5);
        game.printBoard();
        assertEquals(0,game.board[5][5]);
    }

    @Test void c_testIsAlive() {
        game.setLifeAlive(1,1);
        game.setLifeAlive(2,0);
        game.setLifeAlive(2,2);
        game.printBoard();
        game.simulateLife();
        game.printBoard();
        assertTrue(game.isAlive(2,1));
    }

    @Test void d_testIsDead() {
        game.setLifeAlive(4,4);
        game.setLifeAlive(5,3);
        game.setLifeAlive(3,5);
        game.printBoard();
        game.simulateLife();
        game.printBoard();
        assertTrue(game.isDead(5,3));
    }

    @Test void e_testNumberOfNeighbours(){
        game.setLifeAlive(0,3);
        game.setLifeAlive(1,2);
        game.setLifeAlive(2,3);
        game.setLifeAlive(1,4);
        game.printBoard();
        assertEquals(4, game.numOfNeighbours(1,3));
    }

    @Test void f_testLifePopulation(){
        game.setLifeAlive(6,2);
        game.setLifeAlive(4,4);
        game.setLifeAlive(1,7);
        game.setLifeAlive(0,2);
        game.setLifeAlive(5,0);
        game.setLifeAlive(2,2);
        game.setLifeDead(4,4);
        game.printBoard();

        // NOTE There are 5 lives and (8*8)= 64 total life-space which brings 5/64 = 7.81 population
        assertEquals("4.13%", game.lifePopulation());
    }

    @Test void g_testJumpTo(){
        game.setLifeAlive(4,2);
        game.setLifeAlive(5,2);
        game.setLifeAlive(6,2);

        game.jumpTo(4);
        assertTrue(game.isAlive(5,3));
    }

    @Test void g_testSimulation(){
        game.setLifeAlive(5, 5);
        game.setLifeAlive(5, 4);
        game.setLifeAlive(5, 3);
        game.setLifeAlive(5, 6);
        game.setLifeAlive(5, 7);
        game.jumpTo(7);
        assertTrue(game.isAlive(8,6));
    }

}