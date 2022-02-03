//? Problem 70: Climbing Stairs
// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//? Constraints:
// 1 <= n <= 45

//? Examples:
// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step

class ClimbingStairs_70{
    public static int climbStairs(int n) {
        int[] cache = new int[n + 1];
        cache[n] = 1;
        cache[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            cache[i] = cache[i + 1] + cache[i + 2];
        }
        return cache[0];
    }
    public static void main(String[] args){
        int stairs = 5;
        System.out.println("The Number of Ways to clime " + stairs + " stairs is: " + climbStairs(stairs));
    }
}
