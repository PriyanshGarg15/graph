package striver;

public class a1_graph_representation_using_matrix {
    private int[][] adjacencyMatrix;

    // Constructor to initialize the graph
    public a1_graph_representation_using_matrix(int numVertices) {
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // For undirected graph
    }

    // Method to print the adjacency matrix
    public void printAdjacencyMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        a1_graph_representation_using_matrix graph = new a1_graph_representation_using_matrix(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        graph.printAdjacencyMatrix();
    }
}
