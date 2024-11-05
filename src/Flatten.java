import java.util.*;

public class Flatten {
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

    //前序遍历 递归
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        int size=list.size();
        for (int i = 1; i <size ; i++) {
            TreeNode prev=list.get(i-1),curr=list.get(i);
            prev.left=null;
            prev.right=curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
    //前序遍历 迭代
    public void flatten1(TreeNode root){
        List<TreeNode> list=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode node=root;
        while (node!=null||!stack.isEmpty()){
            while(node!=null)
            {
                list.add(node);
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            node=node.right;
        }
        int size=list.size();
        for (int i = 1; i <size ; i++) {
            TreeNode prev=list.get(i-1),curr=list.get(i);
            prev.left=null;
            prev.right=curr;
        }
    }

    //前序遍历和展开同时进行
    public void flatten2(TreeNode root){
        if (root==null)
            return;
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        TreeNode prev=null;
        while (!stack.isEmpty()){
            TreeNode curr=stack.pop();
            if (prev!=null){
                prev.left=null;
                prev.right=curr;
            }
            TreeNode left=curr.left,right=curr.right;
            if (right!=null){
                stack.push(right);
            }
            if (left!=null){
                stack.push(left);
            }
            prev=curr;
        }
    }

    //寻找前驱节点
    public void flatten3(TreeNode root){
        TreeNode curr=root;
        while(curr!=null){
            if (curr.left!=null){
                TreeNode next=curr.left;
                TreeNode predecessor=next;
                while (predecessor.right!=null){
                    predecessor=predecessor.right;
                }
                predecessor.right= curr.right;
                curr.left=null;
                curr.right=next;
            }
            curr=curr.right;
        }

    }
}
