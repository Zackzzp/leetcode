import com.sun.source.tree.BreakTree;

public class FirstMissingPositive {
    //仿哈表表标记
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //把负数转换为n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0)
                nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n)
                nums[num - 1] = -Math.abs(nums[num - 1]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
    //置换
    public int firstMissingPositive1(int []nums){
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            while(nums[i]>0&&nums[i]<=n&&nums[i]!=nums[nums[i]-1]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

}
