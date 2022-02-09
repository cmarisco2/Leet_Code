import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class MinimumWindowSubstring_76{
    public static String minWindow(String s, String t) {
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int i = 0, j = 0, minLength = Integer.MAX_VALUE, startIndex = Integer.MAX_VALUE;


        for (int k = 0; k < t.length(); k++) {
            set.add(t.charAt(k));
        }
        while (j < s.length()) {
            if (t.length() > s.length())
                return "";
            char jChar = s.charAt(j);
            while (!set.contains(jChar) && map.size() == 0) {
                j++;
                i++;
                if (j >= s.length())
                    return "";
                jChar = s.charAt(j);
            }

            if (set.contains(jChar)) {
                list.add(j);
                map.put(jChar, j);
                char testKey = s.charAt(i);
                while (i != map.get(testKey)) {
                    i = list.remove();
                    testKey = s.charAt(i);
                }
            }

            if (set.size() == map.size() && (j - i + 1) < minLength) {
                minLength = j - i + 1;
                startIndex = i;
            }

            j++;
        }
        if (minLength != Integer.MAX_VALUE)
            return s.substring(startIndex, startIndex + minLength);
        return "";
    }

    public static void main(String[]args){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}