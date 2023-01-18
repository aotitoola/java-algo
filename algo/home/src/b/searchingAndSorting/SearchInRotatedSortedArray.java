package b.searchingAndSorting;

public class SearchInRotatedSortedArray {

    // The Problem says we should write an algorithm with O (log n) runtime complexity
    // In binary search, we repeatedly divide the search interval in half. The idea here is to use the
    // information that the array is sorted and reduce the time complexity to O (log N)

    // TRADITIONAL BINARY SEARCH ALGORITHM
    //    Sort the array in ascending order.
    //    Set the low index to the first element of the array and the high index to the last element.
    //    Set the middle index to the average of the low and high indices.
    //    If the element at the middle index is the target element, return the middle index.
    //    If the target element is less than the element at the middle index, set the high index to the middle index – 1.
    //    If the target element is greater than the element at the middle index, set the low index to the middle index + 1.
    //    Repeat steps 3-6 until the element is found, or it is clear that the element is not present in the array.


    // APPROACH: One-Pass Binary Search
    // Instead of going through the array two times, we can do it once
    // we add some condition checks to narrow down the scope of the search

    // ALGORITHM;
    // 1. Initialise start pointer to 0 and pointer end to n - 1
    // 2. Perform binary search while start <= end
    // 3. We take an index in the middle, mid as a pivot
    // 4. If nums[mid] == target, then the job is done & we return the element in the middle
    // 5.  We can run into 2 situations:
    //      1 -- the pivot element may be larger than the first element in the array. This means the sub array on the
    //        -- left is non-rotated. If this is the case, we go left
    //        --  i.e. end = mid - 1
    //        --  otherwise, we go right: start = mid + 1
    //
    //      2 -- the pivot element is smaller than the first element in the array. This means the sub array on the
    //        -- right is probably non-rotated. and the rotation index is somewhere between 0 & mid.
    //        -- If this is the case, we go right
    //        --  i.e. start = mid + 1
    //        -- otherwise, we go left, end = mid - 1
    //
    // 6. if the target is not found, we return -1


    public int search(int[] nums, int target) {

        // Initialise start pointer to 0 and pointer end to n - 1
        int start = 0;
        int end = nums.length - 1;

        // Perform binary search while start <= end
        while (start <= end) {
            // We take an index in the middle, mid as a pivot
            // this will give us the right pivot to work with at every iteration
            int mid = start + (end - start) / 2;

            // If nums[mid] == target, then the job is done & we return the element in the middle
            if (nums[mid] == target) {
                return  mid;
            } else if (nums[mid] >= nums[start]) {
                // if the pivot element is larger than the first element in the array

                // check if the target is in-between start and pivot
                if (target >= nums[start]  &&  target < nums[mid]) {
                    // we move the end pointer
                    end = mid - 1;
                } else {
                    // we move the start pointer
                    start = mid + 1;
                }

            } else {

                // check if the target is in-between pivot and end
                if (target > nums[mid]  &&  target <= nums[end]) {
                    // we move the start pointer
                    start = mid + 1;
                } else {
                    // we move the end pointer
                    end = mid - 1;
                }
            }
        }

        // if not found
        return -1;
    }

    // Time complexity: O (log N) - we are always halving the search scope
    // Space Complexity: O(1) - No additional space was used

}
