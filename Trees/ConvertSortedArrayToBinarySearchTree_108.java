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