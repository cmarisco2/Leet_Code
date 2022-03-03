//? LeetCode Problem 1448: Count Good Nodes in Binary Tree
// Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

// Return the number of good nodes in the binary tree.

//? Example:
// Input: root = [3,1,4,3,null,1,5]
// Output: 4
// Explanation: Nodes in blue are good.
// Root Node (3) is always a good node.
// Node 4 -> (3,4) is the maximum value in the path starting from the root.
// Node 5 -> (3,4,5) is the maximum value in the path
// Node 3 -> (3,1,3) is the maximum value in the path.

//? Solution Approach: 
//* Top Down DFS
//* increment count (global scope)
//* Pass reference maximum down tree.

//? Solution Notes:
//* 1) count being global allows recursive helper function to make permanent change on a primitive type.
//* 2) x == null, just return.
//* 3) if x.val >= the current max in its path, count++, set new max
    //* -This max is repealed when recursed, and allows separate paths to have different maximums.

//? Time Complexity = O(N), Space Complexity = O (Tree - Height in Call Stack)

class CountGoodNodes_BinaryTree_1448{
    int count = 0; //Global counter that is incremented in helper function.
    /**
     * Top level function that returns the value to solve the problem.
     * @param root is the Tree's given source node
     * @return 'count' is the number of 'Good Nodes' as defined by the problem statement.
     */
    public int goodNodes(TreeNode root){
        goodNode(root, root.val);
        return count;
    }
    /**
     * Helper function that counts the Good Nodes
     * 
     * @param x is the current node being visited
     * @param ref is the running max at this time. if its smaller or equal to the current node's value, count++ and ref = Node x's value. recurse.
     */
    public void goodNode(TreeNode x, int ref){
        if (x == null) return;
        if (x.val >= ref){
            count++;
            ref = x.val;
        }
        goodNode(x.left, ref);
        goodNode(x.right, ref);
    }
}
