package striver;

import java.util.*;

public class a40_shortest_path_in_weighted_graph {

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

    // Method to perform Dijkstra's algorithm and find the shortest path
    public static List<Integer> dijkstra(int V, List<List<Edge>> adj, int source, int destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Add the source node with distance 0
        pq.add(new Node(source, 0));
        dist[source] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int u = currentNode.vertex;
            int dis = currentNode.distance;

            for (Edge edge : adj.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (dis + weight < dist[v]) {
                    dist[v] = dis + weight;
                    pq.add(new Node(v, dist[v]));
                    parent[v] = u;
                }
            }
        }

        // Check if the destination is unreachable
        if (dist[destination] == Integer.MAX_VALUE) {
            return Collections.singletonList(-1);
        }

        // Reconstruct the path from destination to source
        List<Integer> path = new ArrayList<>();
        int at = destination;
        while (at != -1) {
            path.add(at);
            at = parent[at];
        }
        
        Collections.reverse(path);
        return path;
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
        int destination = V - 1; // Destination vertex (last vertex)
        List<Integer> path = dijkstra(V, graph, source, destination);

        System.out.println("Shortest path from source vertex " + source + " to destination vertex " + destination + ":");
        if (path.get(0) == -1) {
            System.out.println("No path exists.");
        } else {
            for (int vertex : path) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
}
