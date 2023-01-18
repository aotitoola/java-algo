package b.heapQueueStack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public int minMeetingRooms(int[][] intervals) {
        // instead of looping, we can use a min-heap

        // check for the base case. if there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // min-heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // sort the intervals by start time
        Arrays.sort(intervals,
                new Comparator<int[]>() {
                    public int compare(final int[]a, final int[]b) {
                        return a[0] - b[0];
                    }
                });

        // add the first meeting, end time
        allocator.add(intervals[0][1]);


        // iterate over the remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // if the rool due to free up the earliest time is free
            // assign that room to this meeting
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // if a new room is to be assigned, then also, we add to the heap,
            // if an old room is allocated,
            // then also we have to add to the heap with updated end time
            allocator.add(intervals[i][1]);

        }


        // the size of the heap tells us the minimum rooms required for all the meetings
        return allocator.size();

    }
}
