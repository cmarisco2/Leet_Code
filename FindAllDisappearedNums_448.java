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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


class FindAllDisappearedNums_448{
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> vals = new ArrayList<Integer>();

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i))
                vals.add(i);
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
    }
}