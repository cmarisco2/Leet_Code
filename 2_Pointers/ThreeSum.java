//? Leetcode Problem 15: 3Sum
//? Difficulty: 'Medium'
//? Description:

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

//? Examples:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Input: nums = []
// Output: []

// Input: nums = [0]
// Output: []

//? Solution Approach: Sort + 2Ptrs N Times
//* Sort Input Array
//* Loop i -> n 
    //* while j < k
        //* 2Sum on remaining elements
        //! skip duplicates (both i loop and one ptr in while loop)
    
    //* store i,j,k vals in result list if == target (-nums[i])

//? Time Complexity = nlgn + n^2 -> O(N^2)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum{
    public static List<List<Integer>> threeSum(int[] nums) {
        // List to return at the end
        List<List<Integer>> result = new LinkedList<>();
        // Declare and initialize variables
        int i, j, k, target, tempSum;
        Arrays.sort(nums);

        for (i = 0; i < nums.length - 2; i++) {
            while (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                if (i >= nums.length)
                    break;
            }
            ;
            j = i + 1;
            k = nums.length - 1;

            while (j < k) {
                target = -1 * nums[i];
                tempSum = nums[j] + nums[k];
                if (tempSum == target) {
                    List<Integer> li = new LinkedList<>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    result.add(li);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                } else if (tempSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        // [-1,0,1,2,-1,-4]
        int[] testVals = {-1,0,1,2,-1,-4};
        System.out.println("\nValues in the int[]: " + Arrays.toString(testVals)+ "\n");
        List<List<Integer>> vals = threeSum(testVals);

        System.out.println("Unique values that sum to zero from int[]:\n");

        for(List<Integer> li : vals){
            System.out.print("[");
            for(int val : li){
                System.out.print(val + ", ");
            }
            System.out.println("]");
        }

        System.out.println();
    }
}