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
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = { 1, 2, 3, 1 };
        int[] vals = { 1, 2, 3, 4 };
        //
        System.out.println("The nums array values are: ");
        System.out.print("[ ");
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println("]");
        System.out.println("Are there duplicates in nums?: " + containsDuplicate(nums));
        //
        System.out.println("The vals array values are: ");
        System.out.print("[ ");
        for(int i : vals){
            System.out.print(i + " ");
        }
        System.out.println("]");
        System.out.println("Are there duplicates in vals?: " + containsDuplicate(vals));
    }
}