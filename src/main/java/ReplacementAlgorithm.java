package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Abstract class to be used by the subclasses of each
 * page replacement algorithm.
 */
public abstract class ReplacementAlgorithm {

    protected int pageFaultCount; // the number of page faults
    protected int pageFrameCount; // the number of physical page frame
    protected String NAME; // the algorithm name
    protected ArrayDeque<Integer> frameDeque; // the deque to hold page frames
    protected ArrayList<Integer> inputNums = new ArrayList<>(); // holds the input as a list of numbers
    protected String input; // self-explanatory

    //constructor
    public ReplacementAlgorithm(int pageFrameCount) {
        if (pageFrameCount < 0)
            throw new IllegalArgumentException();
        this.pageFrameCount = pageFrameCount;
        resetPageFaultCount();
    }//end constructor

    /**
     * Gets the page fault count.
     * Time complexity: O(1)
     * @return - the number of page faults that occurred.
     */
    public int getPageFaultCount() {
        return pageFaultCount;
    }

    /**
     * Resets the page fault count to 0.
     * Time complexity: O(1)
     */
    public void resetPageFaultCount() {
        pageFaultCount = 0;
    }

    /**
     * Processes the input string, returns a list of page numbers.
     * Time complexity: O(n)
     */
    public ArrayList<Integer> processInput() {
        //split the string, ignore commas
        String[] splitString = input.split(",");
        inputNums.clear();
        for (String ch : splitString){
            inputNums.add(Integer.parseInt(ch));
        }
        insertInput();
        return inputNums;
    }

    /**
     * Inserts the numbers from the input list into the page frames.
     */
    public void insertInput(){
        for (int num : inputNums) {
            insert(num);
        }
    }

    /**
     * Method for managing page replacement.
     * Time complexity will vary by algorithm.
     * @param pageNumber - the page number to be inserted
     */
    public abstract void insert(int pageNumber);


    /**
     * Displays the number of page faults.
     * Time complexity: O(1)
     */
    public void display() {
        System.out.printf("Page faults with %d page frames is %d\n",
                pageFrameCount, getPageFaultCount());
    }
}
