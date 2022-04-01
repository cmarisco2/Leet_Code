//? Leetcode Problem 344: 'Reverse String'
//? Difficulty: 'Easy'
//? Description:
// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

// //? Examples:
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]


// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

//* NOTE: These are Char[] not STRINGS. 
//* -Due to immutability of strings in many programming languages, an efficient solution wouldn't be feasible if rebuilding a string occurred on each swap.


//? Solution Approach: 2Ptr
//* 1) Use Left and Right pointers that are at the start and end of array
//* 2) Swap, While Left < Right

//? Time Complexity: O(N)
//? Space Complexity: O(1)

class ReverseString_344{
    public void reverseString(char[] s) {
        // initialize left and right array pointers
        int left = 0, right = s.length - 1;

        // Swap values at left and right until string is reversed.
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }

    }

    public void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}