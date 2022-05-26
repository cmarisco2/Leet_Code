import java.util.LinkedList;

public class SlidingWindowMaximum{
    LinkedList<Integer> q = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        // edge case
        if (k == 1)
            return nums;

        // iterators for the window
        int left = 0, right = k - 1;

        // array to hold result
        int index = 0;
        int[] resultArray = new int[nums.length - (k - 1)];

        // prim queue with first k items
        for (int i = 0; i < k; i++) {
            addToQ(nums[i]);
        }

        while (right < nums.length) {
            // if(nums[left] == q.getFirst()) result.add(q.removeFirst());
            if (nums[left] == q.getFirst())
                resultArray[index++] = q.removeFirst();
            // else result.add(q.getFirst());
            else
                resultArray[index++] = q.getFirst();
            left++;
            right++;
            if (right >= nums.length)
                break;
            addToQ(nums[right]);
        }

        return resultArray;
    }

    public void addToQ(int next) {
        while (!q.isEmpty() && next > q.peekLast())
            q.pollLast();
        q.add(next);
    }
}