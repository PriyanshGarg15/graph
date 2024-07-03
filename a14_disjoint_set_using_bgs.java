import java.util.*;

public class a14_disjoint_set_using_bgs {
    private int[] parent;
    private boolean[] visited;

    public a14_disjoint_set_using_bgs(int n) {
        parent = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            // visited[i] = false;
        }
    }

    private void bfs(int v, List<List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int u : adj.get(node)) {
                if (!visited[u]) {
                    parent[u] = parent[v]; // Union operation
                    visited[u] = true;
                    queue.add(u);
                }
            }
        }
    }

    public void findConnectedComponents(List<List<Integer>> adj) {
        int n = adj.size();
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                bfs(v, adj);
            }
        }
    }

    public int find(int v) {
        return parent[v];
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        a14_disjoint_set_using_bgs ds = new a14_disjoint_set_using_bgs(n);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (undirected graph)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);

        ds.findConnectedComponents(adj);

        for (int i = 0; i < n; i++) {
            System.out.println("Node " + i + " is in component " + ds.find(i));
        }
    }
}
