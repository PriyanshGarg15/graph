package striver;

import java.util.LinkedList;
import java.util.Queue;

public class a11_rotten_oranges_leetcode {
    public static void main(String[] args) {
        int[][] adjmatrix = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = rottenOranges(adjmatrix);
        System.out.println("Minutes to rot all oranges: " + result);
    }

    public static int rottenOranges(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        // Initialize the queue with all the initially rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // BFS to rot adjacent fresh oranges
        while (!q.isEmpty()) {
            int size = q.size();
            boolean hasRotten = false;
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.add(new int[]{newRow, newCol});
                        freshOranges--;
                        hasRotten = true;
                    }
                }
            }

            if (hasRotten) {
                minutes++;
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
}
