class CountGoodNodes_BinaryTree_1448{
    int count = 0;
    public int goodNodes(TreeNode root){
        goodNode(root, root.val);
        return count;
    }
    
    public void goodNode(TreeNode x, int ref){
        if (x == null) return;
        if (x.val >= ref){
            count++;
            ref = x.val;
        }
        goodNode(x.left, ref);
        goodNode(x.right, ref);
    }
}
