//? Problem 977: Squares of a Sorted Array.
//? Difficulty: Easy

// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

//? Examples:
// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]

//? Brute Force - Sorting
//? TC -> O(NlgN), SC -> O(1) Assuming an inplace QuickSort is used.
// Square All Elements in the Array.
// Sort All Elements in the Array.

//? Solution Notes: 2Ptr Approach
//* 1) Square All Elements in the Array.
//* 2) Copy from Front & Back of Given Array to the Back of an Aux Array based on the higher value
    //* Value @ J is Greater Square of L/R (16 vs 100)
    //* [-4, -1, 0, 3, 10]   [ , , , , ]
    //*   L            R              J

//? TC -> O(N), SC -> O(N) for the auxiliary array used.
class SquaresOfASortedArray_977{
    public static int[] sortedSquares(int[] nums) {
        // Create Auxiliary Array, Left/Right Pointers, and Auxiliary Array Pointer, J
        int j = nums.length - 1;
        int R = j;
        int L = 0;
        int[] aux = new int[j + 1];

        // Square All Values of the Input Array
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        // Copy the higher value of at L/R ptrs of the input array to the end of the aux array and move towards the beginning of the the aux array.
        while (L <= R) {
            if (nums[R] > nums[L]) {
                aux[j] = nums[R];
                R--;
            } else {
                aux[j] = nums[L];
                L++;
            }
            j--;
        }

        // return array
        return aux;
    }

    public static void main(String[] args){
        int[] nums = { -4, -1, 0, 3, 10 };
        System.out.println("String of Sorted Numbers Given: ");
        System.out.print("[ ");
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println("]");
        System.out.println("Sorted Squares of Numbers Given: ");
        System.out.print("[ ");
        nums = sortedSquares(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }
        System.out.println("]");
    }
}