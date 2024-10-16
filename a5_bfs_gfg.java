import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a5_bfs_gfg {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(2).add(4);
        ArrayList<Integer> ans = bfsOfGraph(5, adj);
        System.out.println(ans);
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while (!q.isEmpty()) {
            int node = q.poll();
            al.add(node);
            visited[node] = true;
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
