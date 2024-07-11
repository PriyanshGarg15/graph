//tc o(v+e)
package striver;
import java.util.*;

public class a22_topological_sort_dfs {
    private List<List<Integer>> adjList;

    public a22_topological_sort_dfs(int vertices) {
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices
        a22_topological_sort_dfs graph = new a22_topological_sort_dfs(vertices);

        // Add edges (directed graph)
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);

        // Print adjacency list
        for (int i = 0; i < vertices; i++) {
            System.out.print("Adjacency list of vertex " + i + ": ");
            for (int neighbor : graph.adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        // Perform topological sort
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[vertices];
        
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                graph.topological_sort(i, visited, st);
            }
        }

        // Print topologically sorted order
        System.out.println("Topological Sort:");
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public void topological_sort(int v, boolean[] visited, Stack<Integer> st) {
        visited[v] = true;
        for (int neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                topological_sort(neighbor, visited, st);
            }
        }
        st.push(v);
    }
}
