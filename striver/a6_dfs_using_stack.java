package striver;

import java.util.*;
public class a6_dfs_using_stack {
    private HashMap<Integer, HashMap<Integer, Integer>> map;
    public a6_dfs_using_stack(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost); // because it's an undirected graph
    }


    public void display() {
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }

    public void DFS(int src) {
        Stack<Integer> s = new Stack<>();
        s.push(src);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(src); 
        while (!s.isEmpty()) {
            int rv = s.pop();
            System.out.println(rv);
            List<Integer> neighbors = new ArrayList<>(map.get(rv).keySet());
            Collections.sort(neighbors, Collections.reverseOrder()); // Sort neighbors in reverse order
            for (int nbrs : neighbors) {
                if (!visited.contains(nbrs)) {
                    s.push(nbrs);
                    visited.add(nbrs); // mark the neighbor as visited
                }
            }
        }
    }

    public static void main(String[] args) {
        a6_dfs_using_stack g = new a6_dfs_using_stack(5);
        g.AddEdge(1, 2, 0);
        g.AddEdge(1, 3, 0);
        g.AddEdge(3, 5, 0);
        g.AddEdge(5, 4, 0);
        g.AddEdge(4, 2, 0);
        g.display();
        System.out.println("DFS starting from vertex 1:");
        g.DFS(1);
    }
}
