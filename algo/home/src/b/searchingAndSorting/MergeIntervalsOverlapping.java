package b.searchingAndSorting;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervalsOverlapping {

    // APPROACH 1: Brute Force Approach
    // We go through each interval to find the largest overlap and add it to our result
    // how do we find an overlap, there will be an overlap if and only if
    // interval[j][0] <= interval[i][1]

    // This will be an O(N^2) solution
    // It works, but it's not very fast




    // APPROACH 2 : SORTING
    // whenever you have a brute force N^2 solution, one technique you can try is to sort your input
    // see if your input can be sorted. This is a nlog(n) operation
    // if we can come up with a linear operation, then we can have a faster algorithm

    // if we sort by the start time, such that the earlier start time comes first, we get
    // (1, 4) (2, 5) (6, 9) (9, 10)

    // since the goal is to expand into the largest interval possible, because it is sorted, we can do this in an efficient way
    // if we check the starting position of an interval, and we see that it is lesser than the ending position of a previous interval
    // tne we can merge i.e. interval[j][0] <= interval[i][1]
    // once we merge, we move on to the next interval and see if they can be merged with our newly created interval
    // we do this until we are able to merge all intervals

    public int[][] merge(int[][] intervals) {
        // first we sort the array
        // we pass the intervals and how we want to sort it
        // this way the intervals will be sorted from smallest to largest

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // ** you can try to start with a regular list
        // we need a data structure to add all our new intervals to,
        // we can use a linkedList, makes it easier to add to the last slot
        LinkedList<int[]> results = new LinkedList<>();

        // iterate through all the intervals in the intervals array
        // we look at the previous interval to see if we can extend it
        // if not, we would add the interval we are looking at as the interval to compare everything else to

        for (int[] interval : intervals) {

            // if the result list is empty, there is nothing to compare to, so we add a new entry
            // we also check if the ending position of the last item in the linked list, is before the starting position
            // of the next interval
            if (results.isEmpty() || results.getLast()[1] < interval[0]) {
                results.add(interval);
            } else {
                // else there is an overlap, we extend the interval
                results.getLast()[1] = Math.max(results.getLast()[1], interval[1]);

            }
        }

        // at this point, we have every interval possible

        // we can return the results as a 2D array
        return results.toArray(new int[results.size()][]);

        // Time Complexity: O (N) - because we went through the list once
        // --- but we also did some sorting which is O(N log N)
        //---- to bring it to a grand total of O (N log N)

        // Space Complexity; O (N)
        // extra memory which is proportional to the size of the input

    }


}





