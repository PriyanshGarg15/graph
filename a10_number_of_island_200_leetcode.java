import java.util.Scanner;

public class a10_number_of_island_200_leetcode 
{
    public static int numIslands(char[][] grid) {
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

    public static void dfs(char[][] grid, int row, int col) {
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter number of columns:");
        int cols = sc.nextInt();

        char[][] grid = new char[rows][cols];
        System.out.println("Enter the grid (row-wise):");
        for (int i = 0; i < rows; i++) {
            String row = sc.next();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = row.charAt(j);
            }
        }

        int result = numIslands(grid);
        System.out.println("Number of islands: " + result);
        
        sc.close();
    }
}
