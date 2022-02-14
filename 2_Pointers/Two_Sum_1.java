//* Problem 1: Two Sum
//* Difficulty: EASY
//! Problem Type: Solve in linear time with HashMap<Int, Int>

//? Problem Statement:

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

//? Examples
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Input: nums = [3,3], target = 6
// Output: [0,1]

//? BRUTE FORCE SOLUTION O(N^2)
// Nested For Loops Concept:
//  for(i -> range){
//     for(j -> range){
//         if(nums[i] + nums[j] == target) return [i, j];
//     }
// }

//? Sort Solution O(NlgN) ( O(N) if Array is presorted! )
// Sort Array -> This is where the heavy lifting 
// 2 Pointers, 1 at Beginning of the Array, i, and 1 at the End of the array, j.
// loop the array
    // if i > j -> sum does not exist -> break OR return null;
    // if(nums[i] + nums[j]) == target -> return i & j;
    // if(nums[i] + nums[j]) > target (sum too big) j--;
    // if(nums[i] + nums[j]) < target (sum too small) i++;


//? SOLUTION Notes: OPTIMAL SOLUTION - O(N) Guaranteed Time 
//* 1) For Loop to construct hashmap such that 
        //* Key = Num[i], Value = i for all array elements
//* 2) PRIOR TO ADDING Elements to map -> CHECK if COMPLEMENT is in MAP.
        //* IF SO -> return that index and the current index

import java.util.HashMap;

class Two_Sum_1{
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] pairSum = new int[2];

        
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i], complement = target - key;
            if(map.containsKey(complement)){
                pairSum[1] = i;
                pairSum[0] = map.get(complement);
                return pairSum;
            } 
            map.put(key, i);
        }
        return pairSum;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 9, 1, 3 };
        int target = 7;

        int [] pairSum = twoSum(nums, target);
        for(int i: pairSum){
            System.out.print(i + " ");
        }
    }
}