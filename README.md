# Page Replacement Algorithms
### Page replacement algorithms for Operating Systems course


## Discussion of results
### Best configuration: Optimal Page Replacement Algorithm with 7 page frames.

All of the algorithms had a best result of six page faults in their seven-page 
frame count configuration; however, the Optimal algorithm had consistently lower 
page faults for all of its seven-page frame configuration tests. In general, it 
performed better across all configurations. This is due to the "lookahead"
component of the algorithm in which it is able to "see" future input in order to 
determine which page to replace (the page with the farthest out recurrence, or 
no recurrence). This keeps pages that will be used again soon in the page frames, 
reducing the number of page faults.

This was the more complex algorithm to code, and it is more likely to cause 
unreasonable time complexity with scaling (if both the page frame count, and 
input strings were scaled up, we'd have O(n<sup>3</sup> * m) worst-case complexity. 
Because both our page frame count, and input size are relatively small, the time 
complexity for all of these algorithms is constant. The worst-case for both FIFO, 
and LRU would be O(n<sup>2</sup>).
