package b.searchingAndSorting;

import java.util.LinkedList;
import java.util.List;

public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int marker1 = 0;
        int marker2 = 0;
        double answer = 0;

        List<Integer> result = new LinkedList<>();

        while (marker1 != nums1.length && marker2 != nums2.length) {
            if (nums1[marker1] < nums2[marker2]) {
                result.add(nums1[marker1]);
                marker1++;
            } else if (nums1[marker1] > nums2[marker2])  {
                result.add(nums2[marker2]);
                marker2++;
            } else {
                result.add(nums1[marker1]);
                result.add(nums2[marker2]);
                marker1++;
                marker2++;
            }
        }


        if (marker1 <= nums1.length - 1) {
            for (int i = marker1; i < nums1.length; i++){
                result.add(nums1[i]);
            }
        }

        if (marker2 <= nums2.length - 1) {
            for (int i = marker2; i < nums2.length; i++){
                result.add(nums2[i]);
            }
        }


        if (result.size() % 2 == 0){
            answer =  ((double)(result.get(result.size() / 2) +
                    (double) result.get(result.size() / 2 - 1)) / 2);
        } else {
            answer = (double) (result.get(result.size() / 2));
        }


        System.out.println(result);
        return answer;
    }

}
