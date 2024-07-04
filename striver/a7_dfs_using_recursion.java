package striver;

import java.util.*;

public class a7_dfs_using_recursion {
    private Map<Integer, List<Integer>> adjList;
    private boolean[] visited;

    public a7_dfs_using_recursion(int vertices) {
        adjList = new HashMap<>();
        visited = new boolean[vertices + 1]; // +1 to accommodate vertex 5
        for (int i = 1; i <= vertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // Because it's an undirected graph
    }

    // DFS method using recursion
    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices in the graph
        a7_dfs_using_recursion graph = new a7_dfs_using_recursion(vertices);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(4, 2);

        // Perform DFS starting from vertex 1
        System.out.println("Depth First Search starting from vertex :");
        graph.dfs(3);
    }
}
