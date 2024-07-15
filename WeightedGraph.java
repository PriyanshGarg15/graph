import java.util.*;

public class WeightedGraph {

    public static List<List<Pair>> adjList;

    public WeightedGraph(int vertices) {
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Pair(dest, weight));
        adjList.get(dest).add(new Pair(src, weight)); // For undirected graph
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Node " + i + " is connected to: ");
            for (Pair pair : adjList.get(i)) {
                System.out.print("(" + pair.node + ", " + pair.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        WeightedGraph a = new WeightedGraph(vertices);

        // Add edges
        a.addEdge(0, 1, 2);
        a.addEdge(0, 3, 6);
        a.addEdge(1, 2, 3);
        a.addEdge(1, 3, 8);
        a.addEdge(1, 4, 5);
        a.addEdge(2, 4, 7);
        a.addEdge(3, 4, 9);

        // Print adjacency list
        a.printGraph();
    }
}
