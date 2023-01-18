package b.arrays;

public class MergeSortedArray {


    public void mergeArray(int[] nums1, int m, int[]nums2, int n) {

        // Solution 1: Sorting. Naive solution
        // Copy the elements in nums2 into the later part of nums1 and then sort it
        // Time Complexity: O(N), O(1)
        // For Sorting in Java: Time - O ((M + N) log (M + N)), Space - O (log (M + N))

        //        for (int i = 0; i < n; i++) {
        //            nums1[m + i] = nums2[i];
        //        }
        //
        //        Arrays.sort(nums1);

        // Sorting Operation takes the most time. How can we improve on this
        // We can see that the algo is already sorted ascending order
        // we use 2 reader pointer and 1 writer pointer
        // postfix decrement
        // r1 starts from the (m - 1)th element
        // r2 starts from the (n - 1)th element
        // w starts from (m + n - 1)th element as we are writing from the back of nums1
        // always check that r1 or r2 is always greater than or equal to zero
        // Time Complexity: O (M + N)
        // Space Complexity: 0 (1)

        int r1 = m - 1;
        int r2 = n - 1;

        for (int w = m + n - 1; w >= 0; w--) {
            if (r1 >= 0 && r2 >= 0) {
                nums1[w] = nums1[r1] > nums2[r2] ? nums1[r1--] : nums2[r2--];
            } else if (r1 >= 0) {
                nums1[w] = nums1[r1--];
            } else {
                nums1[w] = nums2[r2--];
            }
        }

    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;


    }
}
