package striver;

import java.util.*;

public class a29_shortest_path_in_directed_acyclic_graph {

    public static class Edge {
        int nodee, weight;
        Edge(int nodee, int weight) {
            this.nodee = nodee;
            this.weight = weight;
        }
    }

    // Method to perform topological sort using BFS (Kahn's Algorithm)
    public static List<Integer> topologicalSortBFS(int numVertices, List<List<Edge>> graph) {
        int[] inDegree = new int[numVertices];
        for (List<Edge> edges : graph) {
            for (Edge edge : edges) {
                inDegree[edge.nodee]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (Edge edge : graph.get(node)) {
                inDegree[edge.nodee]--;
                if (inDegree[edge.nodee] == 0) {
                    queue.offer(edge.nodee);
                }
            }
        }

        if (topoOrder.size() != numVertices) {
            throw new IllegalArgumentException("Graph is not a DAG");
        }

        return topoOrder;
    }

    // Method to find the shortest path in a DAG using the topological order
    public static int[] shortestPath(int numVertices, List<List<Edge>> graph, int start) {
        List<Integer> topoOrder = topologicalSortBFS(numVertices, graph);
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        for (int node : topoOrder) {
            if (dist[node] != Integer.MAX_VALUE) {
                for (Edge edge : graph.get(node)) {
                    if (dist[node] + edge.weight < dist[edge.nodee]) {
                        dist[edge.nodee] = dist[node] + edge.weight;
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int numVertices = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(4, 1));
        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(3, 6));
        graph.get(4).add(new Edge(2, 2));
        graph.get(4).add(new Edge(5, 4));
        graph.get(5).add(new Edge(3, 1));

        int start = 0;
        int[] distances = shortestPath(numVertices, graph, start);

        System.out.println("Shortest distances from node " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + ": " + (distances[i] == Integer.MAX_VALUE ? "INF" : distances[i]));
        }
    }
}
