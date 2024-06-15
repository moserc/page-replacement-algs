package main.java;

import java.util.ArrayList;
import static main.java.HelperMethods.*;

/**
 * Driver class for testing each page replacement algorithm and
 * outputting the results.
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        //provided input
        input.add("7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1");
        input.add("8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3");
        input.add("4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4");

        //random-generated input, three random strings for three configurations
        String random3 = randoString(); //for 3 page frame config
        String random5 = randoString(); //for 5 page frame config
        String random7 = randoString(); //for 7 page frame config

        System.out.printf("The three given input strings are:\n%s\n%s\n%s\n" +
                        "\nThe random-generated strings are:\n%s\n%s\n%s",
                input.get(0), input.get(1), input.get(2),
                random3, random5, random7 + "\n");

        System.out.println("\n---------------BEGIN FIFO RESULTS--------------------\n");

        input.add(random3);
        processFifo(input, 3);
        System.out.println();

        input.set(3, random5);
        processFifo(input, 5);
        System.out.println();

        input.set(3, random7);
        processFifo(input, 7);

        System.out.println("\n-----------------END FIFO RESULTS--------------------");

        System.out.println("\n---------------BEGIN LRU RESULTS---------------------\n");

        input.set(3, random3);
        processLRU(input, 3);
        System.out.println();

        input.set(3, random5);
        processLRU(input, 5);
        System.out.println();

        input.set(3, random7);
        processLRU(input, 7);

        System.out.println("\n-----------------END LRU RESULTS---------------------");

        System.out.println("\n---------------BEGIN OPT RESULTS---------------------\n");

        input.set(3, random3);
        processOpt(input, 3);
        System.out.println();

        input.set(3, random5);
        processOpt(input, 5);
        System.out.println();

        input.set(3, random7);
        processOpt(input, 7);

        System.out.println("\n-----------------END OPT RESULTS---------------------");

        System.out.printf("\nBEST OVERALL: %s at %d pages with an average performance of" +
                " %d page faults", bestAlg, bestConfig, bestAverage);
    }
}
