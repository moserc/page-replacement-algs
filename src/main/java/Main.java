package main.java;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();
        int bestOverall = 0;

        //provided input
        input.add("7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1");
        input.add("8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3");
        input.add("4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4");

        //random-generated input
        String random3 = randoString(); //number of page frames: 3
        String random5 = randoString(); //number of page frames: 5
        String random7 = randoString(); //number of page frames: 7

        System.out.printf("The three given input strings are:\n%s\n%s\n%s\n" +
                        "\nThe random-generated strings are:\n%s\n%s\n%s",
                input.get(0), input.get(1), input.get(2),
                random3, random5, random7 + "\n");

        System.out.println("\n---------------BEGIN FIFO RESULTS--------------------\n");

        int bestResult = 0;
        input.add(random3);
        bestResult = processFifo(input, 3, bestResult);
        System.out.println();

        input.set(3, random5);
        bestResult = processFifo(input, 5, bestResult);
        System.out.println();

        input.set(3, random7);
        bestResult = processFifo(input, 7, bestResult);
        System.out.printf("Best page fault result for FIFO: %d\n", bestResult);

        System.out.println("\n-----------------END FIFO RESULTS--------------------");

        /*
        System.out.println("\n---------------BEGIN LRU RESULTS---------------------\n");
        input.set(3, random3);
        Lru lru3 = new Lru(input, 3);
        lru3.display();

        input.set(3, random5);
        Lru lru5 = new Lru(input, 5);
        lru5.display();

        input.set(3, random7);
        Lru lru7 = new Lru(input, 7);
        lru7.display();
        System.out.println("\n-----------------END LRU RESULTS---------------------");


        System.out.println("\n---------------BEGIN OPT RESULTS---------------------\n");
        input.set(3, random3);
        Opt opt3 = new Opt(input, 3);
        opt3.display();

        input.set(3, random5);
        Opt opt5 = new Opt(input, 5);
        opt5.display();

        input.set(3, random7);
        Opt opt7 = new Opt(input, 7);
        opt7.display();
        System.out.println("\n-----------------END OPT RESULTS---------------------");
         */
    }

    /**
     * Method for generating a String of 15 random numbers between 0-9.
     * @return result - the String of random integers between 0-9.
     */
    private static String randoString(){
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

    private static int processFifo(ArrayList<String> input, int pageCount, int bestResult) {
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
}
