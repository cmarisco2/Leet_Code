//* Problem 387: First Unique Character in a String
//* Difficulty: EASY
//! Problem Type: Frequency Counter.
//! ---Typically solved by using a map/set in linear time

//? Problem Statement:

//Given a string s,find the first non-repeating character in it and return its index.
//If it does not exist,return-1.

//? Example 1
//? Input: s = 'loveleetcode';
//? Output: 2

//? Example 2
//? Input: s = 'aabb';
//? Output: -1

// ? SOLUTION Notes:
// * 1) Construct HashMap where KEYS = Chars, VALUES = Ints
// * 2) Loop over String, adding characters as keys.
// *    --If char is NOT in map -> value = 1;
// *    --If char IS in map -> value++;
// * 3) Loop over String, checking each char in the map,
// *    --if value == 1, return index.
// * Return -1.


package Strings;
import java.util.HashMap;

class FirstUniqChar_387 {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Loop 1 - Construct Map - Counts frequencies of character occurences.
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        // Loop 2 - Check for first repeat
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.get(key) == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args){
        String s = "loveleetcode";
        if(firstUniqChar(s) >= 0){
            System.out.println("The first non-repeated character in string \"" + s + "\" appears at index: " + firstUniqChar(s));
        }
    }
}