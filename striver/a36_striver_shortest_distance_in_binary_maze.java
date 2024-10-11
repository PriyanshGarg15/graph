package striver;


import java.util.*;

public class a37_striver_shortest_distance_in_binary_maze {
    public class Pair implements Comparable<Pair> {
        int row, col, dist;
        Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
    
    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid, int srcRow, int srcCol, int destRow, int destCol) {
        int n = grid.length;
        
        // Check if the source or destination is blocked.
        if (grid[srcRow][srcCol] == 1 || grid[destRow][destCol] == 1) {
            return -1;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Initialize the source point with distance 1.
        pq.add(new Pair(srcRow, srcCol, 1));
        dist[srcRow][srcCol] = 1;
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.dist;
            
            // If we have reached the destination, return the distance.
            if (row == destRow && col == destCol) {
                return distance;
            }

            // Explore all 8 possible directions.
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the new position is within bounds and not blocked.
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    if (dist[newRow][newCol] > distance + 1) {
                        dist[newRow][newCol] = distance + 1;
                        pq.add(new Pair(newRow, newCol, dist[newRow][newCol])); // or pq.add(new Pair(newRow, newCol, distance + 1)); 
                    }
                }
            }
        }
        return -1; // If no path is found, return -1.
    }

    public static void main(String[] args) {
        a37_striver_shortest_distance_in_binary_maze sol = new a37_striver_shortest_distance_in_binary_maze();
        int[][] grid1 = {{0,1},{1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid1, 0, 0, 1, 1)); // Custom source and destination
        
        int[][] grid2 = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid2, 0, 0, 2, 2)); // Custom source and destination
        
        int[][] grid3 = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid3, 0, 1, 2, 2)); // Custom source and destination
    }
}
