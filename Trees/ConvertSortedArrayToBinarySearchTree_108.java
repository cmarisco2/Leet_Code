//? Leetcode Problem 108: Convert Sorted Array to Binary Search Tree
//? Difficulty: 'Easy'
//? Description:
// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

//? Examples:
// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted

//? Solution Notes: Recursive BinarySearch Approach
//* 1) Insert the Mid Value 1st.
//* 2) left, insert mid of left half recursively.
//* 3) right, insert mid of right half recursively.
//* The subproblem is IDENTICAL to Partition of Quick Sort.
    //! Find mid, recurse( lo, mid - 1 ), recurse( mid + 1, hi )

//* Key: Assign Directly using order to mimic AS a Binary Search Tree. Don't make it a logical Binary Search Tree
    //* Basically assign left = mid(left), etc. to create BST form.
class ConvertSortedArrayToBinarySearchTree_108{
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        root = addMidNode(root, nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode addMidNode(TreeNode x, int[] nums, int lo, int hi) {
        if (hi < lo)
            return null;
        int mid = lo + (hi - lo) / 2;
        x = new TreeNode(nums[mid]);
        x.left = addMidNode(x.left, nums, lo, mid - 1);
        x.right = addMidNode(x.right, nums, mid + 1, hi);
        return x;
    }
}