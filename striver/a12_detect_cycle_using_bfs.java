package striver;

import java.util.*;

public class a12_detect_cycle_using_bfs {

    public static HashMap<Integer, HashMap<Integer, Integer>> map;

    public a12_detect_cycle_using_bfs(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    // Method to add an edge
    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);  // Directed edge
        map.get(v2).put(v1, cost);  // Undirected edge
    }

    // Method to display the graph
    public void display() {
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    // Method to detect cycles using BFS
    public boolean isCyclic() {
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

        for (int node : map.keySet()) {
            if (!visited.contains(node)) {
                if (bfs(node, visited, parent))
                    return true;
            }
        }
        return false;
    }

    // Helper method for BFS traversal
    public boolean bfs(int start, HashSet<Integer> visited, HashMap<Integer, Integer> parent) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        parent.put(start, -1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : map.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parent.put(neighbor, current);
                } else if (neighbor != parent.get(current)) {
                    // Found a back edge, cycle detected
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        a12_detect_cycle_using_bfs graph = new a12_detect_cycle_using_bfs(4);
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
