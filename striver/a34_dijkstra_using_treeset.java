package striver;

import java.util.*;

public class a34_dijkstra_using_treeset {
    static class Pair implements Comparable<Pair> {
        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.dist != other.dist) {
                return Integer.compare(this.dist, other.dist);
            }
            return Integer.compare(this.node, other.node);
        }
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int S) {
        TreeSet<Pair> st = new TreeSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        st.add(new Pair(0, S));
        dist[S] = 0;

        while (!st.isEmpty()) {
            Pair it = st.pollFirst(); 
            int node = it.node;
            int dis = it.dist;

            for (Pair edge : adj.get(node)) {
                int adjNode = edge.node;
                int edgW = edge.dist; // Now dist refers to the weight of the edge
                if (dis + edgW < dist[adjNode]) {
                    dist[adjNode] = dis + edgW;
                    st.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 3, S = 2; // Number of vertices and the source vertex
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges as Pair objects instead of int[]
        adj.get(0).add(new Pair(1, 1)); // edge from 0 to 1 with weight 1
        adj.get(0).add(new Pair(6, 2)); // edge from 0 to 2 with weight 6
        adj.get(1).add(new Pair(3, 2)); // edge from 1 to 2 with weight 3
        adj.get(1).add(new Pair(1, 0)); // edge from 1 to 0 with weight 1
        adj.get(2).add(new Pair(6, 0)); // edge from 2 to 0 with weight 6
        adj.get(2).add(new Pair(3, 1)); // edge from 2 to 1 with weight 3

        a34_dijkstra_using_treeset obj = new a34_dijkstra_using_treeset();
        int[] res = obj.dijkstra(V, adj, S);

        // Print the result
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
