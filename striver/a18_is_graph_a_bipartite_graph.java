package striver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a18_is_graph_a_bipartite_graph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: not colored, 1: color 1, -1: color 2

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // if not colored
                if (!bfs(graph, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1; // Start coloring with color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (colors[neighbor] == 0) { // If the neighbor is not colored
                    colors[neighbor] = -colors[node]; // Color with opposite color
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) { // If the neighbor has the same color
                    return false; // Not bipartite
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int n = scanner.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        a18_is_graph_a_bipartite_graph solution = new a18_is_graph_a_bipartite_graph();
        boolean result = solution.isBipartite(graph);
        System.out.println("The graph is " + (result ? "bipartite" : "not bipartite"));

        scanner.close();
    }
}
