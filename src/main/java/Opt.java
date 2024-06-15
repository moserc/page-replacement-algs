package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Class for implementing the optimal page replacement algorithm. This algorithm
 * uses a lookahead to determine which page frame will not be used for the
 * longest amount of time. When that distance is calculated, it chooses the
 * page with the longest distance as the page to replace.
 * Overall time complexity: This case - O(1); Worst case - O(n) as the input
 * string scales up; absolute worst case - O(n^3 * m) if both input and page frames
 * were significantly scaled up.
 * We know page frames will be a small constant, and therefore the frameDeque
 * size will be a small constant. This means the insert function will have an
 * O(1) runtime since we know the linear search of the contains() operation will
 * be O(1). If page frames were significantly scaled up, this would move
 * toward O(n^2).
 * The processInput operation scales with the size of the input string.
 * We know in this case it is a bounded constant <= 20.
 */
public class Opt extends ReplacementAlgorithm{

    //constructor
    public Opt(String input, int pageFrameCount) {
        super(pageFrameCount);
        this.NAME = "OPT";
        this.input = input;
        this.frameDeque = new ArrayDeque<>(pageFrameCount);
        this.pageFaultCount = 0;
        this.inputNums = processInput();
    }//end constructor

    /**
     * When the page frames are full, this method chooses the page to replace
     * by calculating the longest distance to each page's next instance within
     * the input string.
     * Time complexity: in this case, O(1) because page frames are limited to
     * a low constant; worst case as page frames scale up --> O(n^2 * m)
     *
     * @param pageNumber - the page number to be inserted
     */
    public void insert(int pageNumber) {
        //If the new page number is already in the frame set, do nothing
        //If not, replace at the appropriate spot and increment page faults
        if (!frameDeque.contains(pageNumber)) { //n

            //if there is no empty page frame, remove the page that won't be
            //needed for the longest time
            if (frameDeque.size() >= pageFrameCount) {
                int mostDistantPage = -1; //track the overall longest distance
                int mostDistance = -1; //track the locally longest distance
                int distance;

                //check the distance of the next occurrence for each page frame
                for (int page : frameDeque){ //n
                    int inputIndex = inputNums.indexOf(page);
                    int nextIndex = nextOccurrence(inputNums, page, inputIndex + 1);
                    distance = nextIndex - inputIndex;

                    //if there is no next occurrence, update and break
                    if (nextIndex == -1) {
                        mostDistantPage = page;
                        break;

                    //if the distance is larger than the biggest distance so far
                    } else if (distance > mostDistance){
                        mostDistance = distance;
                        mostDistantPage = page;
                    }
                }
                frameDeque.remove(mostDistantPage); //remove the page from the deque O(m)
            }
            frameDeque.add(pageNumber); //add new page to the tail of the deque
            pageFaultCount++;
        }
    }

    /**
     * Method for finding the index of the next occurence of a number
     * within the input string.
     * @param inputNums - the input string
     * @param page - the current element
     * @param startIndex - the index to start searching from
     * @return the index of the next occurrence; -1 if not found
     */
    public int nextOccurrence(ArrayList<Integer> inputNums, int page, int startIndex) {
        for (int i = startIndex; i < inputNums.size(); i++) {
            if (inputNums.get(i) == page) {
                return i;
            }
        }
        return -1; //not found
    }
}
