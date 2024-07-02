import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a8_number_of_good_components {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Convert adjacency list to edges array
        int[][] edges = {{1, 2}, {1, 3}, {4, 5},{3,2}};
        int e = edges.length;
        int v = 5;

        int ans = findNumberOfGoodComponent(e, v, edges);
        System.out.println(ans); // Expected output is 2
    }

    public static int findNumberOfGoodComponent(int e, int v, int[][] edges) {
        // Create the graph using adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        create(edges, v, graph);
        
        int c = 0;
        boolean visited[] = new boolean[graph.size()];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                int p = bfs1(graph, i, visited);
                if (p == 1) {
                    c++;
                }
            }
        }
        return c;
    }

    public static void create(int[][] edges, int v, ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int d = edges[i][1];
            graph.get(s - 1).add(d - 1);
            graph.get(d - 1).add(s - 1);
        }
    }

    public static int bfs1(ArrayList<ArrayList<Integer>> graph, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        // Add source to queue
        q.add(s);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(s);
        visited[s] = true;
        
        // Traverse while queue is not empty
        while (!q.isEmpty()) {
            int curr = q.poll();
            ArrayList<Integer> nbr_list = graph.get(curr);
            for (int nbr : nbr_list) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    list.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
        
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (graph.get(list.get(i)).size() != (n - 1)) {
                return 0;
            }
        }
        return 1;
    }
}
