package main.java;

import java.util.ArrayDeque;

/**
 * Class for implementing the first-in, first-out page replacement algorithm.
 */
public class Fifo extends ReplacementAlgorithm{

    //constructor
    public Fifo(String input, int pageFrameCount) {
        super(pageFrameCount);
        this.NAME = "FIFO";
        this.input = input;
        this.frameDeque = new ArrayDeque<>(pageFrameCount);
        this.pageFaultCount = 0;
        processInput();
    }//end constructor

    /**
     * Inserts pages with first-in, first-out ordering.
     * A deque is used for removing from the head and adding to the tail
     * when the deque size exceeds the frame size.
     * @param pageNumber - the page number to be inserted
     * @return int - the page fault count
     */
    @Override
    public int insert(int pageNumber) {
        //If the new page number is already in the frame set, do nothing
        //else replace at the appropriate spot, and increment page faults
        if (!frameDeque.contains(pageNumber)) {
            if (frameDeque.size() >= pageFrameCount) {
                frameDeque.poll(); //remove the head of the deque
            }
            frameDeque.add(pageNumber); //add to the tail of the deque
            pageFaultCount++;
        }
        return getPageFaultCount();
    }
}
