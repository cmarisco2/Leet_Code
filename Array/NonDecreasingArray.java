//? Leetcode Problem: 665 - Non-decreasing Array
//? Difficulty: 'Medium'
//? Description:

// Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

//? Examples:
// Input: nums = [4,2,3]
// Output: true
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

// Input: nums = [4,2,1]
// Output: false
// Explanation: You can't get a non-decreasing array by modify at most one element.

//! Need to find particular fail case
//! Think of "what to do in a simpler form of it?"
//* Key Example:
// [3,4,2,3] -> False
// Need to make choice
//*     i, i+1
//* [3, 4, 2] -> premote right of i to i will work ^R : [3, 4, 4]
//* [1, 4, 2] -> demote i to right of i will work 👇 L : [1, 2, 2]
//
//*  Otherwise, check [i] <= [i + 1]

//? Solution:

