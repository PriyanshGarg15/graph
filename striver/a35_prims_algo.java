package striver;

import java.util.*;

class Edge {
    int targetNode;
    int distanceFromNode;
    // forming edge
    Edge(int targetNode, int distanceFromNode) {
        this.targetNode = targetNode;
        this.distanceFromNode = distanceFromNode;
    }
}

class Graph {
    List<List<Edge>> graph;
    boolean[] visited;
    int nodes;

    Graph(int nodes) {
        graph = new ArrayList<>();
        visited = new boolean[nodes];
        this.nodes = nodes;
        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int sourceNode, int targetNode, int distance) {
        graph.get(sourceNode).add(new Edge(targetNode, distance));
        graph.get(targetNode).add(new Edge(sourceNode, distance));
    }

    public int mst() {
        int minCost = 0;
        //doing for non connected graphs
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                minCost += minimumSpanningTreeUnweightedGraph(i);
            }
        }
        return minCost;
    }

    public int minimumSpanningTreeUnweightedGraph(int source) {
        PriorityQueue<Edge> minEdgeHeap = new PriorityQueue<>((e1, e2) -> e1.distanceFromNode - e2.distanceFromNode);
        visited[source] = true;
        List<Edge> childOfSource = graph.get(source);
        for (Edge edge : childOfSource) {
            minEdgeHeap.add(edge);
        }
        int minimumCost = 0;
        while (!minEdgeHeap.isEmpty()) {
            Edge minValueEdge = minEdgeHeap.poll();
            if (visited[minValueEdge.targetNode]) {
                continue;
            }

            visited[minValueEdge.targetNode] = true;
            minimumCost += minValueEdge.distanceFromNode;
            List<Edge> childList = graph.get(minValueEdge.targetNode); // Correct source node
            for (Edge edge : childList) {
                if (!visited[edge.targetNode]) {
                    minEdgeHeap.add(edge);
                }
            }
        }
        return minimumCost;
    }
}

public class a35_prims_algo {
    public static void main(String[] args) {
        int nodes = 5;
        Graph a = new Graph(nodes);
        a.addEdge(0, 1, 6);
        a.addEdge(0, 3, 4);
        a.addEdge(1, 2, 10);
        a.addEdge(1, 3, 7);
        a.addEdge(1, 4, 7);
        a.addEdge(2, 3, 8);
        a.addEdge(2, 4, 5);
        a.addEdge(3, 4, 12);
        System.out.println(a.mst());
    }
}
