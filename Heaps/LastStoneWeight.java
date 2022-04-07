//? Leetcode Problem 1046: Last Stone Weight
//? Difficulty: 'Easy'
//? Description: 

// You are given an array of integers stones where stones[i]is the weight of the ith stone.

// We are playing a game with the stones.On each turn,we choose the heaviest two stones and smash them together.Suppose the heaviest two stones have weights x and y with x<=y.The result of this smash is:

// If x==y,both stones are destroyed,and If x!=y,the stone of weight x is destroyed,and the stone of weight y has new weight y-x.At the end of the game,there is at most one stone left.

// Return the smallest possible weight of the left stone.If there are no stones left,return 0.

//? Example:
// Input: stones = [2,7,4,1,8,1]
// Output: 1
// Explanation: 
// We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
// we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
// we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
// we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

//? Solution Approach: Priority Queue
//* 1) Create a MaxHeap PQ.
//* 2) Add all elements of array into the queue.
//* 3) While pq size > 1
    //* dq twice, storing the values
    //* insert the difference back into the pq.
    //* pq will be of size 1 when the loop terminates.
//* 4) return last value in the pq.

import java.util.Collections;
import java.util.PriorityQueue;

class LastStoneWeight{
    public int lastStoneWeight(int[] stones) {
        //* Create Priority Queue to hold the stones' weight.
        //* MaxHeap so the heaviest will be the first polled.
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        //* Place all the weights in the queue
        for (int stone : stones)
            maxPQ.add(stone);

        //* Loop variables
        //* x & y defined in problem.
        //* result = diff of y - x, which is added to the priority queue.
        int y, x, result;

        //* Behaves exactly as the problem describes.
        //* Queue removes 2 heaviest elements. Subtracts their diff. Adds only result
        //* back (which implicitly 'destroys' the other stone).
        //* repeats until only 1 value remains.
        while (maxPQ.size() > 1) {
            y = maxPQ.poll();
            x = maxPQ.poll();
            result = y - x;
            maxPQ.add(result);
        }

        //* return last element.
        return maxPQ.poll();

    }
}