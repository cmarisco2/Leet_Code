//? Leetcode Problem 76: Minimum Window Substring
//? Difficulty: HARD

// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// A substring is a contiguous sequence of characters within the string.

//? Examples:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.


//? Solution Notes: Idea
//* -Obvious Sliding Window Problem 
//* -Difficult To Solve
//! -Use 2 Maps(1st - Reference, 2nd - checks 1st, updates counter), Pushing RightSide w/ Counter (2 Counters, 1 - Ref, 2 - Counts to Ref)
//! -Counter Is Key!
    //! -Keeps Track of When to stop pushing onto list (Count == length)
    //! -Keeps Track of When To Stop Popping from the front (Count < length)
    
    
//? Solution Concept - Pseudocode/Formula
//? TC -> O(N + M), SC -> O(M): Space Complexity for both maps are based on the smaller string t.
//* 1) 2 Maps -> One for counting chars in String t. Other with same chars initialized all at 0.
//* 2) j - adds, i - pops
//* 3) "j": String S - Map has Value++ each found Key as "j" traverses String.
    //* Ints "Have" & "Need" rep # of chars found vs required. Have == 0 initially. Need = t.length();
    //* Have++; if we find a char with its Value <= T - Map Value.
//* 4) "i": Moves forward ONLY while (Have >= Need)
    //* String S - Map Value-- each found Key as "i" traverses String.
    //* Have--; if we find a char with its Value < T - Map Value. 

package Sliding_Window;


import java.util.HashMap;

class MinimumWindowSubstring_76{
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> haveMap = new HashMap<>();
        int have = 0, need = t.length(), i = 0, j = 0, minLength = Integer.MAX_VALUE, startIndex = -1;

        // if strings are empty or s is shorter than t -> return empty string
        if (s.length() <= 0 || t.length() <= 0 || s.length() < t.length())
            return "";

        // Construct Need and Have Maps in Single Loop
        for (int k = 0; k < t.length(); k++) {
            char key = t.charAt(k);
            if (needMap.containsKey(key))
                needMap.put(key, needMap.get(key) + 1);
            else {
                needMap.put(key, 1);
            }
            haveMap.put(key, 0);
        }

        for (; j < s.length(); j++) {
            char jChar = s.charAt(j);
            if (haveMap.containsKey(jChar)) {
                haveMap.put(jChar, haveMap.get(jChar) + 1);
                if (haveMap.get(jChar) <= needMap.get(jChar))
                    have++;
            }
            while (have >= need) {
                char iChar = s.charAt(i);
                if (haveMap.containsKey(iChar)){
                    haveMap.put(iChar, haveMap.get(iChar) - 1);
                    if (haveMap.get(iChar) < needMap.get(iChar)) have--;
                }
                i++;
                
                if ((j - i + 2) < minLength) {
                    minLength = j - i + 2;
                    startIndex = i - 1;
                }
            }

            
        }
        if (minLength != Integer.MAX_VALUE)
            return s.substring(startIndex, startIndex + minLength);
        return "";
    }

    public static void main(String[]args){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("aa", "a"));
        System.out.println(minWindow("abda", "aa"));
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));

    }
}