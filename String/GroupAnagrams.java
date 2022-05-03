import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GroupAnagrams{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Set<Character>, List<String>> setMap = new HashMap<>();
        List<List<String>> result = new LinkedList<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Set<Character> set = new HashSet<>();
            for (char ch : charArray) {
                set.add(ch);
            }

            if (!setMap.containsKey(set)) {
                setMap.put(set, new LinkedList<>());
            }
            List<String> list = setMap.get(set);
            list.add(str);
            setMap.put(set, list);
        }

        // iterate over hashmap and add each list to the result list.
        for (var entry : setMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}