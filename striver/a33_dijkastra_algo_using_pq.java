package striver;

import java.util.*;

public class a33_dijkastra_algo_using_pq {

    // Class to represent a graph edge
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Class to represent a node in the priority queue
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Method to perform Dijkstra's algorithm
    public static int[] dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size(); // Number of vertices
        int[] dist = new int[V]; // Array to store the shortest distance to each vertex
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                // If a shorter path to v is found
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new Edge(1, 9));
        graph.get(0).add(new Edge(2, 6));
        graph.get(0).add(new Edge(3, 5));
        graph.get(0).add(new Edge(4, 3));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 4));


        for (int i = 0; i < graph.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (Edge edge : graph.get(i)) {
                System.out.print(" -> (target: " + edge.target + ", weight: " + edge.weight + ")");
            }
            System.out.println();
        }

        int source = 0; // Source vertex
        int[] distances = dijkstra(graph, source);

        System.out.println("Shortest distances from source vertex " + source + " to all other vertices:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " : " + distances[i]);
        }
    }
}
