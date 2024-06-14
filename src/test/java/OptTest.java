package test.java;

import main.java.Opt;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit testing for expected page faults for all three OPT algorithm configurations.
 */
public class OptTest {

    /**
     * Page fault output test for OPT algorithm configuration of 3 page frames.
     */
    @Test
    public void testOpt3() {
        String input = "1,2,3,4,5,6,3,2,1";
        Opt opt = new Opt(input, 3);
        int result = opt.getPageFaultCount();
        assertEquals(7, result);
    }

    /**
     * Page fault output test for OPT algorithm configuration of 5 page frames.
     */
    @Test
    public void testOpt5() {
        String input = "1,2,3,4,5,6,3,2,1";
        Opt opt = new Opt(input, 5);
        int result = opt.getPageFaultCount();
        assertEquals(6, result);
    }

    /**
     * Page fault output test for OPT algorithm configuration of 7 page frames.
     */
    @Test
    public void testOpt7() {
        String input = "1,2,3,4,5,6,3,2,1";
        Opt opt = new Opt(input, 7);
        int result = opt.getPageFaultCount();
        assertEquals(6, result);
    }
}
