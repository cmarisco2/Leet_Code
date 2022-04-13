class ProductOfArrayExceptSelf{
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixes = new int[len];
        int[] postfixes = new int[len];
        int[] results = new int[len];

        prefixes[0] = nums[0];
        postfixes[len - 1] = nums[len - 1];

        // Create Prefix and Post fix arrays in a single swooop.
        for (int i = 1; i < len; i++) {
            prefixes[i] = nums[i] * prefixes[i - 1];
            postfixes[len - 1 - i] = nums[len - i - 1] * postfixes[len - i];
        }

        // Calculate resultant array values with special cases for out of bound prefixes
        // or postfixes.
        int preProduct, postProduct;
        for (int i = 0; i < len; i++) {
            preProduct = i == 0 ? 1 : prefixes[i - 1];
            postProduct = i == len - 1 ? 1 : postfixes[i + 1];
            results[i] = preProduct * postProduct;
        }

        return results;
    }
}