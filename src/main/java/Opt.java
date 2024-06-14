package main.java;

import java.util.ArrayList;

public class Opt extends ReplacementAlgorithm{

    ArrayList<String> input;
    String random;

    /**
     * @param pageFrameCount - the number of physical page frames
     */
    public Opt(ArrayList<String> input, int pageFrameCount) {
        super(pageFrameCount);
        this.input = input;
    }

    /**
     * Processes the input string, returns a list of page numbers.
     */
    public void processInput() {

    }

    /**
     * @param pageNumber - the page number to be inserted
     * @return
     */
    public int insert(int pageNumber) {

        return pageNumber;
    }
}
