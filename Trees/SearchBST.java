//? Leetcode Problem: 700 - Search in a Binary Search Tree
//? Difficulty: 'Easy'
//? Description: 

// You are given the root of a binary search tree (BST) and an integer val.

// Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

//? Examples:

// Input: root = [4,2,7,1,3], val = 2
// Output: [2,1,3]

// Input: root = [4,2,7,1,3], val = 5
// Output: []

//? Solution Notes:
//* Basic Data Structure implementation of Search in a BST
//* Based on Robert Sedgwick & Kevin Wayne design in book Algorithms
//* Top Down Recursive approach. 
//* Return Statement to terminate traversal up the call stack after recursion.

class SearchBST{
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (val < root.val)
            return searchBST(root.left, val);
        else if (val > root.val)
            return searchBST(root.right, val);
        else
            return root;
    }
}