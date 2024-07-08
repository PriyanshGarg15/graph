package striver;

import java.util.Scanner;

public class a19_is_graph_a_bipartite_graph_using_dfs {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: not colored, 1: color 1, -1: color 2

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // if not colored
                if (!dfs(graph, i, 1, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int color, int[] colors) {
        colors[node] = color; // Color the node

        for (int neighbor : graph[node]) {
            if (colors[neighbor] == 0) { // If the neighbor is not colored
                if (!dfs(graph, neighbor, -color, colors)) {
                    return false;
                }
            } else if (colors[neighbor] == colors[node]) { // If the neighbor has the same color
                return false; // Not bipartite
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int n = scanner.nextInt();
        int[][] graph = new int[n][];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter number of neighbors for vertex " + i + ":");
            int numNeighbors = scanner.nextInt();
            graph[i] = new int[numNeighbors];
            System.out.println("Enter the neighbors:");
            for (int j = 0; j < numNeighbors; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        a19_is_graph_a_bipartite_graph_using_dfs solution = new a19_is_graph_a_bipartite_graph_using_dfs();
        boolean result = solution.isBipartite(graph);
        System.out.println("The graph is " + (result ? "bipartite" : "not bipartite"));

        scanner.close();
    }
}
