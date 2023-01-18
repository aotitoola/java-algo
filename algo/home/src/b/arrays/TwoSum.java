package b.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Approach 1: Brute Force, Go through all items in two loops - O(N^2)
    // write a for loop

    // Time Complexity: O(N^2)  - for each element we loop through the rest of the array which takes O(N) time
    // Space Complexity: O(1)  - only constant space is used
    public int[] twoSumBrute(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }

        // If there is no solution, we'll just return null
        return null;
    }


    // Approach 2: use a hash table to keep positions of the values, so you don't traverse twice
    //  If the complement exists, we need to get its index.
    //  The best way to maintain a mapping of each element in the array to its index is to use a hash table.

    // Time Complexity: O(N)  - we traverse the list only once
    // Space Complexity: O(N)  - at most n elements are stored
    // A hash table is well suited for an approach where we look up items in O(1) time
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            // keep track of the remainder
            int rem = target - current;

            // check if the map already contains the remainder
            // it's easy to return the index since we have it stored already in the hash table
            if (store.containsKey(rem)) {
                return new int[] {store.get(rem), i};
            } else {
                store.put(current, i);
            }
        }

        return null;

        // Approach 3: useful if the array is sorted or, we are returning the values and not the indices
        /*  use this pointers method below only if the output does require the index

                Arrays.sort(nums);

                int left = 0;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        return new int[] {left, right};
                    }

                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }

                return null;
        */
    }

    public static void main(String[] args) {

        int[] nums = new int[] {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
