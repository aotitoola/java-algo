package b.trees;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    // APPROACH: We can use BFS for this
    // The idea is to scan the 2D Grid map and if we encounter a node that contains '1', then it is a root node
    // We can start a breadth first search based on this condition
    // start at the original point and marking each layer of '1' s

    public int numIslands(char[][] grid) {

        // input validation
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // get the dimensions of the grid, number of rows and no. of cols
        int nRows = grid.length;
        int nCols = grid[0].length;

        // we need to keep track of the visited positions
        boolean[][] visited = new boolean[nRows][nCols];

        // we create a queue
        Queue<int[]> queue = new LinkedList<>();

        // count of islands
        int islands = 0;

        // go through every row, and every column
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {

                // if we visit a zero we do not have to do anything, but if we visit a '1' i.e.
                // if grid[r][c] == "1"  . And (row, column) has not been visited before. Note that '1' is a string.
                // we run a BFS, on the current row and column

                if (grid[i][j] == '1' && !visited[i][j]) {

                    // mark the position we are at (the one we are doing our traversal on) as visited
                    // we also add it to our queue
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    bfs(grid, queue, visited);
                    // we increment the number of islands only if we get to a '1' that has not already been visited
                    islands++;
                }
            }
        }

        // we return the number of islands
        return islands;
    }


    // now we define our breadth first search
    // BFS is not a recursive algorithm. It is iterative. So we need a data structure to use for memory

    // we can create a list of the potential directions
    // right {1, 0} left {-1, 0}, top {0, 1}, bottom {0, -1}
    // for each of these directions, we check if the adjacent position of current (r, c) are in bounds
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {

        int nRows = grid.length;
        int nCols = grid[0].length;

        // while our queue is not empty, we keep expanding the island
        // we pop from the queue, the current position that we added
        // pop left is BFS, pop right turns it to DFS
        while(!queue.isEmpty()) {

            int[] current = queue.poll();

            // next we check the adjacent positions of the current item we just popped
            // for dr, dc in directions:
            for (int[] dir: directions) {

                int r = current[0] + dir[0];
                int c = current[1] + dir[1];

                // we also check if this position is a land position, i.e. == "1"
                // and lastly that the position hasn't already been visited

                if (r < 0 || r >= nRows || c < 0 || c >= nCols || visited[r][c] || grid[r][c] == '0')
                    continue;

                // if ((r > 0 && r <= nRows) && (c > 0 && c <= nCols) && grid[r][c] == '1' && !visited[r][c]) {

                // if this is the case, we add the adjacent position to our queue because have to run BFS on it as well
                // next we mark it as visited, so we don't visit it twice
                // this is our BFS method, which will continue to run until tbe queue is empty,
                // which means there is no more land to visit

                visited[r][c] = true;
                queue.offer(new int[]{r, c});
            }
        }
    }

    // Time Complexity: O (M X N) where M is the number of rows and N is the number of columns
    // Space Complexity: O (min (M, N)) this is because, in the worst case scenario, the grid is filled with land
    // size of queue can grow up to min (M, N).

}
