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
    public static boolean canFinish(int numCourses, int[][] prerequisites, HashMap adj) {
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses + 1];
        onStack[numCourses] = true;
        int vertex = 0;

        return dfsCycle(numCourses, prerequisites, adj, marked, onStack, vertex);
    }

    public static boolean dfsCycle(int numCourses, int[][] prereqs, HashMap adj, boolean[] marked, boolean[] onStack, int vertex){

        marked[vertex] = true;
        onStack[vertex] = true;

        for(int w : (LinkedList<Integer>)adj.get(vertex)){
            if(!marked[w]){
                 dfsCycle(numCourses, prereqs, adj, marked, onStack, w);
            } else if (onStack[w]) onStack[numCourses] = false;
        }
        // for(int i = vertex; i < numCourses; i++){
        //     for (int w : (LinkedList<Integer>) adj.get(i)) {
        //         if (!marked[w]) {
        //             dfsCycle(numCourses, prereqs, adj, marked, onStack, w);
        //         } else if (onStack[w])
        //             onStack[numCourses] = false;
        //     }
        // }

        onStack[vertex] = false;

        return onStack[numCourses];
    }

    public static void buildGraph(int numCourses, int[][] prereqs, HashMap adj){
        for(int i = 0; i < numCourses; i++){
            adj.put(i, new LinkedList<Integer>());
        }
        for (int[] arr : prereqs) {
            int key = arr[0];
            ((LinkedList<Integer>) adj.get(key)).add(arr[1]);
        }
    }

    public static void main(String[] args){
        int numCourses = 5;
        int [][] prereqs = {{0,1},{0,2},{1,3},{1,4},{3,4}};
        // int numCourses = 20;
        // int [][] prereqs = { { 0, 10 }, { 3, 18 }, { 5, 5 }, { 6, 11 }, { 11, 14 }, { 13, 1 }, { 15, 1 }, { 17, 4 } };

        HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
        buildGraph(numCourses, prereqs, adj);
        adj.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
        System.out.println("No Cycles? " + canFinish(numCourses, prereqs, adj) );
    }
}