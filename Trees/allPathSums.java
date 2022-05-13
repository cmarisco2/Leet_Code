import java.util.LinkedList;
import java.util.List;

//TreeNode Class used:
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class allPathSums{
    /**Global list of lists to hold all found lists */
    public static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        dfsSum(root, 0, targetSum, new LinkedList<>());
        return result;
    }

    public static void dfsSum(TreeNode x, int sum, int target, LinkedList<Integer> subList ){
        /**null base case */
        if(x == null) return;

        /**Adds to list down the tree */
        sum += x.val;
        subList.add(x.val);

        /**Adds list to result if target sum is found */
        if(x.right == null && x.left == null && (sum == target)){
            result.add((LinkedList<Integer>)subList.clone());
        } 
        /**recurse left and right subtrees */
        dfsSum(x.left, sum, target, subList);
        dfsSum(x.right, sum, target, subList);

        /**This portion removes the value from the stack and list on the way up the recursive calls */
        sum-=x.val;
        subList.removeLast();

    }

    public static void main(String[] args){
        /** Builds tree from the link: https://i.imgur.com/nB7z8jI.png */
        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(16);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(6);
        root.left.right = new TreeNode(9);

        pathSum(root, 26);

        /**Prints each list on a separate line */
        for(List<Integer> li : result){
            System.out.println(li.toString());
        }
    }
}