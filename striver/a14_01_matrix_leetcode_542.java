package striver;

import java.util.*;
public class a14_01_matrix_leetcode_542 {

    private static int[][] adjMatrix;

    public a14_01_matrix_leetcode_542(int v) {
        adjMatrix = new int[v+1][v+1]; // Initialize the adjacency matrix with 0s
    }

    // Method to add an edge
    public void AddEdge(int v1, int v2, int cost) {
        adjMatrix[v1][v2] = cost; // Add edge from v1 to v2
        // adjMatrix[v2][v1] = cost; // Add edge from v2 to v1 (undirected)
    }

    // Method to display the graph
    public void display() {
        for (int i = 1; i < adjMatrix.length; i++) {
            for (int j = 1; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public  int[][] updateMatrix(int[][] mat) 
    {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[m+1][n+1]; // Initialize ans with 0s by default

        Queue<int[]> q = new LinkedList<>();

        // Initialize the queue with all 0s and mark their distances as 0
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    ans[i][j] = -1; // Initialize all non-0s with -1 to signify unvisited cells
                }
            }
        }

        // Directions for moving in 4 possible directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int count = 0;

        // Perform BFS
        while (!q.isEmpty()) {
            int size = q.size();
            count++; // Increment distance count for the next level
            for(int k=0;k<size;k++) {
                int[] top = q.poll();
                int i = top[0];
                int j = top[1];

                // Check all four directions
                for (int[] dir : directions) {
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    // Check bounds and if the cell is unvisited
                    if (new_i >= 1 && new_i < m && new_j >= 1 && new_j < n && ans[new_i][new_j] == -1) {
                        mat[new_i][new_j] = 0; // Update mat to mark as visited
                        ans[new_i][new_j] = count; // Update distance in ans
                        q.add(new int[]{new_i, new_j}); // Push the cell to the queue for further processing
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        a14_01_matrix_leetcode_542 graph = new a14_01_matrix_leetcode_542(3);
        graph.AddEdge(2, 2, 1);
        graph.AddEdge(3, 1, 1);
        graph.AddEdge(3, 2, 1);
        graph.AddEdge(3, 3, 1);
        graph.display();
        int[][] ans=new int[adjMatrix.length][adjMatrix.length];
        ans=graph.updateMatrix(adjMatrix);
        System.out.println();
        for(int i=1;i<ans.length-1;i++)
        {
            for(int j=1;j<ans[0].length-1;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }
}
