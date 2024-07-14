package striver;

import java.util.*;

public class a27_finding_safe_nodes_using_topological_sort {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ll = new ArrayList<>();
        int[] outDegree = new int[n];
        
        // Initialize ll with empty lists
        for (int i = 0; i < n; i++) {
            ll.add(new ArrayList<>());
        }
        
        // Create the reverse graph and count the out degrees
        for (int[] edge : graph) {
            ll.get(edge[1]).add(edge[0]);
            outDegree[edge[0]]++;
        }
        
        // Queue to perform topological sort
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all terminal nodes (nodes with out-degree 0) to the queue
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // List to store eventual safe nodes
        List<Integer> safeNodes = new ArrayList<>();
        
        // Perform topological sort
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : ll.get(node)) {
                outDegree[neighbor]--;
                if (outDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Sort the safe nodes as per the problem requirement
        Collections.sort(safeNodes);
        return safeNodes;
    }
    
    public static void main(String[] args) {
        a27_finding_safe_nodes_using_topological_sort solution = new a27_finding_safe_nodes_using_topological_sort();
        int[][] graph = {
            {1,2}, {2,3}, {5}, {0}, {5}, {}, {}
        };
        
        List<Integer> safeNodes = solution.eventualSafeNodes(graph);
        System.out.println(safeNodes); // Output: [2, 4, 5, 6]
    }
}
