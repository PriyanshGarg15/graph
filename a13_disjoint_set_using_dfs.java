import java.util.*;
public class a13_disjoint_set_using_dfs {
    
    private int[] parent;
    private boolean[] visited;

    public a13_disjoint_set_using_dfs(int n) {
        parent = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            visited[i] = false;
        }
    }

    private void dfs(int v, List<List<Integer>> adj) {
        visited[v] = true;
        for (int u : adj.get(v)) {
            if (!visited[u]) {
                parent[u] = parent[v]; // Union operation
                dfs(u, adj);
            }
        }
    }

    public void findConnectedComponents(List<List<Integer>> adj) {
        int n = adj.size();
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(v, adj);
            }
        }
    }

    public int find(int v) {
        return parent[v];
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes
        a13_disjoint_set_using_dfs ds = new a13_disjoint_set_using_dfs(n);

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

        // HashSet<Integer> hp=new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     hp.add(ds.find(i));
        // }
        // System.out.println(hp.size());
    }
}



// The code you provided is an implementation of the disjoint-set union (DSU) or union-find data structure using depth-first search (DFS)
// While this approach works, it may not be optimal for dynamic connectivity queries (checking whether two nodes are in the same component).
// Traditional DSU implementations with path compression and union by rank offer better performance for such queries.