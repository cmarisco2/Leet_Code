

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