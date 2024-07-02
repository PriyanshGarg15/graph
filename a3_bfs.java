import java.util.*;
public class a3_bfs 
{
	private HashMap<Integer, HashMap<Integer, Integer>> map;
	public a3_bfs(int v) 
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
		} //doing this to remove edges in case of bidireectional grpah
		map.remove(v1);
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
        a3_bfs g = new a3_bfs(7);
        g.AddEdge(1, 4, 6);
		g.AddEdge(1, 2, 10);
		g.AddEdge(2, 3, 7);
		g.AddEdge(3, 4, 5);
		g.AddEdge(4, 5, 1);
		g.AddEdge(5, 6, 4);
		g.AddEdge(7, 5, 2);
		g.AddEdge(6, 7, 3);
		g.display();
        g.BFS(1);
    }
	
}






	
	