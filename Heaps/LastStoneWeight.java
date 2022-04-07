


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