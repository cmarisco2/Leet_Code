import java.util.HashMap;
import java.util.LinkedList;

//? Leetcode Problem 207: Course Schedule 
//? Difficulty: 'Medium'
//? Description: 
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

//? Examples: 
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

class CourseSchedule_207{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] marked = new boolean[numCourses];
        return true;
    }

    public static boolean dfsCycle(int numCourses, int[][] prereqs, HashMap adj, boolean[] marked, boolean[] onStack){
        return true;
    }

    public static void buildGraph(int numCourses, int[][] prereqs, HashMap adj){
        for (int[] arr : prereqs) {
            int key = arr[0];
            if(!adj.containsKey(key)) adj.put(key, new LinkedList<Integer>());
            ((LinkedList<Integer>) adj.get(key)).add(arr[1]);
        }
    }

    public static void main(String[] args){
        int numCourses = 5;
        int [][] prereqs = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } };
        HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
        buildGraph(numCourses, prereqs, adj);
        adj.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}