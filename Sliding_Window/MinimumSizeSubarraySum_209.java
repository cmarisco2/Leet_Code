//? Leetcode Problem 209: Minimum Size Subarray Sum
//? Problem Statement:
// Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

//? Examples:
// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.

// Input: target = 4, nums = [1,4,4]
// Output: 1

// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0

//? Solution Notes:
//! KEY - 'Minimum Size' + 'Subarray/Substring' + 'Target/Sum' = SLIDING WINDOW

//* 1) 2Ptrs i & j, Both Start at 0, j moving left to right.
//* 2) Add j's value to sum. j increments with loop.
//* 3) while(sum>=target) -> remove i's value. increment i. update min length.
    //* --min length is initially high constant.
    //* --if i == j, sum is value at i or j.
    //* --if min length is never updated, return 0. else return min length.

//? Complexity:
//* TC -> O(N)
    //* Iterate through the Loop Once.
//* SC -> O(1)
    //* Use only i,j,sum, and minLength regardless of size of nums[]

class MinimumSizeSubarraySum_209{
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, sum = 0, minLength = Integer.MAX_VALUE;
        for (; j < nums.length; j++) {
            sum += nums[j];
            if (i == j)
                sum = nums[j];
            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i++];
            }
        }
        if (minLength == Integer.MAX_VALUE)
            return 0;
        return minLength;
    }

    public static void main(String[] args){
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println("The input array is:");
        System.out.print("[ ");
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println("]");
        System.out.println("The Minimum Size Subarray Sum for target " + target + " is of length: " + minSubArrayLen(target, nums));
    }
}