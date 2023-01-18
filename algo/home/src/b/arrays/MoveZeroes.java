package b.arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        // This is a 2 Pointer approach
        // Fast and Slow pointer
        // Bring all the non-zero elements to the front of the array
        // keeping their relative order same

        int pos = 0;

        for (int i = 0; i < nums.length; i++) {

            // if the current element is not 0, then we need to
            // append it from the front
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        // After we have finished processing new elements,
        // all the non-zero elements are already at the beginning of the array
        // we just need to fill the remaining arrays with zeroes
        for (int j = pos; j < nums.length; j++) {
            nums[j] = 0;
        }

    }
}
