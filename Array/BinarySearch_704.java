class BinarySearch_704{
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, nums.length - 1, 0);
    }

    public int binarySearch(int[] nums, int target, int hi, int lo) {
        if (hi < lo)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return binarySearch(nums, target, hi, mid + 1);
        else if (nums[mid] > target)
            return binarySearch(nums, target, mid - 1, lo);
        else
            return mid;
    }
}