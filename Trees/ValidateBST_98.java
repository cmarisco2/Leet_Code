
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