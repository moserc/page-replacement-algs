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
     * @param pageNumber - the page number to be inserted
     */
    public void insert(int pageNumber) {

    }
}
