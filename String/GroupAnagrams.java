import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class GroupAnagrams{
    public List<List<String>> groupAnagrams(String[] strs) {
        // use List<Integer> in place of array as key
        Map<List<Integer>, List<String>> setMap = new HashMap<>();

        // returned list
        List<List<String>> result = new LinkedList<>();
        // map for lower-case letters
        int R = 26;

        for (String str : strs) {
            int[] charCount = new int[R];
            char[] charArray = str.toCharArray();
            for (char ch : charArray) {
                charCount[ch - 'a']++;
            }
            // convert int[] into List<Integer>
            List<Integer> count = new LinkedList<>();
            for (int i : charCount) {
                count.add(i);
            }

            if (!setMap.containsKey(count)) {
                setMap.put(count, new LinkedList<>());
            }
            List<String> list = setMap.get(count);
            list.add(str);
            setMap.put(count, list);
        }

        // iterate over hashmap and add each list to the result list.
        for (var entry : setMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}