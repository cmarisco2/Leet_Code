//? Leetcode Problem 100: 'Same Tree'
//? Difficulty: 'Easy'
//? Description: 
// Given the roots of two binary trees p and q, write a function to check if they are the same or not.

// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

//? Examples: 
// Input: p = [1,2,3], q = [1,2,3]
// Output: true

// Input: p = [1,2,1], q = [1,1,2]
// Output: false

//? Solution Approach: Top Down Recursion w/ flag
//* BC (p == null && q == null) return true
//* if( either is null and other isn't ) return false;
//* if vals aren't equal, return false;
//* recurseLeft(flag, p.left, q.left); Assign w/ && logic
//* recurseRight(flag, p.right, q.right); Assign w/ && logic


class SameTree_100{
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        if (root.val != subRoot.val)
            return false;
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}