//? Leetcode Problem 239: Sliding Window Maximum
//? Difficulty: 'Hard'
//? Description:

// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

//? Examples:
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

// Input: nums = [1], k = 1
// Output: [1]

//? Solution Notes: Sliding Window w/ Deque
//* Use Deque(linkedlist) -> monotonically decreasing queue
    //* When adding to back of list -> pop elements less than the one being added.
    //* When iterating through window -> if the value at front of deque == front of the window (leftmost element) 
        //* add it to output and remove from deque
        //* else -> cpy front of deque to output


//? Time Complexity: O(N)

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