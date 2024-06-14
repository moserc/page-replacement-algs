package test.java;

import main.java.Lru;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit testing for expected page faults for all three LRU algorithm configurations.
 */
public class LruTest {

    /**
     * Page fault output test for LRU algorithm configuration of 3 page frames.
     */
    @Test
    public void testLru3() {
        String input = "1,2,1,4,3,0,1";
        Lru lru = new Lru(input, 3);
        int result = lru.getPageFaultCount();
        assertEquals(6, result);
    }

    /**
     * Page fault output test for LRU algorithm configuration of 5 page frames.
     */
    @Test
    public void testLru5() {
        String input = "1,2,1,3,3,4,5,6,7";
        Lru lru = new Lru(input, 5);
        int result = lru.getPageFaultCount();
        assertEquals(7, result);
    }

    /**
     * Page fault output test for LRU algorithm configuration of 7 page frames.
     */
    @Test
    public void testLru7() {
        String input = "1,2,1,3,3,4,2,5,6,7";
        Lru lru = new Lru(input, 7);
        int result = lru.getPageFaultCount();
        assertEquals(7, result);
    }
}
