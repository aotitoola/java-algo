package educative.slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;



// Leetcode 239: Hard
public class MaximumInSlidingWindow {

    // Process the first w elements to initiate the window deque.
    // Start iterating the array.
    // In the window, only keep the indexes of elements from the current sliding window.
    // Remove indexes of all elements smaller than the current element from the window.
    // Add the current element to the window.
    // Add the first element of the window to the output list.
    // Repeat the above steps until the entire array is traversed.


    // We use a dq to represent the sliding window.
    // As we slide the window forward, first of all we need to drop out the element which has exited the sliding window.
    // We can know this by storing the element indexes in the dq.
    // So if the front of the dq has an index which is k or more steps behind the current index, we need to remove it from the dq.
    // Next, a new element enters the window.
    // Now this new element could be larger than some elements already in the dq.
    // If, yes, this means that those smaller elements must exit the dq because
    // they can never be the largest element in the current sliding window. So we drop all the elements from
    // the tail of dq which are smaller than the current element.
    // We add the current element in the dq.
    // Finally, we peek the front on the dq to get the largest elements in the current sliding window.
    // It is implicitly ensured that the front of the dq will have the largest element of the sliding window because
    // any elements smaller than it would have already been dropped when it entered the dq. See step above.
    // One way of looking at the dq is to see it as an arrangement of elements in descending order
    // with the front (leftmost) always having the largest value.

    public static List<Integer> findMaxInWindow(List<Integer> nums, int windowSize) {

        List<Integer> result = new ArrayList<>();

        Deque<Integer> window = new ArrayDeque<>();

        if (windowSize > nums.size()) {
            windowSize = nums.size();
        }

        // iterate through all element contained in window.
        // this takes O(n)
        for (int i = 0; i < windowSize; i++) {

            // for every element remove the smaller elements from window
            while (!window.isEmpty() && nums.get(window.peekLast()) < nums.get(i)) {
                window.removeLast();
            }


        }



        return result;
    }



    public static void main(String[] args) {

        int[] input = {-4, 2, -5, 3, 6};
        int w_size = 3;

        // find current max value in the window as it slides through array
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = left + w_size;

        while (right <= input.length) {




            left++;
        }

        for (int i = 0; i < input.length; i++) {





        }


    }
}
