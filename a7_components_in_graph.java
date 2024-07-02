import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a7_components_in_graph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(3).add(4);
        int ans = countComponents(5, adj);
        System.out.println(ans);
    }

    public static int countComponents(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int ele : adj.get(node)) {
                        if (!visited[ele]) {
                            visited[ele] = true;
                            q.add(ele);
                        }
                    }
                }
            }
        }
        return count;
    }
}