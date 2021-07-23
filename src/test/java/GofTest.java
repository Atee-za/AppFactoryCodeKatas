import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GofTest {
    Gof game;
    @BeforeEach void setup(){
        game = new Gof(8, 8, 0);
    }

    @Test void setLifeAlive() {
        game.setLifeAlive(1,1);
        game.setLifeAlive(2,0);
        game.setLifeAlive(2,2);
        game.printBoard();
        game.simulateLife();
        game.printBoard();
        assertTrue(game.isAlive(2,1));
        //game.simulateLife();
    }

    @Test void setLifeDead() {
        game.setLifeAlive(4,4);
        game.setLifeAlive(5,3);
        game.setLifeAlive(3,5);
        game.printBoard();
        game.simulateLife();
        game.printBoard();
        assertFalse(game.isDead(4,4));
    }

    @Test void numberOfNeighbours(){
        game.setLifeAlive(0,3);
        game.setLifeAlive(1,2);
        game.setLifeAlive(2,3);
        game.setLifeAlive(1,3);
        game.printBoard();
    }

    @Test void checkLifePopulation(){
        game.setLifeAlive(6,2);
        game.setLifeAlive(4,4);
        game.setLifeAlive(1,7);
        game.setLifeAlive(0,2);
        game.setLifeAlive(5,0);
        game.setLifeAlive(2,2);
        game.setLifeDead(4,4);
        game.printBoard();

        // NOTE There are 5 lives and (8*8)= 64 total-space which brings 5/64 = 7.81
        assertEquals("7.81%", game.lifePopulation());
    }

}