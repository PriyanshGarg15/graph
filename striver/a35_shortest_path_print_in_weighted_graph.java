package striver;

import java.util.*;

public class a35_shortest_path_print_in_weighted_graph 
{
    public class Pair implements Comparable<Pair> {
        int distance;
        int vertex;
    
        public Pair(int distance, int vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }
    
        @Override
        public int compareTo(Pair other) {
            if (this.distance != other.distance) {
                return Integer.compare(this.distance, other.distance);
            }
            return Integer.compare(this.vertex, other.vertex);
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {  //m (the number of edges) is equivalent to edges.length //n is number of vertices
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>()); 
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2])); 
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2])); 
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int[] dist = new int[n + 1]; 
        int[] parent = new int[n + 1]; 
        Arrays.fill(dist, (int) (1e9)); 
        for (int i = 1; i <= n; i++) {
            parent[i] = i; 
        }
        
        dist[1] = 0;

     
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair it = pq.poll(); 
            int node = it.vertex;
            int dis = it.distance; 
            for (Pair iter : adj.get(node)) {
                int edW = iter.distance; 
                int adjNode = iter.vertex;
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis + edW, adjNode)); 
                    parent[adjNode] = node; 
                }
            }
        }

        List<Integer> path = new ArrayList<>();  

        // If distance to a node could not be found, return an array containing -1
        // you are checking the distance to vertex n (the destination vertex) to determine if it is reachable from the source vertex.
        if (dist[n] == 1e9) {
            path.add(-1); 
            return path; 
        }
        

        int node = n;
        while (parent[node] != node) {
            path.add(node); 
            node = parent[node]; 
        }
        
        path.add(1); // Add the source node to the path

        Collections.reverse(path); 
        return path;
    }
    public static void main(String[] args) {
        int V = 5, E = 6;

        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};

        a35_shortest_path_print_in_weighted_graph  obj = new a35_shortest_path_print_in_weighted_graph ();
        List<Integer> path = obj.shortestPath(V, E, edges);
        for (int i : path) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
