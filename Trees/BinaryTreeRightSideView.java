//? Leetcode Problem 199: Binary Tree Right Side View
//? Difficulty: 'Medium'
//? Description:
// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

//? Examples:
// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

// Input: root = [1,null,3]
// Output: [1,3]

// Input: root = []
// Output: []

//? Solution Approach:
//* BFS Level Order Traversal - Add last element to result List */

//? Algorithm:
//* 1) Preload Queue with Root -> Handle Edge Case Root == null by return List
//* 2) While (Q Not Empty):
        //* Add Last Element Value to List 
        //* STORE Q SIZE in Variable 
        //* for(Fixed Q SIZE)
            //* remove front element 
            //* add its left & right children (if not null) 
        //* 
//* 3) return List

//? Time Complexity - O(N)
//? Space Complexity - O(H)
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        int qSize = 0;

        if (root == null)
            return result;
        // BFS
        // Pre-load queue
        q.add(root);
        // Standard While NOT Empty Queue Loop
        while (!q.isEmpty()) {
            // Normal Case
            result.add(q.getLast().val);
            // Store Q Size before mutating the queue
            qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode x = q.removeFirst();
                if (x.left != null)
                    q.add(x.left);
                if (x.right != null)
                    q.add(x.right);
            }
        }
        return result;
    }
}