package striver;
import java.util.*;

public class a8_number_of_provience_leetcode_547_mainly_bfs_all_and_bfs_call_or_we_can_do_dfs_all_or_dfs {
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public a8_number_of_provience_leetcode_547_mainly_bfs_all_and_bfs_call_or_we_can_do_dfs_all_or_dfs(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost); // because it's an undirected graph
    }

    public void display() {
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    public void bfsAll() {
        boolean[] visited = new boolean[map.size() + 1]; // Adjust size to handle 1-based indexing
        int ans = 0;
        for (int i = 1; i <= map.size(); i++) { // Iterate from 1 to map.size()
            if (!visited[i]) {
                bfs(i, visited);
                ans++;
            }
        }
        System.out.println("Number of provinces: " + ans);
    }

    public void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nbr : map.get(node).keySet()) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        a8_number_of_provience_leetcode_547_mainly_bfs_all_and_bfs_call_or_we_can_do_dfs_all_or_dfs g = new a8_number_of_provience_leetcode_547_mainly_bfs_all_and_bfs_call_or_we_can_do_dfs_all_or_dfs(5);
        g.addEdge(1, 2, 0);
        g.addEdge(1, 3, 0);
        g.addEdge(3, 5, 0);
        g.addEdge(5, 4, 0);
        g.addEdge(4, 2, 0);
        g.display();
        System.out.println("BFS starting from vertex 1:");
        g.bfsAll();
    }
}
