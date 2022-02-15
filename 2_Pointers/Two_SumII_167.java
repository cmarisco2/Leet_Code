//? Proble 167: Two Sum II - Input Array Is Sorted
//? Difficulty: Medium
// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

// The tests are generated such that there is exactly one solution. You may not use the same element twice.

// Your solution must use only constant extra space.

//? Examples:
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]
// Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

// Input: numbers = [2,3,4], target = 6
// Output: [1,3]
// Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

//? Solution Notes: 2 Pointer Approach
//* 1) Left Pointer at Beginning of Input Array
//* 2) Right Pointer at the End of the Input Array
//* 3) If Sum == Target, return Left/Right + 1, as indice values
    //* if Sum > Target, too large, move Right Pointer to lesser value (Right--)
    //* if Sum < Target, too small, move Left Pointer to greater value (Left++)
//* Return indice array

//? TC -> O(N), SC -> O(1) 
class Two_SumII_167{
    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1, sum;

        int[] indices = new int[2];

        while (left <= right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                indices[0] = left + 1;
                indices[1] = right + 1;
                return indices;
            }
            if (sum > target)
                right--;
            else
                left++;
        }

        return indices;
    }

    public static void main(String[] args){
        
    }
}