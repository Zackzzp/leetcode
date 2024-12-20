import java.util.HashMap;
import java.util.Map;

public class PathSum {

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

    //深度优先搜索
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;

    }

    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    //前缀和
    public int pathSun1(TreeNode root,int targetSum){
        Map<Long,Integer> prefix=new HashMap<>();
        prefix.put(0L,1);
        return dfs(root,prefix,0,targetSum);
    }
    public int dfs(TreeNode root, Map<Long,Integer> prefix,long curr,int targetSum){
        if (root==null)
            return 0;
        int ret=0;
        curr+=root.val;

        ret=prefix.getOrDefault(curr-targetSum,0);
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        ret+=dfs(root.left,prefix,curr,targetSum);
        ret+=dfs(root.right,prefix,curr,targetSum);
        prefix.put(curr,prefix.getOrDefault(curr,0)-1);

        return ret;
    }

}
