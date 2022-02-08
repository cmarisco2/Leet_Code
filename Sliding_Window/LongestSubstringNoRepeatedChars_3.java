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