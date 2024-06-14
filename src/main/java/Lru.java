package main.java;

import java.util.ArrayDeque;

/**
 * Class for implementing the least-recently-used page replacement algorithm.
 */
public class Lru extends ReplacementAlgorithm{

    //constructor
    public Lru(String input, int pageFrameCount) {
        super(pageFrameCount);
        this.NAME = "LRU";
        this.input = input;
        this.frameDeque = new ArrayDeque<>(pageFrameCount);
        this.pageFaultCount = 0;
        processInput();
    }//end constructor

    /**
     * Similar to the FIFO algorithm except when a number appears up that is
     * already contained within the current page frames, that number gets
     * reinserted at the tail of deque to indicate that it should be 'refreshed'
     * as though it had just been inserted. This maintains the least-recently-used
     * order.
     * @param pageNumber - the page number to be inserted
     * @return int - the page fault count
     */
    @Override
    public int insert(int pageNumber) {
        //fifo except when an existing number shows up, its match should
        //move to the back of the deque
        if (!frameDeque.contains(pageNumber)) {
            if (frameDeque.size() >= pageFrameCount) {
                frameDeque.poll(); //remove the head of the deque
            }
            frameDeque.add(pageNumber); //add to the tail of the deque
            pageFaultCount++;
        } else {
            frameDeque.remove(pageNumber); //remove the instance
            frameDeque.add(pageNumber); //reinsert at the tail of the deque
        }
        return getPageFaultCount();
    }
}
