import java.util.HashMap;
import java.util.Map;

//暴力解法
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length-2; i++) {
            for (int j = i+1; j <=nums.length-1 ; j++) {
                if (nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
    return new int[]{};
    }
    public int[] twoSum1(int []nums,int target){
        Map<Integer,Integer> numMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target-nums[i]))
                return new int[]{numMap.get(target-nums[i]),i};
            numMap.put(nums[i],i);
        }
        return new int[0];
    }
}
