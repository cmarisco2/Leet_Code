//? Leetcode Problem 617: 'Merge Two Binary Trees'
//? Difficulty: 'Easy'

// You are given two binary trees root1 and root2.

// Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

// Return the merged tree.

// Note: The merging process must start from the root nodes of both trees.

//? Solution Approach: Parallel Recursion - Top Down
//! Key - Ternary Operator For Assignment
    //* Parallel Tree Traversal Presents an Interesting "Null" Problem
    //* if 1 node is null and the other isn't, fine at that level.
        //* BUT the recurse call dfs(node.left) WON'T work if node == NULL
        //* Need to check and pass null via ternary if that's the case 


//? Time & Space:
//* TC -> O(Max(N,M)): visit each node once simultaneously. Time depends on the
class MergeTwoBinaryTrees_617{
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base Case
        if (root1 == null && root2 == null)
            return null;
        // Sets values to add for new TreeNode
        int val1 = root1 == null ? 0 : root1.val;
        int val2 = root2 == null ? 0 : root2.val;
        TreeNode trueTree = new TreeNode(val1 + val2);

        // Ternary to avoid ".left" called on a null value if either root is null
        TreeNode left1 = root1 == null ? null : root1.left;
        TreeNode left2 = root2 == null ? null : root2.left;
        TreeNode right1 = root1 == null ? null : root1.right;
        TreeNode right2 = root2 == null ? null : root2.right;

        // Recurse left and right subtrees
        trueTree.left = mergeTrees(left1, left2);
        trueTree.right = mergeTrees(right1, right2);

        // return tree
        return trueTree;
    }
}