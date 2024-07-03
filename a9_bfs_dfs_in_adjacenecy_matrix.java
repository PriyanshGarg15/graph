import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a9_bfs_dfs_in_adjacenecy_matrix {
    
    // Helper method for DFS
    private void printDFSUtil(int[][] adj_mat, boolean[] visited, int vertex) {
        System.out.println(vertex);
        visited[vertex] = true;
        for (int i = 0; i < adj_mat.length; i++) {
            if (adj_mat[vertex][i] == 1 && !visited[i]) {
                printDFSUtil(adj_mat, visited, i);
            }
        }
    }

    public void printDFS(int[][] adj_mat) {
        int v = adj_mat.length;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                printDFSUtil(adj_mat, visited, i);
            }
        }
    }

    public void printBFS(int[][] adj_mat) {
        int v = adj_mat.length;
        boolean[] visited = new boolean[v];
        for (int p = 0; p < v; p++) {
            if (!visited[p]) {
                Queue<Integer> queue = new LinkedList<>();
                visited[p] = true;
                queue.add(p);
                while (!queue.isEmpty()) {
                    int polled = queue.poll();
                    System.out.println(polled);
                    for (int i = 0; i < v; i++) {
                        if (adj_mat[polled][i] == 1 && !visited[i]) {
                            queue.add(i);
                            visited[i] = true;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int v = sc.nextInt();
        System.out.println("Enter number of edges");
        int e = sc.nextInt();
        int[][] adj_mat = new int[v][v];
        System.out.println("Enter the edges (format: start_vertex end_vertex):");
        for (int i = 0; i < e; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            adj_mat[sv][ev] = 1;
            adj_mat[ev][sv] = 1;
        }

        a9_bfs_dfs_in_adjacenecy_matrix graph = new a9_bfs_dfs_in_adjacenecy_matrix();
        System.out.println("========== Printing DFS ==========");
        graph.printDFS(adj_mat);

        System.out.println("========== Printing BFS ==========");
        graph.printBFS(adj_mat);
        
        sc.close();
    }
}
