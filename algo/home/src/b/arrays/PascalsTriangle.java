package b.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    // Time Complexity: O(n^2)
    // Space Complexity: O (1)
    // This space complexity is constant because the space used by the output does not count towards the complexity
    // The previous and the current row both reference the same memory as the output

    // we construct each row based on the previous row
    public List<List<Integer>> construct(int numRows) {

        // we build the intuition by left-aligning each row
        // we notice that each row has 1 on both sides except for the first row
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // we iterate through the remainder of numRows skipping the first row
        for (int row = 1; row < numRows; row++) {

            // try to imagine that you are trying to create the 5th row
            // create what would be the current row
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(row - 1);

            // we know that the first entry in a row will be 1
            currentRow.add(1);

            // now we go through each column of the current row and try to populate it
            // we know that the entries in between the 1s equal to the length of the previous row - 1
            for (int col = 1; col < prevRow.size(); col++) {
                currentRow.add(prevRow.get(col - 1) + prevRow.get(col));
            }

            // we also know that the last entry in a row will be 1
            currentRow.add(1);

            // once we are done, we add the current row to the results
            triangle.add(currentRow);
        }

        return triangle;
    }



}
