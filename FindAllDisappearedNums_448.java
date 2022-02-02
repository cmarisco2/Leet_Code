//?Problem: 448. Find All Numbers Disappeared in an Array

// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

//? Constraints:

//* n == nums.length
//* 1 <= n <= 105
//* 1 <= nums[i] <= n

//? Examples:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]

// Input: nums = [1,1]
// Output: [2]

//* Initial Solution -> HashSet with all values in array entered.
//* Loop through full range. Add to list any element not found in set.
//* TC -> O(N), SC -> O(N)
    //* Can do better? Yes, can solve with SC -> O(1) !!!


//! Tricks - *Range and Indices method is a convenient idea to keep in handy for array problems

//! 1) Range <---> Array Indices Mapping (Allows for checking and storing data with second trick)
//* 2) Mutate Given Argument Array! (Use to flag visited mapped indices. Return to original state prior to completing the solution)


//? Solution Notes:
//? Create List
//* 1) Map Vals <-> Indices: 1 -> N :: 0 -> (N-1)  //This map is implicit and doesn't require any extra structures/code just mathematical offsets.
//* 2) Mark Loop
    //* val = absolute value at arr[i]
    //* go to index @ val - 1.
    //* make it negative.
//* 3) Check Loop
    //* if a value @ i is pos. append(i + 1) to the list // Reverse Mapping
    //* Else (val @ i is neg) -> reassign val @ i, its positive value.
//? Return List

import java.util.ArrayList;
import java.util.List;


class FindAllDisappearedNums_448{
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> vals = new ArrayList<Integer>();

        //Mark Loop
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]);
            nums[val - 1] = Math.abs(nums[val - 1]) * -1;
        }
        
        //Check and Fix Loop
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                vals.add(i + 1);
            } else {
                nums[i] *= -1;
            }
        }
        return vals;
    }

    public static void main(String[]args){
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

        List<Integer> vals = findDisappearedNumbers(nums);
        System.out.println();
        System.out.print("[ ");
        for(int val: vals){
            System.out.print(val + " ");
        }
        System.out.println("]");
        System.out.print("[ ");
        for(int num: nums){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }
}