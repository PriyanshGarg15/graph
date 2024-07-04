package striver;
import java.util.*;

public class a2_graph_represenatation_using_adjacency_list {
    private List<List<Integer>> adjList;

    public a2_graph_represenatation_using_adjacency_list(int vertices) 
    {
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Since the graph is undirected
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        a2_graph_represenatation_using_adjacency_list graph = new a2_graph_represenatation_using_adjacency_list(vertices);

        // Add edges (undirected graph)
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print adjacency list
        for (int i = 0; i < vertices; i++) {
            System.out.print("Adjacency list of vertex " + i + ": ");
            for (int neighbor : graph.adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

