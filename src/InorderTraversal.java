import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
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

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    //迭代
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        Deque <TreeNode> stack=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
        root=stack.pop();
        ans.add(root.val);
        root=root.right;
    }
        return ans;
    }
}
