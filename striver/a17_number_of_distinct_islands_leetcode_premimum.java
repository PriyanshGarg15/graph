package striver;

//see image 2
//https://leetcode.ca/all/694.html
import java.util.HashSet;
import java.util.Set;

public class a17_number_of_distinct_islands_leetcode_premimum {
    
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        Set<String> distinctIslands = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder pattern = new StringBuilder();
                    dfs(grid, i, j, pattern, "S"); // Start point
                    distinctIslands.add(pattern.toString());
                }
            }
        }

        return distinctIslands.size();
    }

    public static void dfs(int[][] grid, int x, int y, StringBuilder pattern, String direction) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0; // Mark the cell as visited
        pattern.append(direction);

        dfs(grid, x + 1, y, pattern, "D"); // Down
        dfs(grid, x - 1, y, pattern, "U"); // Up
        dfs(grid, x, y + 1, pattern, "R"); // Right
        dfs(grid, x, y - 1, pattern, "L"); // Left

        pattern.append("B"); // Backtracking step to differentiate shapes



        // Consider these two different islands:

        // Island A:
        // 1 1
        // 1 0

        // Island B:
        // 1 0
        // 1 1
        // For both islands, without the backtracking step, the traversal could yield the same pattern:

        // Start at the top-left '1'
        // Move Down (D), then Right (R)
        // Without backtracking, the pattern for both islands might look like "SDR", which doesn't differentiate the two shapes correctly.

        // How the Backtracking Step Helps
        // When we append "B" for backtracking, we explicitly mark when we are returning from a DFS call. This helps to create unique patterns for different shapes:

        // For Island A:

        // Start at (0,0) -> "S"
        // Move Down to (1,0) -> "SD"
        // Move Right to (1,1) -> "SDR"
        // Backtrack from (1,1) -> "SDRB"
        // Backtrack from (1,0) -> "SDRBB"
        // Move Right to (0,1) -> "SDRBBR"
        // Backtrack from (0,1) -> "SDRBBRB"
        // Backtrack from (0,0) -> "SDRBBRBB"
        // For Island B:

        // Start at (0,0) -> "S"
        // Move Down to (1,0) -> "SD"
        // Move Down to (2,0) -> "SDD"
        // Move Right to (2,1) -> "SDDR"
        // Backtrack from (2,1) -> "SDDRB"
        // Backtrack from (2,0) -> "SDDRBB"
        // Backtrack from (1,0) -> "SDDRBBB"
        // Move Right to (1,1) -> "SDDRBBBR"
        // Backtrack from (1,1) -> "SDDRBBBRB"
        // Backtrack from (1,0) -> "SDDRBBBRBB"
        // Move Right to (0,1) -> "SDDRBBBRBBR"
        // Backtrack from (0,1) -> "SDDRBBBRBBRB"
        // Backtrack from (0,0) -> "SDDRBBBRBBRBB"



        //if not haad doen backtracked we would had got same path for diffenrt simlar looking structure
        }

    public static void main(String[] args) {
        a17_number_of_distinct_islands_leetcode_premimum solution = new a17_number_of_distinct_islands_leetcode_premimum();
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1}
        };

        System.out.println(solution.numDistinctIslands(grid)); // Output: 3
    }
}
