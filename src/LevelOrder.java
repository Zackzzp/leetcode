import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    class TreeNode {
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
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentSize = stack.size();
            for (int i = 1; i <= currentSize; i++) {
                TreeNode p = stack.poll();
                level.add(p.val);
                if (p.left != null) {
                    stack.offer(p.left);
                }
                if (p.right != null) {
                    stack.offer(p.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
