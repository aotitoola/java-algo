package b.heapQueueStack;

public class TrappingRainWater {

    // APPROACH 1: BRUTE FORCE.
    // For each element in the array, the goal is to find the maximum level of water
    // it can trap after the rain
    // this is equal to the minimum of (the maximum of the height of bars on either sides)
    // minus its own height

    public int trapV2(int[] heights) {

        // STEP 1: Initialise results to zero
        int result = 0;

        // STEP 2; Iterate the array from left to right
        // We start iteration from index 1, this way we can compare what's on the left
        for (int i = 1; i < heights.length; i ++) {
            // Initialise leftMax and rightMax to 0
            int leftMax = 0;
            int rightMax = 0;

            // we search the left for the maximum height
            for (int j = i; j >= 0; j--) {
                // we compare the current height with the left maximum
                leftMax = Math.max(leftMax, heights[j]);
            }

            // we also search the right for the maximum height
            for (int j = i; j < heights.length; j++) {
                // we compare the current height with the right maximum
                rightMax = Math.max(rightMax, heights[j]);
            }

            // we get the minimum of the max heights and then subtract the current height from it
            result += Math.min(leftMax, rightMax) - heights[i];
        }

        // we return the result
        return result;
    }

    // Time Complexity: O(N) - for each element, we go through the left and right parts
    // Space Complexity: O(1) - No extra space




    // APPROACH 2: USING 2 POINTERS
    // Instead of checking the left part and the right part separately, we can find a way to do it in one iteration
    // If we take a closer look at the problem, we can conclude that as long as the right maximum at an index is greater
    // than the left maximum at that index, i.e. rightMax[i] > leftMax[i], then the leftMax determines how much water is
    // trapped. Similarly, when leftMax[i] > rightMax[i], then the rightMax determines how much water is retained.
    // For example, if the bar at the right is smaller, we iterate from right to left and vice versa.

    // ALGORITHM:
    // STEP 1: Initialise leftPointer to 0, and rightPointer to length - 1
    // STEP 2: Iterate while left is less than right
    // STEP 3:
    //      If heights[left] < heights[right]:
    //          we then check, if heights[left] >= leftMax:
    //                update leftMax with heights[left]
    //           else we add leftMax - heights[left] to the result
    //           finally, add 1 to left

    //      Else (i.e.. If heights[left] > heights[right]:)
    //          we then check, if heights[right] >= rightMax:
    //                update rightMax with heights[right]
    //          else we add rightMax - heights[right] to the result
    //          finally, subtract 1 from left to update the pointer



    public int trap(int[] heights) {
        // Initialise leftPointer to 0, and rightPointer to length - 1
        int left = 0;
        int right = heights.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        // Iterate while left is less than right
        while (left < right) {

            if (heights[left] > leftMax) {
                leftMax = heights[left];
            }

            if (heights[right] > rightMax) {
                rightMax = heights[right];
            }

            if (leftMax < rightMax) {
                result += Math.max(0, leftMax - heights[left]);
                left++;
            } else {
                result += Math.max(0, rightMax - heights[right]);
                right--;
            }
        }

        return result;
    }


}
