package striver;

import java.util.*;

public class a26_course_scheduler_second_leetcode_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Fill the adjacency list and inDegree array
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        // Initialize the queue with all vertices having in-degree of 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // List to store the topological order
        int[] order = new int[numCourses];
        int index = 0;
        
        // Process vertices in topological order
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if there was a cycle
        if (index != numCourses) {
            return new int[0]; // return empty array if there's a cycle
        }

        return order;
    }

    public static void main(String[] args) {
        a26_course_scheduler_second_leetcode_210 sol = new a26_course_scheduler_second_leetcode_210();

        // Example 1
        int numCourses1 = 4;
        int[][] prerequisites1 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Course order: " + Arrays.toString(sol.findOrder(numCourses1, prerequisites1)));

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Course order: " + Arrays.toString(sol.findOrder(numCourses2, prerequisites2)));
    }
}
