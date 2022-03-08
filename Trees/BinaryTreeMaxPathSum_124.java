class BinaryTreeMaxPathSum_124{
    int res;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        maxPathSumHelp(root);
        return res;
    }

    public int maxPathSumHelp(TreeNode x) {
        if (x == null)
            return 0;
        int left = maxPathSumHelp(x.left);
        int right = maxPathSumHelp(x.right);
        res = Math.max(res, x.val + left + right);
        return Math.max(0, x.val + Math.max(left, right));
    }
}