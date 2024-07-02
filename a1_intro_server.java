//hasmap helps to stor ekey value pairs !!

import java.util.*;
public class a1_intro_server {
	static HashMap<Integer, HashMap<Integer, Integer>> map;
    
	public a1_intro_server(int v) 
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



	// (using haspath) is designed to find a path through potentially many intermediate vertices, not just direct connections.(USes dfs becz we keep going to neifgbot then to its neigbor so on...)


	public boolean haspath(int src, int des, HashSet<Integer> visited) {
		if (src == des) {
			return true;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				boolean ans = haspath(nbrs, des, visited);
				if (ans) {
					return ans;
				}
			}
		}
		return false;

	}

	public void PrintAllPath(int src, int des, HashSet<Integer> visited, String ans) {
		if (src == des) {
			System.out.println(ans + des);
			return;
		}
		visited.add(src);
		for (int nbrs : map.get(src).keySet()) {
			if (!visited.contains(nbrs)) {
				PrintAllPath(nbrs, des, visited, ans + src);

			}
		}
		visited.remove(src);

	}


	public boolean BFS(int src,int des) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		HashSet<Integer> visited = new HashSet<>();
		while (!q.isEmpty()) {
			// 1. remove
			int rv = q.poll();

			// 2. Ignore if Already Visited
			if (visited.contains(rv)) {
				continue;
			}
			
			// 3. add visited
			visited.add(rv);

			// 4.self Work
			if (rv == des) {
				return true;
			}

			// 5. Add unvisited nbrs
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs)) {
					q.add(nbrs);
				}
			}
		}
		return false;
	}


	
	public boolean DFS(int src, int des) {
		Stack<Integer> s = new Stack<>();
		s.push(src);
		HashSet<Integer> visited = new HashSet<>();
		while (!s.isEmpty()) {
			// 1. remove
			int rv = s.pop();

			// 2. Ignore if Already Visited
			if (visited.contains(rv)) {
				continue;
			}

			// 3. add visited
			visited.add(rv);

			// 4.self Work
			if (rv == des) {
				return true;
			}

			// 5. Add unvisited nbrs
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs)) {
					s.push(nbrs);
				}
			}
		}
		return false;
	}
}