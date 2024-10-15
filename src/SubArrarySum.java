import java.util.*;

public class SubArrarySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                count += map.get(map.get(pre - k));
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}

