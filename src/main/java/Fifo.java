package main.java;

import java.util.ArrayDeque;

/**
 * Class for implementing the first-in, first-out page replacement algorithm.
 * Overall time complexity: This case - O(1); worst case - O(n) as the input
 * string scales up; absolute worst case - O(n^2) if both input and page frames
 * were significantly scaled up.
 * We know page frames will be a small constant, and therefore the frameDeque
 * size will be a small constant. This means the insert function will have an
 * O(1) runtime since we know the linear search of the contains() operation will
 * be O(1). If page frames were significantly scaled up, this would move
 * toward O(n).
 * The processInput operation scales with the size of the input string.
 * We know in this case it is a bounded constant <= 20.
 */
public class Fifo extends ReplacementAlgorithm{

    //constructor
    public Fifo(String input, int pageFrameCount) {
        super(pageFrameCount);
        this.NAME = "FIFO";
        this.input = input;
        this.frameDeque = new ArrayDeque<>(pageFrameCount);
        this.pageFaultCount = 0;
        processInput(); //O(n)
    }//end constructor

    /**
     * Inserts pages with first-in, first-out ordering.
     * A deque is used for removing from the head and adding to the tail
     * when the deque size exceeds the frame size.
     * Time complexity: O(1) because the frameDeque is held to a maximum
     * size of 7, the contains() operation only has to check a few indices.
     * If the number of page frames was significantly larger, we would
     * approach O(n).
     *
     * @param pageNumber - the page number to be inserted
     */
    @Override
    public void insert(int pageNumber) {
        //If the new page number is already in the frame set, do nothing
        //else replace at the appropriate spot, and increment page faults
        if (!frameDeque.contains(pageNumber)) {
            if (frameDeque.size() >= pageFrameCount) {
                frameDeque.poll(); //remove the head of the deque
            }
            frameDeque.add(pageNumber); //add to the tail of the deque
            pageFaultCount++;
        }
    }
}
