package striver;

import java.util.*;
public class a5_bfs_traversal_from_source 
{
	private static HashMap<Integer, HashMap<Integer, Integer>> map;
	public a5_bfs_traversal_from_source(int v) 
    {
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) 
        {
			map.put(i, new HashMap<>());
		}

	}

	public void AddEdge(int v1, int v2, int cost) 
    {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost); //becz its unidirectional graph

	}

	public void display() {
		for (int key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}
	}
    
    public void BFS(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        HashSet<Integer> visited = new HashSet<>();
		visited.add(src);
        while (!q.isEmpty()) {
            int rv = q.poll();
			System.out.println(rv);
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    q.add(nbrs);
					visited.add(nbrs);
                }
            }
        }
    }

    public static void main(String[] args) {
        a5_bfs_traversal_from_source g = new a5_bfs_traversal_from_source(7);
        g.AddEdge(1, 4, 6);
		g.AddEdge(1, 2, 10);
		g.AddEdge(2, 3, 7);
		g.AddEdge(3, 4, 5);
		g.AddEdge(4, 5, 1);
		g.AddEdge(5, 6, 4);
		g.AddEdge(7, 5, 2);
		g.AddEdge(6, 7, 3);
        //see image a1 for graph see
		g.display();
        g.BFS(1);
    }
	
}






	
	