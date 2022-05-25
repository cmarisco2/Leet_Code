//? Leetcode Problem 567: Permutation in a String
//? Difficulty: 'Medium'
//? Description
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

//? Examples:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

//? Constraints:
// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.

//? Solution Notes: Idea 1
//* Create 2 HashMaps for s1 and s2
//* Sliding window approach to compare membership and quantity btwn s1Map and s2Map

//? Solution Notes: Idea 2
//* Use 2 int[] size 26 -> maps alphabetical chars
//* map s1 completely
//* map window of s2 completely
//* count matches
    //* loop and check for matches with the sliding window technique
    //* return if mathches == 26

//? Time Complexity == O(N)
//? Space Complexity == O(N)
public class PermutationInString{
    public static boolean checkInclusion(String s1, String s2) {
        int matches = 0;
        int windowLength = s1.length();
        int radix = 26; // base of lowercase alphabetical chars
        if (s2.length() < s1.length())
            return false;

        int[] s1Map = new int[radix];
        int[] s2Map = new int[radix];

        // Build S1 Map
        for (int i = 0; i < windowLength; i++) {
            char key = s1.charAt(i);
            s1Map[charIndex(key)]++;
        }

        // Build S2 Map w/ S1 size -> sliding window
        for (int i = 0; i < windowLength; i++) {
            char key = s2.charAt(i);
            s2Map[charIndex(key)]++;
        }

        // count initial matches
        for (int i = 0; i < radix; i++) {
            if (s1Map[i] == s2Map[i])
                matches++;
        }

        // Check matches while sliding the window:
        int left = 0;
        int right = windowLength - 1;
        for (; right < s2.length() - 1; left++) {
            if (matches == radix)
                return true;
            // update matches if
            // 1) maps equal -> matches++
            // 2) maps arent' equal, but were (off by 1) -> matches--;

            // remove left
            char leftkey = s2.charAt(left);
            s2Map[charIndex(leftkey)]--;
            if (s1Map[charIndex(leftkey)] == s2Map[charIndex(leftkey)])
                matches++;
            else if (s1Map[charIndex(leftkey)] == s2Map[charIndex(leftkey)] + 1)
                matches--;
            // add right
            char rightkey = s2.charAt(++right);
            s2Map[charIndex(rightkey)]++;
            if (s1Map[charIndex(rightkey)] == s2Map[charIndex(rightkey)])
                matches++;
            else if (s1Map[charIndex(rightkey)] == s2Map[charIndex(rightkey)] - 1)
                matches--;
        }

        return matches == radix;
    }

    public static int charIndex(char ch) {
        return ch - 'a';
    }

    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println("\nStrings are:\n" + s1 + "\n" + s2 + "\n");
        System.out.println("Is " + s1 + " a permutation of " + s2 + "?");
        System.out.println(checkInclusion(s1, s2) + "\n");
    }
}