public class MaxProduct {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF = new long[length];
        long[] minF = new long[length];
        for (int i = 0; i < length; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }
        for (int i = 1; i < length; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.min(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            if (minF[i] < (-1 << 31)) {
                minF[i] = nums[i];
            }
        }
        int ans = (int) maxF[0];
        for (int i = 1; i < length; i++) {
            ans = Math.max(ans, (int) maxF[i]);
        }
        return ans;
    }

    //使用滚动数组进行优化
    public int maxProduct1(int[] nums) {
        long maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            long mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            if (minF < (-1 << 31)) {
                minF = nums[i];
            }
            ans = Math.max((int) maxF, ans);
        }
        return ans;
    }
}
