package striver;

import java.util.*;

public class a20_detect_cycle_in_directed_graph_dfs {
    public boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] pathVisited, List<List<Integer>> adj) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, visited, pathVisited, adj)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int E = scanner.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v) where u -> v:");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
        }

        a20_detect_cycle_in_directed_graph_dfs solution = new a20_detect_cycle_in_directed_graph_dfs();
        boolean hasCycle = solution.isCyclic(V, adj);
        System.out.println("The graph has a cycle: " + hasCycle);

        scanner.close();
    }
}
