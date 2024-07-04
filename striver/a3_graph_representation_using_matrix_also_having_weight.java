package striver;

public class a3_graph_representation_using_matrix_also_having_weight {
    private int[][] adjacencyMatrix;

    // Constructor to initialize the graph
    public a3_graph_representation_using_matrix_also_having_weight(int numVertices) {
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int destination,int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight; // For undirected graph
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
        a3_graph_representation_using_matrix_also_having_weight graph = new a3_graph_representation_using_matrix_also_having_weight(5);

        graph.addEdge(0, 1,10);
        graph.addEdge(0, 2,20);
        graph.addEdge(1, 2,30);
        graph.addEdge(1, 3,40);
        graph.addEdge(2, 4,50);

        graph.printAdjacencyMatrix();
    }
}
