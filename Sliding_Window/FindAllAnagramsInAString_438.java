import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class FindAllAnagramsInAString_438{
    public static List<Integer> findAnagrams(String s, String p) {
        // Data Structures needed
        HashMap<Character, Integer> p_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        int i = 0, j = 0, have = 0, need = p.length();

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
        // for(int k = 0; k < 3; k++){
        //     System.out.println("p_map contains: " + p_map.containsKey(p.charAt(k)) + " with a count of: " + p_map.get(p.charAt(k)));
        // }
        while (j < s.length()) {
            char jChar = s.charAt(j);
            if (p_map.containsKey(jChar)) {
                if (p_map.get(jChar) > s_map.get(jChar))
                    have++;
                s_map.put(jChar, s_map.get(jChar) + 1);
            }

            while (have >= need) {
                char iChar = s.charAt(i);
                if (p_map.containsKey(iChar)) {
                    s_map.put(iChar, s_map.get(iChar) - 1);
                    if (s_map.get(iChar) < p_map.get(iChar)) {
                        have--;
                        result.add(i);
                    }
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