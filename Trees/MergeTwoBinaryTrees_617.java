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