import java.util.LinkedList;
import java.util.List;

//? LeetCode Problem 102: Binary Tree Level Order Traversal
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

//?Examples: 
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

//? Solution Notes:
//* Basic BFS to solve the problem. Key Takeaways:
    //* 1) Use LinkedLists as concreted data type queues.
    //* 2) Because Q len changes dynamically, store its length at each level.

//? Solution Approach:
//* Initialize: Preload Queue, while Queue not empty
    //* Create sublist
    //! store length of Queue
    //* loop for length of Queue:
        //* Dequeue, add to sublist, add children (left to right) to queue.


//? TC -> O(N) as we visit each Node once.
//? SC -> O(N) as the queue will store at most N/2 elements.
class BinaryTreeLevelOrderTraversal_102{
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(); //List of sublists
        LinkedList<TreeNode> q = new LinkedList<>(); //Queue

        q.add(root); //Preload

        //While then For-loop w/Fixed length (BFS pattern)
        while (q.size() > 0) {
            List<Integer> subList = new LinkedList<>(); //sublist

            int length = q.size();

            for (int i = 0; i < length; i++) {
                TreeNode x = q.remove();
                if (x != null) {
                    subList.add(x.val);
                    q.add(x.left);
                    q.add(x.right);
                }
            }
            if (subList.size() > 0)
                result.add(subList);
        }
        return result;
    }
}