//* LeetCode Problem 1299: Replace Elements With Greatest Element on Right Side
package Arrays;

// Problem Statement:
// Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1

// After doing so, return the array

/**
 * Input array: [17, 18, 5, 4, 6, 1]
 * Output: [18, 6, 6, 6, 1, -1]
 */

// ? SOLUTION Notes:
// * 1) Reverse Iterate
// * 2) oldMax = -1 (before loop)
// * 3) newMax = max(oldMax, arr[i])
class Replace_Right_Elements {
    public static int[] replaceElements(int[] arr) {
        int oldMax = -1;
        int newMax;
        
        for(int i = arr.length - 1; i >= 0; i--){
            newMax = Math.max(oldMax, arr[i]);
            arr[i] = oldMax;
            oldMax = newMax;
        }
        
        return arr;
        
    }
}