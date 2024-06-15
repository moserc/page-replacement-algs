package main.java;

import java.util.ArrayList;

/**
 * Additional methods for operations in the Main class.
 */
public class HelperMethods {

    static ArrayList<Integer> results = new ArrayList<>();
    static int bestAverage = 0;
    static String bestAlg = "";
    static int bestConfig = -1;

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
     * @param input     - An arraylist consisting of four input strings.
     * @param pageCount - Specified number of page frames.
     */
    static void processFifo(ArrayList<String> input, int pageCount) {
        int bestResult = 0;
        for (int i = 0; i < input.size(); i++) {
            Fifo fifo = new Fifo(input.get(i), pageCount);
            System.out.printf("Input %d) ", i + 1);
            fifo.display();
            if (bestResult == 0) {
                bestResult = fifo.getPageFaultCount();
            } else if (fifo.getPageFaultCount() < bestResult) {
                bestResult = fifo.getPageFaultCount();
            }
            results.add(fifo.getPageFaultCount());
        }
        average(results, "FIFO", pageCount);
        results.clear();
    }

    /**
     * Method for processing all LRU inputs.
     * Time complexity: O(n)
     * @param input      - An arraylist consisting of four input strings.
     * @param pageCount  - Specified number of page frames.
     */
    static void processLRU(ArrayList<String> input, int pageCount) {
        int bestResult = 0;
        for (int i = 0; i < input.size(); i++) {
            Lru lru = new Lru(input.get(i), pageCount);
            System.out.printf("Input %d) ", i + 1);
            lru.display();
            if (bestResult == 0) {
                bestResult = lru.getPageFaultCount();
            } else if (lru.getPageFaultCount() < bestResult) {
                bestResult = lru.getPageFaultCount();
            }
            results.add(lru.getPageFaultCount());
        }
        average(results, "LRU", pageCount);
        results.clear();
    }

    /**
     * Method for processing all OPT inputs.
     * Time complexity: O(n)
     * @param input     - An arraylist consisting of four input strings.
     * @param pageCount - Specified number of page frames.
     */
    static void processOpt(ArrayList<String> input, int pageCount) {
        int bestResult = 0;
        for (int i = 0; i < input.size(); i++) {
            Opt opt = new Opt(input.get(i), pageCount);
            System.out.printf("Input %d) ", i + 1);
            opt.display();
            if (bestResult == 0) {
                bestResult = opt.getPageFaultCount();
            } else if (opt.getPageFaultCount() < bestResult) {
                bestResult = opt.getPageFaultCount();
            }
            results.add(opt.getPageFaultCount());
        }
        average(results, "OPT", pageCount);
        results.clear();
    }

    /**
     * Calculates the average.
     * @param list  - list of results
     * @param name  - name of the alg
     * @param pages - page frame count
     */
    static void average(ArrayList<Integer> list, String name, int pages) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        int average = sum / list.size();
        System.out.printf("Average performance for %s at %d: %d page faults\n", name, pages, average);

        if (bestAverage == 0 || average <= bestAverage){
            bestAverage = average;
            bestAlg = name;
            bestConfig = pages;
        }
    }
}
