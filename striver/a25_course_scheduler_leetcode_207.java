package striver;

import java.util.*;

public class a25_course_scheduler_leetcode_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        // Process vertices in topological order
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If count matches the number of courses, we can finish all courses
        return count == numCourses;
    }

    public static void main(String[] args) {
        a25_course_scheduler_leetcode_207 sol = new a25_course_scheduler_leetcode_207();

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Can finish all courses: " + sol.canFinish(numCourses1, prerequisites1));

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish all courses: " + sol.canFinish(numCourses2, prerequisites2));
    }
}
