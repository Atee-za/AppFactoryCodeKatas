import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GolTest {
    Gol game;
    @BeforeEach void setup(){
        game = new Gol(8, 8, 0);
    }

    @Test void testSetAlive(){
        game.setLifeAlive(5,5);
        game.printBoard();
        assertEquals(1,game.board[5][5]);
    }

    @Test void testSetDead(){
        game.printBoard();
        assertEquals(0,game.board[5][5]);
    }

    @Test void testIsAlive() {
        game.setLifeAlive(1,1);
        game.setLifeAlive(2,0);
        game.setLifeAlive(2,2);
        game.printBoard();
        game.simulateLife();
        game.printBoard();
        assertTrue(game.isAlive(2,1));
    }

    @Test void testIsDead() {
        game.setLifeAlive(4,4);
        game.setLifeAlive(5,3);
        game.setLifeAlive(3,5);
        game.printBoard();
        game.simulateLife();
        game.printBoard();
        assertTrue(game.isDead(5,3));
    }

    @Test void testNumberOfNeighbours(){
        game.setLifeAlive(0,3);
        game.setLifeAlive(1,2);
        game.setLifeAlive(2,3);
        game.setLifeAlive(1,4);
        game.printBoard();
        assertEquals(4, game.numOfNeighbours(1,3));
    }

    @Test void testLifePopulation(){
        game.setLifeAlive(6,2);
        game.setLifeAlive(4,4);
        game.setLifeAlive(1,7);
        game.setLifeAlive(0,2);
        game.setLifeAlive(5,0);
        game.setLifeAlive(2,2);
        game.setLifeDead(4,4);
        game.printBoard();

        // NOTE There are 5 lives and (8*8)= 64 total life-space which brings 5/64 = 7.81 population
        assertEquals("7.81%", game.lifePopulation());
    }

}