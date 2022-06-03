//? Leetcode Problem 235: Lowest Common Ancestor of a Binary Search Tree
//? Difficulty: 'Easy'
//? Description:

// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

//? Examples:
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.

// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

// Input: root = [2,1], p = 2, q = 1
// Output: 2

//? Solution Approach:
//* The Idea is identical to a normal"search"method of a BST except with 2 values.

//* 1) if Both p&&q vals are LESS than current node -> go left */
//* 2) if Both p&&q vals are GREATER than current node -> go right */
//* 3) Else -> return current Node (handles equals and splitting the tree) */

//? Time Complexity: O(log(n)) Assuming Balanced BST or O(N) otherwise
//? Space Complexity: O(h)
public class LowestCommonAncestorBST{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}