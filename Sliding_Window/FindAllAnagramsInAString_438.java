//? Leetcode Problem 438: Find All Anagrams in A String
//? Difficulty: Medium
//? Problem:
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

//? Examples: 

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".

//? Solution Approach: 2Ptr/Sliding Window Problem.
//* -Similar to Minimum Window Substring Problem.
//* -Just use extra counter ("extra") to count above what's needed and add only if the extra characters == 0 (exact count of chars btwn strings == anagram)
//* - Also, only add to the list the index if the found anagram matches the length of the given string (j - i + 1 === p.length())


//? Solution Notes:
//* 1) Create 2 Maps -> 1 with exact counts of the anagram string.
//*                  -> 1 with all chars initialized at 0.
//* 2) J -> Scan to right and keep count
//* 3) I -> Remove From left and decrement count.
//! 4) have, need, extra, determine when to add to the list

//? Complexity Analysis:
//* TC -> O(N + M), SC -> O(M)

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class FindAllAnagramsInAString_438{
    public static List<Integer> findAnagrams(String s, String p) {
        // Data Structures needed
        HashMap<Character, Integer> p_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        int i = 0, j = 0, have = 0, extra = 0, need = p.length();

        // initialize both maps.
        for (int k = 0; k < need; k++) {
            char key = p.charAt(k);
            if (p_map.containsKey(key)) {
                p_map.put(key, p_map.get(key) + 1);
            } else {
                p_map.put(key, 1);
            }
            s_map.put(key, 0);
        }

        while (j < s.length()) {
            char jChar = s.charAt(j);
            if (p_map.containsKey(jChar)) {
                if (p_map.get(jChar) > s_map.get(jChar)) have++;
                else extra++;
                s_map.put(jChar, s_map.get(jChar) + 1);
            }

            while (have >= need) {
                char iChar = s.charAt(i);
                if (p_map.containsKey(iChar)) {
                    if (s_map.get(iChar) <= p_map.get(iChar)) {
                        if(extra == 0 && j - i + 1 <= p.length()) result.add(i);
                        have--;
                    } else {
                        extra--;
                    }
                    s_map.put(iChar, s_map.get(iChar) - 1);
                }
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args){
        // String s = "cbaebabacd";
        String s = "abaacbabc";
        String p = "abc";

        List<Integer> list = findAnagrams(s, p);
        for(int w: list){
            System.out.print(w + " ");
        }
    }
}