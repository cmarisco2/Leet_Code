//? Leetcode Problem 35: Search Insert Position
//? Difficulty: 'Easy'
//? Description:
// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

//? Examples:
// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Input: nums = [1,3,5,6], target = 2
// Output: 1

// Input: nums = [1,3,5,6], target = 7
// Output: 4

//? Solution Approach: Binary Search
//* CHANGE BASE CASE:
    //* Old: if(hi < lo) return -1;
    //* New: if(hi < lo) return lo;

//? Time complexity: O(log(n))
//? Space complexity: O(log(n)) number of stack frames?
public class SearchInsertPosition{
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1])
            return nums.length;
        return binarySearch(nums, target, nums.length - 1, 0);
    }

    public int binarySearch(int[] nums, int target, int hi, int lo) {
        if (hi < lo)
            return lo;
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