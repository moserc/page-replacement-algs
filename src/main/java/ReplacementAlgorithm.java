package main.java;

import java.util.ArrayDeque;

public abstract class ReplacementAlgorithm {
    // the number of page faults
    protected int pageFaultCount;

    // the number of physical page frame
    protected int pageFrameCount;

    // the least number of page faults
    protected int bestResult;

    // the algorithm name
    protected String NAME;

    ArrayDeque<Integer> frameDeque;

    String input;

    /**
     * @param pageFrameCount - the number of physical page frames
     */
    public ReplacementAlgorithm(int pageFrameCount) {
        if (pageFrameCount < 0)
            throw new IllegalArgumentException();

        this.pageFrameCount = pageFrameCount;
        resetPageFaultCount();
    }

    /**
     * @return - the number of page faults that occurred.
     */
    public int getPageFaultCount() {
        return pageFaultCount;
    }

    public void resetPageFaultCount() {
        pageFaultCount = 0;
    }

    public String getName() {
        return NAME;
    }

    public int getBestResult() {
        return bestResult;
    }

    /**
     * Processes the input string, returns a list of page numbers.
     */
    public abstract void processInput();

    /**
     * @param pageNumber - the page number to be inserted
     * @return int - the page fault count
     */
    public abstract int insert(int pageNumber);


    public void display() {
        System.out.printf("Page faults with %d page frames is %d\n", pageFrameCount, getPageFaultCount());
    }
}
