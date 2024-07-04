import java.util.*;

public class a15_disjoint_set_union {
    private int[] parent;
    private int[] rank;

    public a15_disjoint_set_union(int size) {
        parent = new int[size];
        rank = new int[size];
        // Initialize each element as its own root and rank as 0
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find operation with path compression
    public int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]); // Path compression
        }
        return parent[v];
    }

    // Union operation by rank
    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);

        if (root1 != root2) {
            // Union by rank
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    public static void main(String[] args) {
        int size = 6; // Number of elements
        a15_disjoint_set_union ds = new a15_disjoint_set_union(size);

        // Example usage: union elements
        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);

        // Example usage: find operations
        System.out.println("Find root of 1: " + ds.find(1)); // Should print the same root as ds.find(3)
        System.out.println("Find root of 3: " + ds.find(3)); // Should print the same root as ds.find(5)
    }
}
