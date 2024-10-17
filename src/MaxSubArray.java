import java.util.*;

public class MaxSubArray {
    //动态规划
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
//分治
    public class Status {
        public int lsum, rsum, isum, msum;

        public Status(int lsum, int rusm, int isum, int msum) {
            this.isum = isum;
            this.lsum = lsum;
            this.rsum = rusm;
            this.msum = msum;
        }
    }

    public Status pushUp(Status l,Status r){
        int isum=l.isum+r.isum;
        int lsum=Math.max(l.lsum,l.isum+r.lsum);
        int rsum=Math.max(r.rsum,l.rsum+r.isum);
        int msum=Math.max(Math.max(l.msum,r.msum),l.isum+r.lsum);
        return new Status(lsum,rsum,isum,msum);

    }

    public Status getInfo(int []nums,int l,int r){
        if (l==r){
            return new Status(nums[l],nums[l],nums[l],nums[l]);
        }
        int m=(l+r)>>1;
        Status lSub=getInfo(nums,l,m);
        Status rSub=getInfo(nums,m,r);
        return pushUp(lSub,rSub);
    }

    public int maxSubArray1(int []nums){
        return getInfo(nums,0,nums.length-1).msum;
    }
}
