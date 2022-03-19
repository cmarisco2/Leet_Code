//? Leetcode Problem #98: Validate Binary Search Tree
//? Difficulty: 'Medium'
//? Description:
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// --The left subtree of a node contains only nodes with keys less than the node's key.
// --The right subtree of a node contains only nodes with keys greater than the node's key.
// --Both the left and right subtrees must also be binary search trees.

//? Examples: 
//          5
//      1       4
//          3       6 (3 is leftchild of 4)

// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4

//? Solution Notes:
//* Key: Update left & right bounds during traversal down tree
//* LB = LeftBound, RB = RightBound

//? Algorithm Idea
//* Base Case
//* Check: LB < X.VAL < RB
//* Goto Right:
    //* Update LB
//* Goto Left:
    //* Update RB

//? Time Complexity == O(N)
//? Space Complexity == O(Tree Height)
class ValidateBST_98{
    public boolean isValidBST(TreeNode root) {
        boolean isValid = true;
        long leftBoundary = Long.MIN_VALUE;
        long rightBoundary = Long.MAX_VALUE;
        isValid = checkValid(root, isValid, leftBoundary, rightBoundary);
        return isValid;

    }

    public boolean checkValid(TreeNode x, boolean isValid, long lBound, long rBound) {
        if (x == null)
            return isValid;
        if (x.val <= lBound)
            isValid = false;
        if (x.val >= rBound)
            isValid = false;
        isValid = isValid && checkValid(x.left, isValid, lBound, x.val) && isValid
                && checkValid(x.right, isValid, x.val, rBound);

        return isValid;
    }
}