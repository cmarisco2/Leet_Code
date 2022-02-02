//* Problem 136: Single Number

//? Problem:
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

//? Examples:

// Input: nums = [2,2,1]
// Output: 1

// Input: nums = [4,1,2,1,2]
// Output: 4

// Input: nums = [1]
// Output: 1

//? Constraints:

// 1 <= nums.length <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
// Each element in the array appears twice except for one element which appears only once.

//? Solution Notes: TC - O(N), SC - O(1)
//* 1) XOR Properties:
    //* a) 0 ^ A = A (Identity)
    //* b) A ^ A = 0
    //* XOR is associative -> A ^ C ^ B ^ C ^ A = B
//* 2) Set intial int value to 0.
//* 3) Loop and cummulatively XOR with each element (val = val ^ nums[i]);

class SingleNumber_136{
    public static int singleNumber(int[] numbers){
        int singleVal = 0;
        for (int num : numbers)
            singleVal = singleVal ^ num;
        return singleVal;
    }
    public static void main(String[] args){
        int[] nums = { 2, 1, 4, 2, 1 };
        System.out.println("Array Values are: ");
        for(int i: nums){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("The Unique Value in this Array is: " + singleNumber(nums));
    }
}

//* This Bit Manipulation Technique is powerful at removing duplicates. Extend beyond just integer/bit Value IF equality is defined for ADTs.