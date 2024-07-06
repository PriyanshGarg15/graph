package striver;

import java.util.Scanner;

public class a16_number_of_enclave_leetcode_1020 {
    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Scan the border cells for 1 and run DFS
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                helper(grid, i, 0);
            }
            if (grid[i][cols - 1] == 1) {
                helper(grid, i, cols - 1);
            }
        }
        
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                helper(grid, 0, j);
            }
            if (grid[rows - 1][j] == 1) {
                helper(grid, rows - 1, j);
            }
        }

        int count = 0;
        // Count remaining 1s, these are enclaved lands
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // DFS to mark connected 1s starting from (x, y)
    private void helper(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }

        grid[x][y] = -1; // Mark as visited

        helper(grid, x + 1, y); // Down
        helper(grid, x - 1, y); // Up
        helper(grid, x, y + 1); // Right
        helper(grid, x, y - 1); // Left
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows in the grid:");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns in the grid:");
        int cols = scanner.nextInt();

        int[][] grid = new int[rows][cols];
        System.out.println("Enter the grid values (1 for land, 0 for water):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        a16_number_of_enclave_leetcode_1020 solution = new a16_number_of_enclave_leetcode_1020();
        int numEnclaves = solution.numEnclaves(grid);
        System.out.println("Number of enclaves: " + numEnclaves);

        scanner.close();
    }
}
