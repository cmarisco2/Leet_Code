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
//* BC (p == null && q == null) return flag;
//* if( either is null and other isn't ) return false;
//* if vals aren't equal, return false;
//* recurseLeft(flag, p.left, q.left); Assign w/ && logic
//* recurseRight(flag, p.right, q.right); Assign w/ && logic
//* return flag;


class SameTree_100{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = true;
        return sameTree(flag, p, q);
    }

    public boolean sameTree(boolean flag, TreeNode p, TreeNode q) {
        if (flag == false)
            return false;
        if (p == null && q == null)
            return flag;
        if (p == null && q != null)
            return false;
        if (p != null && q == null)
            return false;
        if (p.val != q.val)
            return false;
        flag = flag && sameTree(flag, p.left, q.left);
        flag = flag && sameTree(flag, p.right, q.right);
        return flag;
    }
}