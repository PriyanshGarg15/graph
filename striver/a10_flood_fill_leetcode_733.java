package striver;

import java.util.Scanner;

public class a10_flood_fill_leetcode_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, originalColor, newColor); // up
        dfs(image, row + 1, col, originalColor, newColor); // down
        dfs(image, row, col - 1, originalColor, newColor); // left
        dfs(image, row, col + 1, originalColor, newColor); // right
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows in the image:");
        int rows = scanner.nextInt();
        System.out.println("Enter number of columns in the image:");
        int cols = scanner.nextInt();

        int[][] image = new int[rows][cols];
        System.out.println("Enter the image pixel values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter starting row (sr):");
        int sr = scanner.nextInt();
        System.out.println("Enter starting column (sc):");
        int sc = scanner.nextInt();
        System.out.println("Enter new color:");
        int color = scanner.nextInt();

        a10_flood_fill_leetcode_733 solution = new a10_flood_fill_leetcode_733();
        int[][] result = solution.floodFill(image, sr, sc, color);

        System.out.println("Modified image:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
