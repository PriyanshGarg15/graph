package striver;

import java.util.*;

public class a13_detect_cycle_using_dfs {

    private static HashMap<Integer, HashMap<Integer, Integer>> map;

    public a13_detect_cycle_using_dfs(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    // Method to add an edge
    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);  // Add edge from v1 to v2
        map.get(v2).put(v1, cost);  // Add edge from v2 to v1 (undirected)
    }

    // Method to display the graph
    public void display() {
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    // Method to detect cycles in an undirected graph using DFS
    public boolean isCyclic() {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        for (int node : map.keySet()) {
            if (!visited.contains(node)) {
                if (dfs(node, visited, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper method for DFS traversal
    private boolean dfs(int node, HashSet<Integer> visited, HashMap<Integer, Integer> parent) {
        visited.add(node);

        for (int neighbor : map.get(node).keySet()) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, node);
                if (dfs(neighbor, visited, parent)) {
                    return true;
                }
            } else if (!parent.get(node).equals(neighbor)) {
                // Found a back edge, cycle detected
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        a13_detect_cycle_using_dfs graph = new a13_detect_cycle_using_dfs(4);
        graph.AddEdge(1, 2, 1);
        graph.AddEdge(2, 3, 1);
        graph.AddEdge(3, 1, 1);
        graph.AddEdge(3, 4, 1);

        graph.display();

        if (graph.isCyclic())
            System.out.println("Graph contains a cycle");
        else
            System.out.println("Graph does not contain a cycle");
    }
}
