import java.util.*;

public class a4_dfs {
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    public a4_dfs(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void AddEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost); // because it's an undirected graph
    }

    public void Addvertex(int v) {
        map.put(v, new HashMap<>());
    }

    public boolean ContainsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2);
    }

    public boolean Containsvertex(int v1) {
        return map.containsKey(v1);
    }

    public int noofEdge() {
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key).size();
        }
        return sum;
    }

    public void removeEdge(int v1, int v2) {
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removevertex(int v1) {
        for (int nbrs : map.get(v1).keySet()) {
            map.get(nbrs).remove(v1);
        } // doing this to remove edges in case of bidirectional graph
        map.remove(v1);
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
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    s.push(nbrs);
                    visited.add(nbrs); // mark the neighbor as visited
                }
            }
        }
    }
    public static void main(String[] args) {
        a4_dfs g = new a4_dfs(5);
        g.AddEdge(1, 4, 0);
        g.AddEdge(1, 5, 0);
        g.AddEdge(2, 3, 0);
        g.AddEdge(2, 5, 0);
        g.AddEdge(3, 2, 0);
        g.AddEdge(4, 1, 0);
        g.AddEdge(4, 5, 0);
        g.AddEdge(5, 1, 0);
        g.AddEdge(5, 2, 0);
        g.AddEdge(5, 4, 0);
        g.display();
        g.DFS(1);
    }
}
