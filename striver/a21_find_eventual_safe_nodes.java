package striver;

import java.util.*;

public class a21_find_eventual_safe_nodes {
    
    public boolean dfs(int node, List<List<Integer>> adj, int[] visited, int[] pathVis) {
        visited[node] = 1;
        pathVis[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (dfs(neighbor, adj, visited, pathVis)) {
                    return true;
                }
            } else if (pathVis[neighbor] == 1) {
                return true; // Cycle detected
            }
        }

        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVis = new int[V];
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, adj, visited, pathVis);
            }
        }

        for (int i = 0; i < V; i++) {
            if (pathVis[i] == 0) {
                safeNodes.add(i);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
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

        a21_find_eventual_safe_nodes solution = new a21_find_eventual_safe_nodes();
        List<Integer> safeNodes = solution.eventualSafeNodes(V, adj);
        System.out.println("The safe nodes are: " + safeNodes);

        scanner.close();
    }
}
