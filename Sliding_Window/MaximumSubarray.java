//? Leetcode Problem: 53 -- Maximum Subarray
//? Difficulty: 'Easy'
//? Description: 

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// A subarray is a contiguous part of an array.

//? Examples:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

// Input: nums = [1]
// Output: 1

// Input: nums = [5,4,-1,7,8]
// Output: 23

//? Solution Notes: 
//* Keep Running SUM of contigous elements
//*  with L & R  Pointers

//* R scans adding to sum and recalculating maximum on each iteration.
//* L stays at beginning of the subarray.
//* if R is at a value GREATER than the current SUM && current SUM is negative -> reset sum and skip up the L to the new starting point.

//*  Ex:
//* [ -1, 2, -1, -3, 4, .....  ]
//*     L
//*     R
//*    Sum is currently -1. 
//*    R increments. It's value is > sum and sum is negative => max is acheived by starting at 2 rather than adding 2 to the current sum (because -1 + 2 < 2).
class MaximumSubarray{
    public int maxSubArray(int[] nums) {
        int right = 0, left = 0, tempMax = nums[0], sum = nums[0];

        for (; right < nums.length; right++) {
            if (nums[right] > sum && sum < 0)
                left = right;
            sum = left == right ? nums[left] : sum + nums[right];
            tempMax = Math.max(tempMax, sum);
        }

        return tempMax;
    }
}