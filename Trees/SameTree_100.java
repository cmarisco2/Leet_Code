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