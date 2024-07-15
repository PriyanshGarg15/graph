package striver;

import java.util.*;

public class a30__shortest_path_in_undirected_graph {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize the adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]); // Since the graph is undirected
        }

        // Initialize distance array with a large value (infinity)
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance to the source is 0
        dist[src] = 0;

        // BFS queue
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        // BFS traversal
        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        a30__shortest_path_in_undirected_graph sol = new a30__shortest_path_in_undirected_graph();
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}};
        int n = 4;
        int m = 4;
        int src = 0;
        // n is the number of vertices (or nodes) in the graph.
        // m is the number of edges in the graph.
        int[] result = sol.shortestPath(edges, n, m, src);
        
        System.out.println("Shortest distances from node " + src + ": " + Arrays.toString(result));
    }
}
