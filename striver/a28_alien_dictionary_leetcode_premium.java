package striver;

import java.util.*;

public class a28_alien_dictionary_leetcode_premium {
    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        
        // Calculate in-degrees
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Queue for nodes with zero in-degree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        // Perform topological sorting
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            // Reduce the in-degree of adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }
    
    public String findOrder(String[] dict, int N, int K) {
        // Initialize adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph from dictionary words
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break; // Stop comparing characters after first difference
                }
            }
        }

        // Perform topological sort
        List<Integer> topo = topoSort(K, adj);
        
        // Convert topo sorted integers back to characters
        StringBuilder sb = new StringBuilder();
        for (int it : topo) {
            sb.append((char) (it + 'a'));
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        a28_alien_dictionary_leetcode_premium obj = new a28_alien_dictionary_leetcode_premium();
        String ans = obj.findOrder(dict, N, K);

        System.out.println(ans); // Output: "bdac"
    }
}
