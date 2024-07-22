package striver;

import java.util.*;

public class a34_dijkastra_using_treeset {

    // Class to represent a graph edge
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Method to perform Dijkstra's algorithm
    public static int[] dijkstra(int V, List<List<Edge>> adj, int S) {
        TreeSet<Node> set = new TreeSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Add the source node with distance 0
        set.add(new Node(0, S));
        dist[S] = 0;

        while (!set.isEmpty()) {
            // Extract the node with the smallest distance
            Node currentNode = set.pollFirst();
            int distance = currentNode.distance;
            int node = currentNode.vertex;

            // Iterate over adjacent nodes
            for (Edge edge : adj.get(node)) {
                int adjNode = edge.target;
                int edgeWeight = edge.weight;

                // If a shorter path is found
                if (distance + edgeWeight < dist[adjNode]) {
                    // Remove existing node from TreeSet before updating
                    if (dist[adjNode] != Integer.MAX_VALUE) {
                        set.remove(new Node(dist[adjNode], adjNode));
                    }
                    // Update the distance
                    dist[adjNode] = distance + edgeWeight;
                    // Add the updated node back to the TreeSet
                    set.add(new Node(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    // Class to represent a node in the TreeSet
    static class Node implements Comparable<Node> {
        int distance;
        int vertex;

        Node(int distance, int vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance == other.distance) {
                return Integer.compare(this.vertex, other.vertex);
            }
            return Integer.compare(this.distance, other.distance);
        }

        @Override
        public int hashCode() {
            return Objects.hash(distance, vertex);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return distance == node.distance && vertex == node.vertex;
        }
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

        int source = 0; // Source vertex
        int[] distances = dijkstra(V, graph, source);

        System.out.println("Shortest distances from source vertex " + source + " to all other vertices:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Vertex " + i + " : " + distances[i]);
        }
    }
}
