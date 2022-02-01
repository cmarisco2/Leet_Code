//? Problem 268: Missing Number
// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

//? KEY == CONSTRAINTS
//* 1) ALL numbers in 'nums' are UNIQUE -> No Repeats
//* 2) N == nums.length -> Defines Length
//* 3) 0 <= nums[i] <= N -> Defines Range

//? Examples: 
// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

// Input: nums = [0,1]
// Output: 2
// Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

//? Ideas:
//* BF -> Loop w/ innerLoop checking for if given int is not found with boolean flag: TC - O(N^2), SC - O(1)
//* Sort -> Sort all elements. Walk through and return the missing one: TC - O(NlgN), SC - O(1)
//* HashSet -> Place all elements in a Set. Membership check every number in Range: TC - O(N), SC - O(N)
//* BEST -> Sum The Range Formulaically. Sum The Array Elements. Return the Diff: TC - O(N), SC - O(1)
    //* BEST only feasible due to CONSTRAINTS listed above


//? Solution Notes: TC -> O(N), SC -> O(1)
//* 1) Sum The 1st N Numbers of The Given Range: N*(N+1)/2
//* 2) Sum The Elements in the Array
//* 3) Subtract the difference btwn Range and Sum.
class MissingNumber_268{
    public static int missingNumber(int[] nums) {
        int rangeSum = (nums.length) * (nums.length + 1) / 2, arraySum = 0;

        for (int i : nums) {
            arraySum += i;
        }
        return rangeSum - arraySum;
    }

    public static void main(String[] args){
        int[] nums = { 3, 0, 1 };
        System.out.println(missingNumber(nums));
    }
}