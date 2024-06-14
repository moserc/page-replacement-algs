package main.java;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Class for implementing the optimal page replacement algorithm.
 */
public class Opt extends ReplacementAlgorithm{

    ArrayList<Integer> nums;

    //constructor
    public Opt(String input, int pageFrameCount) {
        super(pageFrameCount);
        this.NAME = "OPT";
        this.input = input;
        this.frameDeque = new ArrayDeque<>(pageFrameCount);
        this.nums = new ArrayList<>();
        this.pageFaultCount = 0;
        processInput();
    }//end constructor

    /**
     * Processes the input string, returns a list of page numbers.
     */
    @Override
    public void processInput() {
        //split the string, ignore commas
        String[] splitString = input.split(",");
        for (String num : splitString){
            nums.add(Integer.parseInt(num));
        }
        insert();
    }

    /**
     *
     * @return int - the page fault count
     */
    public int insert() {

        //needs a lookahead of some kind to determine the differences in the
        //next instance's distance
        //start with fifo.
        //get next instance distance
        //replace the page that is furthest, or does not occur again


        //load the first num
        frameDeque.add(nums.remove(0));
        //get distance
        nums.indexOf(nums.get(0));

        for (int num : nums) {
            //load the first num


            if (!frameDeque.contains(num)) {
                if (frameDeque.size() >= pageFrameCount) {
                    frameDeque.poll(); //remove the head of the deque
                }
                frameDeque.add(num); //add to the tail of the deque
                pageFaultCount++;
            } else {
                frameDeque.remove(num); //remove the instance
                frameDeque.add(num); //reinsert at the tail of the deque
            }
        }
        return getPageFaultCount();
    }

    private int getDistance(int num) {
        int currentIdx = nums.indexOf(num);
        int nextOccur = -1;
        for (int i = currentIdx + 1; currentIdx < nums.size(); i++){
            if (nums.get(i) == num){
                nextOccur = i;
            }
            return nextOccur;
        }
    }

    private boolean isFarther(int num1, int num2){
        if (num1.getDistance() < num2.getDistance()){
            swap(num1, num2);
        }
    }

    private void swap(int num, int num){

    }
}
