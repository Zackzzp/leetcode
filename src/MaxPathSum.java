public class MaxPathSum {
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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       maxGain(root);
       return maxSum;

    }
    public int maxGain(TreeNode root){
        if (root==null)
            return 0;
        int leftGain=Math.max(maxGain(root.left),0);
        int rightGain=Math.max(maxGain(root.right),0);

        int preNewPath=leftGain+rightGain+root.val;
        maxSum=Math.max(maxSum,preNewPath);

        return root.val+Math.max(leftGain,rightGain);
    }
}
