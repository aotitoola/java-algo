package b.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    // To build intuition revisit this: https://www.youtube.com/watch?v=HbbYPQc-Oo4&ab_channel=TECHDOSE
    // https://leetcode.com/problems/subarray-sum-equals-k/solutions/127728/official-solution/
    // https://www.youtube.com/watch?v=fFVZt-6sgyo&ab_channel=NeetCode

    public int subArraySum(int[] nums, int k) {

        // Approach 1: time: O(n^2)

        //        int count = 0;
        //        for (int start = 0; start < nums.length; start++) {
        //            int sum=0;
        //            for (int end = start; end < nums.length; end++) {
        //                sum+=nums[end];
        //                if (sum == k)
        //                    count++;
        //            }
        //        }
        //        return count;


        // the goal is to find all the sub-arrays that equals k
        // this approach uses the idea of a prefix sum
        // as we go through the array, we keep a sum of all the items that we encounter along the way
        // this sum is the prefixSum, also called the left-sum value
        // we iterate from the beginning to the end of the array and keep updating the prefix sum

        // this hashmap will store every particular sum, at each item and
        // the value will be the number of times it has happened up until the current iteration
        Map<Integer, Integer> map = new HashMap<>();

        // ** initially skip this stage in the interview
        // this is added for cases where the current sum equals exactly k ()
        map.put(0, 1);

        // this operation above can be replaced by putting below in the for-loop
        //        if(currSum==k)
        //            count++;

        // imagine that we have a start and end for each sub-array
        // if the sum of all the items in the sub-array equals k
        // then it would imply that
        // end = start + k
        // therefore, start = end - k
        // i.e. end of the current subArray is also the total sum so far
        // so, current - k
        // the sum of the previous arrays just before the new subarray will be 'start'

        // count stores the number of times we have a sub-array with sum of k
        int count = 0;
        int sum = 0;

        // let's loop through the entire array once
        for (int i = 0; i < nums.length; i++){

            // first, we add every entry into our sum
            sum += nums[i];

            // we check if the map contains (sum - k)
            // this is to see if we have already encountered this sum previously
            if (map.containsKey(sum - k)) {

                // we increment the count by the value of the key
                // we increment by (sum - k) instead of doing count++ because
                // we can have more than one occurrence of a prefix sum if there are negative values in the array.
                // e.g. if we have a previous sub array like [2,-3,1], it sums to zero
                // Every next occurring k will also pair with those negative values to form a sub-array
                // if we do count++, it will not reflect the actual picture, because we can also get new sub-arrays by
                // adding up the previous sub-array that sums up to zero
                count += map.get(sum - k);
            }

            // we add the currentSum to the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
