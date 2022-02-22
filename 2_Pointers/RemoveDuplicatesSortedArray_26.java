//? Problem 26: Remove Duplicates from a Sorted Array.
// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

// Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

// Return k after placing the final result in the first k slots of nums.

// Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

//? Examples:

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).

//? Special Considerations:
//* This solution is in-place and asks for constant memory with a sorted array input.
//* This screams 2Ptr solution.
//* Utilizing the Order and Not moving the 2nd Pointer unless necessary is key.


//? Solution Notes: 2Ptr Approach
//* 1) left & right ptrs initialized at position 1 (first element unique by default)
//* 2) right ptr -> scans
//*    left ptr -> marks index for next unique value
//* 3) if (arr[right] == arr[right - 1]) right++
//*    if(arr[right] != arr[right - 1]) arr[left] = arr[right],left++,right++

//? TC -> O(N), SC -> O(1)

class RemoveDuplicatesSortedArray_26{
    public static int removeDuplicates(int[] nums) {
        int left = 1, right = 1;
        while (right < nums.length) {
            if (nums[right - 1] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
    public static void main(String[] args){
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.print("[ ");
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println("]"); //Output: [ 0 0 1 1 1 2 2 3 3 4 ]
        
        int k = removeDuplicates(nums);

        System.out.print("[ ");
        for(int i = 0; i < k; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println("]"); //Output: [ 0 1 2 3 4 ]
    }
}