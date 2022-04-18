class Solution {
    TreeNode foundSubRoot;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Use Global to set
        get(root, subRoot.val);
        return containsSubTree(foundSubRoot, subRoot, true);
    }

    // get method that returns the root of the subroot within bigger tree.
    public void get(TreeNode x, int val) {
        if (x == null)
            return;
        if (x.val == val)
            foundSubRoot = x;
        get(x.left, val);
        get(x.right, val);
    }

    // Checks if the bigTree contains the small tree, starting at same element.
    public boolean containsSubTree(TreeNode bigTree, TreeNode smallTree, boolean flag) {
        if (flag == false)
            return false;
        if (smallTree == null && bigTree == null)
            return flag;
        if (smallTree == null && bigTree != null)
            return false;
        if (bigTree == null && smallTree != null)
            return false;
        if (smallTree.val != bigTree.val)
            return false;
        flag = flag && containsSubTree(bigTree.left, smallTree.left, flag)
                && containsSubTree(bigTree.right, smallTree.right, flag);
        return flag;
    }
}