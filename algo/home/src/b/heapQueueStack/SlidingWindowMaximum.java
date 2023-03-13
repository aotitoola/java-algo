package b.heapQueueStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;

        // initialise results set
        int[] results = new int[n - k + 1];

        // our index
        int rIndex = 0;

        // a deque is sorted in decreasing order
        // the largest value stay at the first element

        // if current element is larger than first element, remove first element in deque
        // then add current element to the beginning of the deque

        // if we want to know the max element in that window,
        // it will be the max element in that deque at that time
        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // remove numbers out of the range of our window, k
            // i - k + 1 is basically the head of the current window
            while(!deq.isEmpty() && deq.peekFirst() < i - k + 1) {
                deq.pollFirst();
            }

            // remove smaller numbers in k (window) range as they are useless
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }

            // deq contains our indexes, results contains content
            // a deque is sorted in decreasing order
            // insert from the back
            deq.offerLast(i);

            if (i >= k - 1) {
                results[rIndex] = nums[deq.peekFirst()];
                rIndex++;
            }

        }
        return results;
    }
}
