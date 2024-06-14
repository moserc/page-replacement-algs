package main.java;

import java.util.ArrayList;

/**
 * Additional methods for operations in the Main class.
 */
public class HelperMethods {

    /**
     * Method for generating a String of 15 random numbers between 0-9.
     * Time complexity: 0(1)
     * @return result - the String of random integers between 0-9.
     */
    static String randoString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 15; i++){
            int randomNumber = (int)(Math.random() * 10);
            if (i != 14){
                result.append(randomNumber).append(",");
            } else {
                result.append(randomNumber);
            }
        }
        return result.toString();
    }

    /**
     * Method for processing all FIFO inputs.
     * Time complexity: O(n)
     * @param input - An arraylist consisting of four input strings.
     * @param pageCount - Specified number of page frames.
     * @param bestResult - Tracking for the lowest number of page counts.
     * @return - bestResult.
     */
    static int processFifo(ArrayList<String> input, int pageCount, int bestResult) {
        for (int i = 0; i < input.size(); i++) {
            Fifo fifo = new Fifo(input.get(i), pageCount);
            System.out.printf("Input %d) ", i + 1);
            fifo.display();
            if (bestResult == 0) {
                bestResult = fifo.getPageFaultCount();
            } else if (fifo.getPageFaultCount() < bestResult) {
                bestResult = fifo.getPageFaultCount();
            }
        }
        return bestResult;
    }

    /**
     * Method for processing all LRU inputs.
     * Time complexity: O(n)
     * @param input - An arraylist consisting of four input strings.
     * @param pageCount - Specified number of page frames.
     * @param bestResult - Tracking for the lowest number of page counts.
     * @return - bestResult.
     */
    static int processLRU(ArrayList<String> input, int pageCount, int bestResult) {
        for (int i = 0; i < input.size(); i++) {
            Lru lru = new Lru(input.get(i), pageCount);
            System.out.printf("Input %d) ", i + 1);
            lru.display();
            if (bestResult == 0) {
                bestResult = lru.getPageFaultCount();
            } else if (lru.getPageFaultCount() < bestResult) {
                bestResult = lru.getPageFaultCount();
            }
        }
        return bestResult;
    }

    /**
     * Method for processing all OPT inputs.
     * Time complexity: O(n)
     * @param input - An arraylist consisting of four input strings.
     * @param pageCount - Specified number of page frames.
     * @param bestResult - Tracking for the lowest number of page counts.
     * @return - bestResult.
     */
    static int processOpt(ArrayList<String> input, int pageCount, int bestResult) {
        for (int i = 0; i < input.size(); i++) {
            Opt opt = new Opt(input.get(i), pageCount);
            System.out.printf("Input %d) ", i + 1);
            opt.display();
            if (bestResult == 0) {
                bestResult = opt.getPageFaultCount();
            } else if (opt.getPageFaultCount() < bestResult) {
                bestResult = opt.getPageFaultCount();
            }
        }
        return bestResult;
    }

    /**
     * Updates "bestOverall" to keeps track of the lowest number of page faults
     * across all algorithms and configurations.
     * Time complexity: O(1)
     * @param bestOverall - Tracking for the lowest number of page counts across
     *                    all page replacement algorithms and configurations.
     * @param bestResult - Tracking for the lowest number of page counts.
     * @return bestOverall.
     */
    static int checkResult(int bestOverall, int bestResult){
        if (bestOverall == 0) {
            bestOverall = bestResult;
        } else if (bestResult != 0 && bestResult < bestOverall) {
            bestOverall = bestResult;
        }
        return bestOverall;
    }
}
