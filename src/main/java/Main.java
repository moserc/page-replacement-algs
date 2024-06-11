package main.java;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        //provided input
        input.add("7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1");
        input.add("8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3");
        input.add("4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4");
        //return number of faults

        //random-generated input
        String random1 = randoString(); //number of page frames: 3
        String random2 = randoString(); //number of page frames: 5
        String random3 = randoString(); //number of page frames: 7

        System.out.printf("The three given input strings are:\n%s\n%s\n%s\n" +
                        "\nThe random-generated strings are:\n%s\n%s\n%s",
                input.get(0), input.get(1), input.get(2),
                random1, random2, random3 + "\n");

        System.out.println("\n---------------BEGIN FIFO RESULTS--------------------\n");
        input.add(random1);
        Fifo fifo3 = new Fifo(input, 3);
        fifo3.display();

        input.set(3, random2);
        Fifo fifo5 = new Fifo(input, 5);
        fifo5.display();

        input.set(3, random3);
        Fifo fifo7 = new Fifo(input, 7);
        fifo7.display();
        System.out.println("\n-----------------END FIFO RESULTS--------------------");


        System.out.println("\n---------------BEGIN LRU RESULTS---------------------\n");
        input.set(3, random1);
        Lru lru3 = new Lru(input, 3);
        lru3.display();

        input.set(3, random2);
        Lru lru5 = new Lru(input, 5);
        lru5.display();

        input.set(3, random3);
        Lru lru7 = new Lru(input, 7);
        lru7.display();
        System.out.println("\n-----------------END LRU RESULTS---------------------");


        System.out.println("\n---------------BEGIN OPT RESULTS---------------------\n");
        input.set(3, random1);
        Opt opt3 = new Opt(input, 3);
        opt3.display();

        input.set(3, random2);
        Opt opt5 = new Opt(input, 5);
        opt5.display();

        input.set(3, random3);
        Opt opt7 = new Opt(input, 7);
        opt7.display();
        System.out.println("\n-----------------END OPT RESULTS---------------------");
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
}
