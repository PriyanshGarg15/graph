package striver;

import java.util.Scanner;

public class a9_number_of_isldand_leetcode_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands += 1;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';  // Mark the cell as visited

        dfs(grid, row - 1, col); // up
        dfs(grid, row + 1, col); // down
        dfs(grid, row, col - 1); // left
        dfs(grid, row, col + 1); // right
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns:");
        int cols = scanner.nextInt();
        
        char[][] grid = new char[rows][cols];
        System.out.println("Enter the grid elements (1 for land, 0 for water):");
        for (int i = 0; i < rows; i++) {
            String row = scanner.next();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        a9_number_of_isldand_leetcode_200 solution = new a9_number_of_isldand_leetcode_200();
        int numIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numIslands);

        scanner.close();
    }
}
