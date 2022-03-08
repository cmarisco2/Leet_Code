//? Leetcode Problem 124: Binary Tree Maximum Path Sum
//? Difficulty: 'Hard'
//? Problem Statment:
// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

// The path sum of a path is the sum of the node's values in the path.

// Given the root of a binary tree, return the maximum path sum of any non-empty path.

//? Examples:
// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

//? Solution Notes:
//? return value up tree IS DIFFERENT max value returned by function.
//*      1
//* -2       3
//* leftNode(-2) returns 0, rightNode(3) returns 3.

//* max calc result treats visited node as pivot in path: left + node + right
//* and compares to current max and updates if necessary.


//? Time Complexity = O(N)
class BinaryTreeMaxPathSum_124{
    int res;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        maxPathSumHelp(root);
        return res;
    }

    public int maxPathSumHelp(TreeNode x) {
        if (x == null)
            return 0;
        int left = maxPathSumHelp(x.left);
        int right = maxPathSumHelp(x.right);
        res = Math.max(res, x.val + left + right);
        return Math.max(0, x.val + Math.max(left, right));
    }
}