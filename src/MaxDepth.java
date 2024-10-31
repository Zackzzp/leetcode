import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxDepth {
    private class TreeNode {
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

    //深度优先
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    //广度优先
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size > 0) {
                TreeNode node = stack.poll();
                if (node.left != null)
                    stack.offer(node.left);
                if (node.right != null) {
                    stack.offer(node.right);
                }
                size--;

            }
            ans++;
        }
        return ans;
    }
}
