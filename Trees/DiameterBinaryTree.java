//? Leetcode Problem: 534 - Diameter of A Binary Tree
//? Difficulty: 'Easy'
//? Description: 

// Given the root of a binary tree, return the length of the diameter of the tree.

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// The length of a path between two nodes is represented by the number of edges between them.

// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

// Input: root = [1,2]
// Output: 1

//? Solution Notes:
//* Concept -> return depth of node, however calculate the running width and update a max separately.
    //* -Another case where the 'return' isn't what we need, just helps calculate the value of interest.

//? Idea:
// * Modify maxDepth of Binary Tree (Top Down):
    //* node == null return 0;
    //* left = maxDepth(node.left);
    //* right = maxDepth(node.right);
        //* //diameter code
    //* return 1 + Max(left, right);

//* Diameter code:
    //* Idea -> diameter is just sum of left & right heights.
    //* Idea -> keep tab of maximum diameter encountered.

//? Time Complexity -> O(N)
//? Space Complexity -> O(height of Tree || max stack frame allowable)
class DiameterBinaryTree{
    int depth, diameter, maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        depth = 0;
        diameter = 0;
        maxDiameter = 0;
        depth = dfsDiameter(root);
        return maxDiameter;

    }
    public int dfsDiameter(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfsDiameter(root.left);
        int right = dfsDiameter(root.right);
        diameter = left + right;
        maxDiameter = Math.max(maxDiameter, diameter);
        return 1 + Math.max(left, right);
    }
}