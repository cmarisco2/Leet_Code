//? Leetcode Problem 242: Valid Anagram
//? Difficulty: "Easy"
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

//? Examples:

// Input: s = "anagram", t = "nagaram"
// Output: true

// Input: s = "rat", t = "car"
// Output: false

//? Solution Idea: Map Freq Counter
//* Create 2 Maps that count the frequency of each char element and return true if and only if the count for each character matches.
//* otherwise, return false

//? Better Idea: Single Radix-Array Counter
//* create int[] array length of radix (26)
//* increment the mapped index for each appearance in string S.
//* decrement the mapped index for each appearance in String T.
//* Loop through and check for any non-0's.

//? Time Complexity is linear O(N + M), where N = s.length() and M = t.length();

//? Space Complexity is constant as the radix array is of fixed length (26) and doesn't vary with the size of the input string.
class ValidAnagram_242{
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet)
            if (i != 0)
                return false;
        return true;
    }
}