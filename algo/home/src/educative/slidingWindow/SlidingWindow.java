package educative.slidingWindow;


/*
*  ** Sliding Window
*   Aimed at reducing nested loops in an algorithm.
*   Pointers are set to window (sublist) bounds.
*
*   The goal is not to iterate over all the elements because this gives O(kn) which is O(n^2)
*   Instead, we focus on the element entering the window and the one leaving the window.
*   Each time we move the window, we perform at most k operations with is still O(n) because k is constant
*
*  ** Conditions Matching this pattern:
*   1. repeated computation on a contiguous set of data elements (subarray or string). Window size may be fixed or variable
*   2. The computations at every window takes O(1) time or less
*
*   DO NOT USE, if:
*   1. Input data structure does not support random access
*   2. You have to process entire data without segmentation
*
* */
public class SlidingWindow {
}
