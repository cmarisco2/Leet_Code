import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TopFrequentKelements {
    public int[] topKFrequent(int[] nums, int k) {

        // Frequency Counting HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Resultant list that will be returned as an array
        ArrayList<Integer> result = new ArrayList<>();

        // Right most pointer
        int R = nums.length;

        // Create and initialize count array
        List<Integer>[] count = (LinkedList<Integer>[]) new LinkedList[nums.length + 1];
        for (int i = 0; i < count.length; i++) {
            count[i] = new LinkedList<>();
        }

        // Count element frequencies -> freq map
        for (int x : nums) {
            if (map.containsKey(x))
                map.replace(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }

        // Add the frequencies to the count array
        for (int x : map.keySet()) {
            int freq = map.get(x);
            List<Integer> li = count[freq];
            li.add(x);
        }

        // Count top K Elements
        // Add to result list
        while (k > 0 && R > 0) {
            List<Integer> current = count[R];
            if (!current.isEmpty()) {
                for (int num : current) {
                    result.add(num);
                    k--;
                }
            }
            R--;
        }

        // Convert ArrayList to Array
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int num : result) {
            resultArray[index] = num;
            index++;
        }

        // Return Array
        return resultArray;

    }
}