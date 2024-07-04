package striver;

import java.util.*;

public class a4_graph_representation_using_list_also_having_weight {
    private List<List<Pair<Integer, Integer>>> adjList; // Pair: (neighbor, weight)
    public a4_graph_representation_using_list_also_having_weight(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Pair<>(v, weight));
        adjList.get(v).add(new Pair<>(u, weight)); // Since the graph is undirected
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        a4_graph_representation_using_list_also_having_weight graph = new a4_graph_representation_using_list_also_having_weight(vertices);

        // Add weighted edges (undirected graph)
        graph.addEdge(0, 1, 3);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 4);

        // Print adjacency list with weights
        for (int i = 0; i < vertices; i++) {
            System.out.print("Adjacency list of vertex " + i + ": ");
            for (Pair<Integer, Integer> neighbor : graph.adjList.get(i)) {
                System.out.print("(" + neighbor.first + ", " + neighbor.second + ") ");
            }
            System.out.println();
        }
    }

    public class Pair<T, U> {
        T first;
        U second;
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
