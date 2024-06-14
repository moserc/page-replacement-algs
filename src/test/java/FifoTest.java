package test.java;

import main.java.Fifo;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit testing for expected page faults for all three OPT algorithm configurations.
 */
public class FifoTest {

    /**
     * Page fault output test for FIFO algorithm configuration of 3 page frames.
     */
    @Test
    public void testFifo3() {
        String input = "1,2,3,4,0,0,0,0,4,3,2,1";
        Fifo fifo = new Fifo(input, 3);
        int result = fifo.getPageFaultCount();
        assertEquals(7, result);
    }

    /**
     * Page fault output test for FIFO algorithm configuration of 5 page frames.
     */
    @Test
    public void testFifo5() {
        String input = "1,2,3,4,5,6,7,0,4,3,2,1";
        Fifo fifo = new Fifo(input, 5);
        int result = fifo.getPageFaultCount();
        assertEquals(11, result);
    }

    /**
     * Page fault output test for FIFO algorithm configuration of 7 page frames.
     */
    @Test
    public void testFifo7() {
        String input = "1,2,3,4,5,6,7,0,4,3,2,1";
        Fifo fifo = new Fifo(input, 7);
        int result = fifo.getPageFaultCount();
        assertEquals(9, result);
    }
}
