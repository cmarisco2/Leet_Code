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