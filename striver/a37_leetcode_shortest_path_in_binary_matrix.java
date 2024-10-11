//same just no source and des here we have start and end and we can travel in 8 directiosn that it !
//here 0 means we can proceed and 1 means we cant also to reach inrial also +1 distance is needed !
package striver;

import java.util.*;

public class a37_leetcode_shortest_path_in_binary_matrix {
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
    
    private static int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        //according to question:-
        //intial par phauch neh ke liye bhi ek distance lagega !
        pq.add(new Pair(0, 0, 1));
        dist[0][0] = 1;
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.dist;
            
            // the algorithm will still give the shortest distance even though it immediately returns when it reaches the final point. The reason for this 
            // is that Dijkstra’s algorithm (with a priority queue) always processes the current shortest path first.
            //although in this question distance doesnt matter becz we are considering 1 distance movement so we could also used queue no differnce !
            
            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    if (dist[newRow][newCol] > distance + 1) {
                        dist[newRow][newCol] = distance + 1;
                        pq.add(new Pair(newRow, newCol, dist[newRow][newCol])); // or pq.add(new Pair(newRow, newCol, distance + 1)); 
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        a37_leetcode_shortest_path_in_binary_matrix sol = new a37_leetcode_shortest_path_in_binary_matrix();
        int[][] grid1 = {{0,1},{1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid1)); 
        int[][] grid2 = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid2));
        int[][] grid3 = {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(sol.shortestPathBinaryMatrix(grid3));
    }
}
