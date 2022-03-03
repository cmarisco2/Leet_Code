//? Leetcode 110: Balanced Binary Tree
//? Difficulty: 'Easy'
//? Problem Statement:
// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as:

// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

//? Examples
// Input: root = [3,9,20,null,null,15,7]
// Output: true

//? Solution Approach:
//* DFS - BOTTOM UP
//* - Base Case
//* - Code -> Recurse -- Happens on the Way DOWN
//* - Recurse -> Code -- Happens on the Way UP

//* BC, DFS, Code for this problem for "Way UP"

//? Solution Notes:
//! tree height = 1 + max(left, right)
//* 1) BC -- if(x == null) return 0;
//* 2) DFS left & Right (to get to the bottom)
    //* left = dfs(x.left), right = dfs(x.right);
//* 3) Create and Return flag if left and height diff exceeds given constraint
//* 4) Else, return 1 + max(left, right);


class BalancedBinaryTree_110{
    public boolean isBalanced(TreeNode root) {
        int flag = dfsHeight(root, 1);
        return flag != Integer.MAX_VALUE;
    }
    
    public int dfsHeight(TreeNode x, int diff) {
        if (x == null)
            return 0;
        int left = dfsHeight(x.left, diff);
        int right = dfsHeight(x.right, diff);
        if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (Math.abs(right - left) > diff)
            return Integer.MAX_VALUE;
        else
            return 1 + Math.max(left, right);
    }
}