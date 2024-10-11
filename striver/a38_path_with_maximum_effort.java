package striver;

import java.util.*;

public class a38_path_with_maximum_effort {
    
    public class Pair implements Comparable<Pair> {
        int row, col, effort;
        Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.effort, other.effort);
        }
    }

    // 4 possible movement directions: up, down, left, right
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        // Priority Queue to store the (row, col, effort) based on the minimum effort
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0)); // Starting point at (0,0) with 0 effort.

        // Distance array to store minimum effort required to reach each cell.
        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        // While the priority queue is not empty
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int row = current.row;
            int col = current.col;
            int currentEffort = current.effort;

            // If we reach the bottom-right corner, return the current effort.
            if (row == n - 1 && col == m - 1) {
                return currentEffort;
            }

            // Explore all four directions
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    // Calculate the effort to move to this new cell
                    int newEffort = Math.max(currentEffort, Math.abs(heights[newRow][newCol] - heights[row][col]));

                    // If this new effort is less than the currently known effort to reach this cell, update it
                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new Pair(newRow, newCol, newEffort));
                    }
                }
            }
        }

        // If no path is found (which should not happen as per problem description), return -1.
        return -1;
    }

    public static void main(String[] args) {
        a38_path_with_maximum_effort solver = new a38_path_with_maximum_effort();
        
        int[][] heights1 = {
            {1, 2, 2},
            {3, 8, 2},
            {5, 3, 5}
        };
        System.out.println(solver.minimumEffortPath(heights1)); // Expected Output: 2

        int[][] heights2 = {
            {1, 2, 3},
            {3, 8, 4},
            {5, 3, 5}
        };
        System.out.println(solver.minimumEffortPath(heights2)); // Expected Output: 1

        int[][] heights3 = {
            {1, 10, 6, 7, 9, 10, 4, 9}
        };
        System.out.println(solver.minimumEffortPath(heights3)); // Expected Output: 9
    }
}
