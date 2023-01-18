package b.arrays;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        // sort the input array
        Arrays.sort(nums);

        // use a set to store the results to ensure there are no duplicates
        Set<List<Integer>> result = new HashSet<>();

        // three sum
        // loop till the last 2 items
        for (int i = 0; i < nums.length - 2; i++){

            // if the current value is the same as the one before, skip it
            if (i == 0 || nums[i] != nums[i - 1]) {

                // perform two-sum
                twoSum(nums, i, result);
            }
        }

        return new ArrayList<>(result);
    }


    public static void twoSum(int[] nums, int i, Set<List<Integer>> result) {

        int left = i + 1;
        int right = nums.length - 1;

        // two sum
        while (left < right) {

            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
