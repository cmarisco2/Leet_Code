//* Problem 128: Longest Consecutive Sequence
//! Meta-Note: This Problem is a variation of unordered array problems solved in linear time by using a set/hashmap to check for membership (consecutive/complement/etc)

//? Problem Statement:
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

//? Example
//? Input: nums = [100, 4, 200, 1, 3, 2];
//? Output = 4

package Arrays;
import java.util.HashSet;

//* Solution Concept:
    //? 1) Number Line Visualization(Human Intuition):
            //* If No Left Neighbor Exists -> Beginning of Sequence
            //* ....x,x,x,1,2,3,4,x,x,x....100....200....
    //? 2) Array -> Set
    //? 3) Iterate Array, member checking Left/Right Neighbors in Set (LN = Left Neighbor)
            //* IF Have LN -> continue;
            //* ELSE -> count RN present in Set.
    //* Time Complexity = O(N), O(N) Extra Space

class Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = arrayToSet(nums);

        int longestSeq = 0;
        int seqLength;
        for (int i = 0; i < nums.length; i++) {
            seqLength = 1;
            if (set.contains(nums[i] - 1))
                continue;
            while (set.contains(nums[i] + seqLength)) {
                seqLength++;
            }
            longestSeq = Math.max(longestSeq, seqLength);
        }
        return longestSeq;
    }

    private static HashSet<Integer> arrayToSet(int[] nums) {
        HashSet<Integer> set = new HashSet(nums.length);
        for (int w : nums)
            set.add(w);
        return set;
    }

    public static void main(String[] args){
        int [] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.print('[');
        for(int w: nums)
            System.out.print(w + ", ");
        System.out.println("]");

        System.out.println("The longest consecutive sequence length is: " + longestConsecutive(nums));
    }
}