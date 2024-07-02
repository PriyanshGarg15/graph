import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        ArrayList<Integer> ans = bfsOfGraph(5, adj);
        System.out.println(ans);
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

            // If visited, then just poll and don't do anything
            if (visited[node]) {
                continue;
            }

            al.add(node);

            for (int ele : adj.get(node)) {
                if (!visited[ele]) {
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
        return al;
    }
}
