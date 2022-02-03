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

//? Note:
//*       _
//*     _|_|
//*   _|_|_| 
//* _| | | |
//* 0 1 2 3

//* At each level, there's 2 Choices.
//! Visualizing the Decision Tree is Key.
//? Naive Brute Force: Can see F(0) = F(1) + F(2) -> funct(n){ basecase; return func(n+1) + func(n+2)}
//* Starting at step 0.
//*                 0
//*             1       2
//*         2       3 3     4
//*     3       4 ........


//? Solution Notes:
//* BF -> Recursive Approach(DFS, BCs >= 3) TC(Decisions^Steps) == TC - O(2^N)
//? Key -> Repeated Tree Nodes (Overlapping Subproblem)
//* 1) Calc Base Results Once
//* 2) Use Memoization (cache results)

//This Version is Bottom up.
//* cache = [  ,  , 1, 1 ] -> 3 BC == 1 (Default for counting the target), 2 has only 1 way to get to 3.
//* -> cache is pre-loaded with the first results.
//* -> each result subsequently is looked up (in cache) for calc and storing.

//* TC - O(N), *SC - O(N) *See Comment Below Code
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

//* This particular problem can be solved using constant memory.
//* Simply Assign 2 Variables with the 'pre-loaded' values, and have a third variable to keep a running sum.
//* -- This solution is not implemented here as to keep a general Dynamic Programming Solution for reference (ex: could ask from stair 1 to 3 which is just L/U cache[1]).
