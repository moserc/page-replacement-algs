package main.java;

import java.util.ArrayDeque;

/**
 * Class for implementing the least-recently-used page replacement algorithm.
 * Overall time complexity: This case - O(1); worst case - O(n) as the input
 * string scales up; absolute worst case - O(n^2) if both input and page frames
 * were significantly scaled up.
 *
 * We know page frames will be a small constant, and therefore the frameDeque
 * size will be a small constant. This means the insert function will have an
 * O(1) runtime since we know the linear search of the contains() operation will
 * be O(1). If page frames were significantly scaled up, this would move
 * toward O(n).
 *
 * The processInput operation scales with the size of the input string.
 * We know in this case it is a bounded constant <= 20.
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
     * Time complexity: O(1) because the frameDeque is held to a maximum
     * size of 7, the contains() operation only has to check a few indices.
     * If the number of page frames was significantly larger, we would
     * approach O(n).
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
