//? Leetcode Problem 1089: Duplicate Zeros
//? Difficulty: 'Easy'
//? Description:

// Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

// Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

//? Examples:
// Input: arr = [1,0,2,3,0,4,5,0]
// Output: [1,0,0,2,3,0,0,4]
// Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

//? Solution Approach:
//* 1) Use Separate List<>
//* 2) Copy All elements to new list except:
        //* if elem == 0 -> copy it twice.
//* 3) Copy new list back to old array ONLY for length of original array.

class DuplicateZeros{

        public void duplicateZeros(int[] arr) {
            // Separate List
            int[] dup = new int[arr.length];

            // Copy Elements into new list, except copy 0 twice
            for (int i = 0, j = 0; j < arr.length && i < arr.length; i++, j++) {
                if (arr[i] == 0) {
                    dup[j++] = arr[i];
                }
                
                // Solve edge case when j is out of array range
                if (j >= arr.length)
                    break;
                dup[j] = arr[i];
            }

            // Copy new list into old list
            int k = 0;
            for (int num : dup) {
                arr[k++] = num;
            }
        }
    
}