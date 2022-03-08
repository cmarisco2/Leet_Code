//? Leetcode Problem 104: Maximum Depth Of A Binary Tree:
//? Difficulty: 'Easy'
//? Problem:

// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

//? Example:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

//? Solution Approach: Bottom Up
//* 1) Post Order Recursion (BC return 0 & assign left,right return values)
//* 2) Height = 1 + Max(leftSubTree, rightSubTree)



//? Time Complexity == O(N)
//* Every Node is visited Once

//? Space Complexity == O(height)
//* Each Recursive call adds memory to the call stack proportional to the height of the tree
class MaximumDepthOfBinaryTree_104{
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}