//? Leetcode Problem 3: Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.

//? Examples:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

//?Solution Notes: SLIDING WINDOW APPROACH:
//* 1) Use HashSet 
//* 2) Check & Add Elements to SET from the RIGHT.
//* 3) IF Repeat -> Remove From LEFT Until No Repeats Exist in SET
package Sliding_Window;
import java.util.HashSet;

class LongestSubstringNoRepeatedChars_3{
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.println("Longest Substring with No Repeats in \"" + s + "\" is of length: " + lengthOfLongestSubstring(s));
    }
}