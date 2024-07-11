//tc o(v+e)
package striver;
import java.util.*;

public class a23_topological_sort_bfs_known_as_khans_algo {
    private List<List<Integer>> adjList;
    private int vertices;

    public a23_topological_sort_bfs_known_as_khans_algo(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public List<Integer> topologicalSort() {
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adjList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if there was a cycle in the graph
        if (topoOrder.size() != vertices) {
            throw new RuntimeException("Graph has a cycle, topological sort not possible.");
        }

        return topoOrder;
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices
        a23_topological_sort_bfs_known_as_khans_algo graph = new a23_topological_sort_bfs_known_as_khans_algo(vertices);

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
        List<Integer> topologicalOrder = graph.topologicalSort();
        System.out.println("Topological Sort Order: " + topologicalOrder);
    }
}
