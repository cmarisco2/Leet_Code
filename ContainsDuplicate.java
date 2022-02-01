//* Problem 217: ContainsDuplicate
//* Difficulty: EASY
//! Problem Type: Solve in linear time with HashSet<Integer>

//? Problem Statement:
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

//? Examples
// Input: nums = [1,2,3,1]
// Output: true

// Input: nums = [1,2,3,4]
// Output: false

//? Skipping Brute Force Solution

//? SOLUTION Notes: OPTIMAL SOLUTION - O(N) Guaranteed Time 
//* 1) For Each loop to Construct HashSet
    //* If: element is already in set -> return true;
    //* else: add to set
//* 2) return false.

import java.util.HashSet;
class ContainsDuplicate{
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}