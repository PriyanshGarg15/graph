package striver;

import java.util.Scanner;

public class a15_surrounded_regions_replace_0_with_x_that_are_surrounnded_by_X {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Scan the border cells for 'O' and run DFS
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                helper(board, i, 0);
            }
            if (board[i][cols - 1] == 'O') {
                helper(board, i, cols - 1);
            }
        }
        
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                helper(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                helper(board, rows - 1, j);
            }
        }

        // Replace all 'O' with 'X' and '*' back to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // DFS to mark connected 'O's starting from (x, y)
    private void helper(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }

        board[x][y] = '*'; // Mark as visited

        helper(board, x + 1, y); // Down
        helper(board, x - 1, y); // Up
        helper(board, x, y + 1); // Right
        helper(board, x, y - 1); // Left
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows in the board:");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns in the board:");
        int cols = scanner.nextInt();

        char[][] board = new char[rows][cols];
        System.out.println("Enter the board values ('O' or 'X'):");
        for (int i = 0; i < rows; i++) {
            String row = scanner.next();
            for (int j = 0; j < cols; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        a15_surrounded_regions_replace_0_with_x_that_are_surrounnded_by_X solution = new a15_surrounded_regions_replace_0_with_x_that_are_surrounnded_by_X();
        solution.solve(board);

        System.out.println("Modified board:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
