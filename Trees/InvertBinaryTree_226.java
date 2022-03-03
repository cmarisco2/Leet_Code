//? LeetCode Problem 226: Invert A Binary Tree
// Given the root of a binary tree, invert the tree, and return its root.

//? Example:
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]

//? Solution Approach: Bottom Up DFS
//* 1) x is null? return null
//* 2) dfs(left), dfs(right)
//* 3) swap (x.left, x.right)
//* 4) return x;

//? Time Complexity -> O(N)
//? Space Complexity -> O(Height of Tree)

class InvertBinaryTree_226{
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        return root;
    }
}