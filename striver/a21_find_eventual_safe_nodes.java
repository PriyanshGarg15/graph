package striver;

import java.util.*;

public class a21_find_eventual_safe_nodes {
    
    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == false) {
                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[neighbor] == true) {
                return true; // Cycle detected
            }
        }

        pathVisited[node] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                dfs(i, adj, visited, pathVisited);
            }
        }

        for (int i = 0; i < V; i++) {
            if (pathVisited[i] == false) {
                safeNodes.add(i);
            }
        }
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
